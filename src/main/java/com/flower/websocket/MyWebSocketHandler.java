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
	 * �������Ӻ�
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
	 * ��Ϣ�����ڿͻ���ͨ��Websocket API���͵���Ϣ�ᾭ�����Ȼ�������Ӧ�Ĵ���
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		   //�û�����������Ϣ�ĳ���	
		   if(message.getPayloadLength()==0)return;
			Message msg=JSONObject.parseObject(message.getPayload().toString(),Message.class);
			msg.setDate(new Date());
			sendMessageToUser(msg.getTo(),new TextMessage(JSONObject.toJSONString(msg)));
	}

	/**
	 * ��Ϣ���������
	 */
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap
				.entrySet().iterator();
		// �Ƴ�Socket�Ự
		while (it.hasNext()) {
			Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket�Ự�Ѿ��Ƴ�:�û�ID" + entry.getKey());
				 Message message = new Message();
				   message.setFrom(entry.getKey());
				   message.setId("2");
				   sendMessageToUser("manage",new TextMessage(JSONObject.toJSONString(message)));
				break;
			}
		}
	}

	/**
	 * �ر����Ӻ�
	 */
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		System.out.println("Websocket:" + session.getId() + "�Ѿ��ر�");
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap
				.entrySet().iterator();
		// �Ƴ�Socket�Ự
		while (it.hasNext()) {
			Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket�Ự�Ѿ��Ƴ�:�û�ID" + entry.getKey());
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
	 * ��ĳ���û�������Ϣ
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
	 * ��ĳ���û�������
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
	 * ͳ�ƶ���������
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
