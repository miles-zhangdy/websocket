/**
 * 聊天js
 * 
 */

initParentWebSocket();
function initParentWebSocket(){
	
	if (window.WebSocket) {
		var parentWebsocket = new WebSocket(encodeURI('ws://'+window.location.host.replace(":"+window.location.port, "")+':8888'));
		parentWebsocket.onopen = function() {
			//连接成功
			var message = {
				"type":"create",
				"socketType":"parent",
				"userId":userId,
				"nickname":nickName,
				"headPic":headPic
			};
			parentWebsocket.send(JSON.stringify(message));
		}
		parentWebsocket.onerror = function() {
			
		}
		parentWebsocket.onclose = function() {
			
		}
		parentWebsocket.onmessage = function(message) {
			var message = JSON.parse(message.data);
			if(message.type == 'insertUser'){
				//有用户登录
				var userItem = '';
				userItem += '<a href="javascript:void(0)"  onclick="chooseUserChat(\''+message.userId+'\',\''+message.nickname+'\')" id="chata'+message.userId+'"><div class="inbox-item">';
				userItem += '<div class="inbox-item-img"><img src="static/chat/images/users/avatar-'+message.headPic+'.jpg"class="img-circle" alt="">';
				userItem += '</div><p class="inbox-item-author">'+message.nickname+'</p>';
				userItem += '<p class="inbox-item-text">new message</p>';
				userItem += '<p class="inbox-item-date">new</p></div></a>';
				$("#userList").append(userItem);
			}else if(message.type == "initParentUserList"){
				//初始化用户列表
				var initUserList = message.userList;
				$.each(initUserList, function(index, items){
					var userItem = '';
					userItem += '<a href="javascript:void(0)" onclick="chooseUserChat(\''+items.userId+'\',\''+items.nickname+'\')" id="chata'+items.userId+'"><div class="inbox-item">';
					userItem += '<div class="inbox-item-img"><img src="static/chat/images/users/avatar-'+items.headPic+'.jpg"class="img-circle" alt="">';
					userItem += '</div><p class="inbox-item-author">'+items.nickname+'</p>';
					userItem += '<p class="inbox-item-text">new message</p>';
					userItem += '<p class="inbox-item-date">new</p></div></a>';
					$("#userList").append(userItem);
				});
			}else if(message.type == "removeOneUser"){
				var userId = message.user.userId;
				$("#chata"+userId).remove();
				if($("#chatdiv"+userId) != undefined){
					$("#chatdiv"+userId).remove();
				}
			}
		}
	}
}


function chooseUserChat(toUserId,tonickname){
	var fromto = userId + "to" + toUserId;
	var chatdiv = $("#chatdiv"+fromto);
	if(chatdiv != undefined && chatdiv != null && chatdiv.length != 0){
		//已经创建
		$('div[alt="chatdiv"]').attr('class', '').hide();
		$("#chatdiv" + fromto).attr('class', 'col-md-6').show();
	}else{
		//创建websocket对象
		createChildrenSocket(toUserId,tonickname);
	}
}

var childrenSocket = {};

function createChildrenSocket(toUserId,tonickname){
	if (window.WebSocket) {
		var fromto = userId + "to" + toUserId;
		var oneWebsocket = new WebSocket(encodeURI('ws://'+window.location.host.replace(":"+window.location.port, "")+':8888'));
		childrenSocket[toUserId] = oneWebsocket;
		oneWebsocket.onopen = function() {
			//连接成功
			var message = {
				"type":"create",
				"socketType":"children",
				"fromUserId":userId,
				"toUserId":toUserId
			};
			oneWebsocket.send(JSON.stringify(message));
			var chatDiv = '';
			chatDiv += '<div class="col-md-6" id="chatdiv'+fromto+'" alt="chatdiv">';
			chatDiv += '<div class="card-box"><h4 class="m-t-0 m-b-20 header-title"><b>'+tonickname+'</b></h4>';
			chatDiv += '<div class="chat-conversation"><ul class="conversation-list nicescroll" id="nicescroll'+fromto+'"></ul>';
			chatDiv += '<div class="row"><div class="col-sm-9 chat-inputbar">';
			chatDiv += '<input type="text" class="form-control chat-input" name="sendContent" placeholder="Enter your text"></div>';
			chatDiv += '<div class="col-sm-3 chat-send">';
			chatDiv += '<button type="button" class="btn btn-md btn-info btn-block waves-effect waves-light"';
			chatDiv += ' onclick="sendMessage($(this),\''+toUserId+'\')">发送</button>';
			chatDiv += '</div></div></div></div></div>';
			$("div[alt='chatdiv']").attr('class','').hide();
			$("#chatContainer").append(chatDiv);
			
		}
		oneWebsocket.onerror = function() {
			
		}
		oneWebsocket.onclose = function() {
			
		}
		oneWebsocket.onmessage = function(message) {
			var message = JSON.parse(message.data);
			if(message.type == 'message'){
				//通话  odd
				var li = '';
				if(message.fromUserId == userId){
					li += '<li class="clearfix odd"><div class="chat-avatar">';
				}else{
					li += '<li class="clearfix"><div class="chat-avatar">';
				}
				if(message.fromUserId == userId){
					li += '<img src="static/chat/images/users/avatar-'+headPic+'.jpg" alt="Female">';
				}else{
					li += '<img src="static/chat/images/users/avatar-'+message.headPic+'.jpg" alt="male">';
				}
				li += '<i>'+fmtTime(message.sendTime, 'HH:mm:ss')+'</i>';
				li += '</div><div class="conversation-text"><div class="ctext-wrap">';
				if(message.fromUserId == userId){
					li += '<i>'+nickName+'</i>';
				}else{
					li += '<i>'+message.nickName+'</i>';
				}
				li += '<p>'+message.content+'</p>';
				li += '</div></div></li>';
				$("#chatdiv"+fromto).find('ul').append(li);
				$.Components.init();
				document.getElementById("nicescroll"+fromto).scrollTop = document.getElementById("nicescroll"+fromto).scrollHeight;;
			}
		}
	}
}

function sendMessage(obj, toUserId){
	var socket = childrenSocket[toUserId];
	var content = obj.parent().parent().find("input[name='sendContent']").val();
	if(content == '' ||content==null||content==undefined){
		alert('请输入发送内容');
		return false;
	}
	var message = {
			"type":'message',
			"fromUserId" : userId,
			"toUserId":toUserId,
			"content":content
	}
	socket.send(JSON.stringify(message));
	obj.parent().parent().find("input[name='sendContent']").val('');
}


function fmtTime(ms, formatter) {
	if (ms == null) {
		return "";
	}
	var date = new Date();
	date.setTime(ms);
	var year = date.getFullYear();
	var month = toDouble(date.getMonth() + 1);
	var day = toDouble(date.getDate());
	var hour = toDouble(date.getHours());
	var tHour = parseInt(hour) < 12 ? parseInt(hour) : parseInt(hour) - 12;
	var minute = toDouble(date.getMinutes());
	var second = toDouble(date.getSeconds());
	switch (formatter) {
	case 'yyyy-mm-dd':
		return year + '-' + month + '-' + day;
		break;
	case 'yyyy-mm-dd hh:mm:ss':
		return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':'
				+ second;
		break;
	case 'yyyy-mm-dd HH:mm:ss':
		return year + '-' + month + '-' + day + ' ' + tHour + ':' + minute
				+ ':' + second;
		break;
	case 'HH:mm:ss':
		return tHour + ':' + minute
				+ ':' + second;
		break;
	default:
		return;
		break;
	}
}

function toDouble(num) {
	return num < 10 ? '0' + num : num;
}


