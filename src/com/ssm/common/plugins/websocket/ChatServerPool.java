package com.ssm.common.plugins.websocket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.java_websocket.WebSocket;
import org.springframework.context.annotation.Scope;

import com.ssm.business.user.vo.UserVO;
import com.ssm.common.model.WebSocketUserVO;

@Scope("singleto")	
public final class ChatServerPool  {
	
	
	private static final ChatServerPool cart = new ChatServerPool();
	
	private ChatServerPool(){
		
	}
	
	public static ChatServerPool getInstence() {
		return cart;
	}
	//userId
	private static  Map<WebSocket, String> socketParentUserMap = new ConcurrentHashMap<WebSocket, String>();
	//userId
	private static  Map<String, WebSocket> userParentSocketMap = new ConcurrentHashMap<String, WebSocket>();
	//userIdtoUserId
	private static  Map<WebSocket, String> socketChildrenUserMap = new ConcurrentHashMap<WebSocket, String>();
	//userIdtoUserId
	private static  Map<String, WebSocket> userChildrenSocketMap = new ConcurrentHashMap<String, WebSocket>();
	//nickname
	private static Map<WebSocket, String> nameMap = new ConcurrentHashMap<WebSocket, String>();
	//
	private static  Map<WebSocket, Long> socketTimeMap = new ConcurrentHashMap<WebSocket, Long>();
	
	private static Map<WebSocket, WebSocketUserVO> userMap = new ConcurrentHashMap<WebSocket, WebSocketUserVO>();
	//0子对象 1父对象
	private static Map<WebSocket, Integer> socketTypeMap =  new ConcurrentHashMap<WebSocket, Integer>();
	
	
	public static String getUserId(WebSocket socket){
		return socketParentUserMap.get(socket);
	}
	
	
	public static WebSocketUserVO getUser(WebSocket socket){
		return userMap.get(socket);
	}
	
	public static WebSocketUserVO getUserById(String id){
		return userMap.get(userParentSocketMap.get(id));
	}
	
	public static WebSocketUserVO getChileren(String id){
		return userMap.get(userChildrenSocketMap.get(id));
	}
	
	public static WebSocket getWebSocket(String id){
		return userChildrenSocketMap.get(id);
	}
	
	public static List<WebSocketUserVO> getAllParent(String userId){
		List<WebSocketUserVO> list = new ArrayList<WebSocketUserVO>();
		Set<WebSocket> keySet = userMap.keySet();
		synchronized (keySet) {
			for (WebSocket conn : keySet) {
				WebSocketUserVO user = userMap.get(conn);
				if(user != null && !userId.equals(user.getUserId()+"")){
					list.add(userMap.get(conn));
				}
			}
		}
		return list;
	}
	
	public static void setChildrenSocket(WebSocket socket, UserVO formUserVO, UserVO toUserVO){
		socketChildrenUserMap.put(socket, formUserVO.getUserId()+"to"+toUserVO.getUserId());
		userChildrenSocketMap.put(formUserVO.getUserId()+"to"+toUserVO.getUserId(), socket);
		socketTimeMap.put(socket, new Date().getTime());
	}
	
	public static void setParentSocket(WebSocket socket, WebSocketUserVO userVO){
		socketParentUserMap.put(socket, userVO.getUserId() + "");
		userParentSocketMap.put(userVO.getUserId() + "", socket);
		nameMap.put(socket, userVO.getNickname());
		userMap.put(socket, userVO);
		socketTimeMap.put(socket, new Date().getTime());
		socketTypeMap.put(socket, 1);
	}
	public static void sendAllParentMessage(String message, String userId){
		Set<WebSocket> keySet = socketParentUserMap.keySet();
		synchronized (keySet) {
			for (WebSocket conn : keySet) {
				String user = socketParentUserMap.get(conn);
				if(user != null && !user.equals(userId)){
					conn.send(message);
				}
			}
		}
	}
	
	public static void sendAllParentMessage(String message){
		Set<WebSocket> keySet = socketParentUserMap.keySet();
		synchronized (keySet) {
			for (WebSocket conn : keySet) {
				String user = socketParentUserMap.get(conn);
				if(user != null){
					conn.send(message);
				}
			}
		}
	}
	
	public static void removeSocket(WebSocket conn){
		Integer socketType = socketTypeMap.get(conn);
		if(socketType != null && socketType == 1){
			String userId = socketParentUserMap.get(conn);
			userParentSocketMap.remove(userId);
			socketParentUserMap.remove(conn);
			nameMap.remove(conn);
			userMap.remove(conn);
			socketTypeMap.remove(conn);
			socketTimeMap.remove(conn);
		}else{
			userChildrenSocketMap.remove(socketChildrenUserMap.get(conn));
			socketChildrenUserMap.remove(conn);
			socketTimeMap.remove(conn);
		}
	}
	
	public static void sendMessage(WebSocket conn,String message){
		if(conn != null){
			conn.send(message);
		}
	}
	
	public static void sendMessage(String message){
		Set<WebSocket> keySet = socketParentUserMap.keySet();
		synchronized (keySet) {
			for (WebSocket conn : keySet) {
				String user = socketParentUserMap.get(conn);
				if(user != null){
					conn.send(message);
				}
			}
		}
	}
}
