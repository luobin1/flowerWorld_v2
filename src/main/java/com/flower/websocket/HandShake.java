
package com.flower.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.flower.entity.User;

/**
 * ���к�������Э�飩
 */
public class HandShake implements HandshakeInterceptor {

	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		System.out.println("Websocket:�û�[ID:" + ((ServletServerHttpRequest) request).getServletRequest().getSession(false).getAttribute("uid") + "]�Ѿ���������");
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			// ����û�
			String uid = session.getId();
			User u = (User) session.getAttribute("user");
			int manage = 0; 
			if(u!=null)
				 manage=u.getU_id();
			
			if(uid!=null){
				attributes.put("uidlzp", uid);
				attributes.put("manage", manage);
			}else{
				return false;
			}
		}
		return true;
	}
	
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
	}

}
