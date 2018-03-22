package com.ssm.common.plugins.websocket;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.java_websocket.WebSocket;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ssm.business.user.vo.UserVO;
import com.ssm.common.model.WebSocketUserVO;
import com.ssm.common.util.DateUtils;
import com.ssm.common.util.SpringApplicationContextUtil;
import com.ssm.services.user.UserService;

@Service
@Scope("singleto")
public class ChatServer extends WebSocketServer{
	
	private UserService userService = (UserService)SpringApplicationContextUtil.getBean("UserService");
	
	public ChatServer(int port) throws UnknownHostException {
		super(new InetSocketAddress(port));
	}

	public ChatServer(InetSocketAddress address) {
		super(address);
	}

	/**
	 * 触发连接事件
	 */
	@Override
	public void onOpen( WebSocket conn, ClientHandshake handshake ) {
	}

	/**
	 * 触发关闭事件
	 */
	@Override
	public void onClose( WebSocket conn, int code, String reason, boolean remote ) {
		WebSocketUserVO user = ChatServerPool.getUser(conn);
		ChatServerPool.removeSocket(conn);
		parentClose(user);
	}
	
	private void parentClose(WebSocketUserVO user){
		JSONObject json = new JSONObject();
		json.put("type", "removeOneUser");
		json.put("user", user);
		ChatServerPool.sendAllParentMessage(json.toString());
	}
	
	/**
	 * 客户端发送消息到服务器时触发事件
	 */
	@Override
	public void onMessage(WebSocket conn, String message){
		JSONObject jsonobject = JSONObject.fromObject(message);
		String type = jsonobject.get("type") == null ? "" : jsonobject.get("type").toString();
		if("create".equals(type)){
			createSocket(conn, message);
		}else{
			//发送内容
			chatMessage(conn, message);
		}
		
	}
	
	private void chatMessage(WebSocket conn, String message){
		JSONObject jsonobject = JSONObject.fromObject(message);
		String fromUserId = jsonobject.getString("fromUserId").trim();
		String toUserId = jsonobject.getString("toUserId").trim();
		String content = jsonobject.getString("content");
		JSONObject msg = new JSONObject();
		msg.put("fromUserId", fromUserId);
		msg.put("toUserId", toUserId);
		msg.put("content", content);
		msg.put("sendTime", DateUtils.getUnixTimeMis());
		msg.put("type", "message");
		msg.put("headPic", ChatServerPool.getUserById(fromUserId).getHeadPic());
		msg.put("nickName", ChatServerPool.getUserById(fromUserId).getNickname());
		//向双方推送消息
		ChatServerPool.sendMessage(ChatServerPool.getWebSocket(fromUserId+"to"+toUserId), msg.toString());
		ChatServerPool.sendMessage(ChatServerPool.getWebSocket(toUserId+"to"+fromUserId), msg.toString());
	}
	
	public void createSocket(WebSocket conn, String message){
		JSONObject jsonobject = JSONObject.fromObject(message);
		String socketType = jsonobject.get("socketType") == null ? "" : jsonobject.get("socketType").toString();
		//parent  children
		if("parent".equals(socketType)){
			//登录之后创建parent websocket对象
			String userId = jsonobject.getString("userId");
			String nickname = jsonobject.getString("nickname");
			WebSocketUserVO userVO = new WebSocketUserVO();
			userVO.setUserId(Long.parseLong(userId));
			userVO.setNickname(nickname);
			userVO.setHeadPic(jsonobject.getInt("headPic"));
			ChatServerPool.setParentSocket(conn, userVO);
			//向所有在线用户推送上线信息
			sendAllParentMessage(userId, nickname,userVO.getHeadPic());
			//获取所有在线列表
			List<WebSocketUserVO> parentList = ChatServerPool.getAllParent(userId);
			JSONObject result = new JSONObject();
			result.put("type", "initParentUserList");
			result.put("userList", JSONArray.fromObject(parentList).toString());
			sendUserMessageBySocket(conn, result.toString());
		}else{
			//创建children websocket对象
			String fromUserId = jsonobject.getString("fromUserId");
			String toUserId = jsonobject.getString("toUserId");
			UserVO fromUserVO = userService.getUserByPK(Long.parseLong(fromUserId));
			UserVO toUserVO = userService.getUserByPK(Long.parseLong(toUserId));
			ChatServerPool.setChildrenSocket(conn, fromUserVO, toUserVO);
		}
	}
	
	public void sendUserMessageBySocket(WebSocket socket, String message){
		ChatServerPool.sendMessage(socket, message);
	}
	
	public void sendAllParentMessage(String userId, String nickname,Integer headPic){
		JSONObject result = new JSONObject();
		result.put("type", "insertUser");
		result.put("nickname", nickname);
		result.put("userId", userId);
		result.put("headPic", headPic);
		ChatServerPool.sendAllParentMessage(result.toString(), userId);
		
	}
	
	
	public void onFragment( WebSocket conn, Framedata fragment ) {
	}

	/**
	 * 触发异常事件
	 */
	@Override
	public void onError( WebSocket conn, Exception ex ) {
		ex.printStackTrace();
		if( conn != null ) {
		}
	}

}

