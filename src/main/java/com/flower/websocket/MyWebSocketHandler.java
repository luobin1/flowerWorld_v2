package com.flower.websocket;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSONObject;
import com.flower.entity.Message;



@Component
public class MyWebSocketHandler implements WebSocketHandler {
	public static final Map<String, WebSocketSession> userSocketSessionMap;

	static {
		userSocketSessionMap = new HashMap<String, WebSocketSession>();
	}

	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		String uid =  (String) session.getAttributes().get("uidlzp");
		Integer manage =  (Integer) session.getAttributes().get("manage");
		if (userSocketSessionMap.get(uid) == null) {
			if(manage==1){
				userSocketSessionMap.put("manage", session);
				sendPerson("manage");
			}
			else{
			   userSocketSessionMap.put(uid, session);
			   Message message = new Message();
			   message.setFrom(uid);
			   message.setId("1");
			   sendMessageToUser("manage",new TextMessage(JSONObject.toJSONString(message)));
			}
			  
		}
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		   //用户发过来的消息的长度	
		   if(message.getPayloadLength()==0)return;
			Message msg=JSONObject.parseObject(message.getPayload().toString(),Message.class);
			msg.setDate(new Date());
			sendMessageToUser(msg.getTo(),new TextMessage(JSONObject.toJSONString(msg)));
	}

	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap
				.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户ID" + entry.getKey());
				 Message message = new Message();
				   message.setFrom(entry.getKey());
				   message.setId("2");
				   sendMessageToUser("manage",new TextMessage(JSONObject.toJSONString(message)));
				break;
			}
		}
	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		System.out.println("Websocket:" + session.getId() + "已经关闭");
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap
				.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户ID" + entry.getKey());
				Message message = new Message();
				   message.setFrom(entry.getKey());
				   message.setId("2");
				   sendMessageToUser("manage",new TextMessage(JSONObject.toJSONString(message)));
				break;
			}
		}
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	

	/**
	 * 给某个用户发送消息
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(Long uid, TextMessage message)
			throws IOException {
		WebSocketSession session = userSocketSessionMap.get(uid);
		if (session != null && session.isOpen()) {
			session.sendMessage(message);
		}
	}
	
	/**
	 * 给某个用户发短信
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(String to,TextMessage message)
			throws IOException {
		WebSocketSession session = userSocketSessionMap.get(to);
		if (session != null && session.isOpen()) {
			session.sendMessage(message);
		}
			
	}
	
	/**
	 * 统计多少人在线
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendPerson(String to)
			throws IOException {
		Message message = new Message();
		   message.setId("1");
	
		WebSocketSession session = userSocketSessionMap.get(to);
		if (session != null && session.isOpen()) {
			for(String sessions : userSocketSessionMap.keySet())
				if(!sessions.equals("manage")){
					message.setFrom(sessions);
					session.sendMessage(new TextMessage(JSONObject.toJSONString(message)));
				}
			      
		}
			
		
		
	}

}
