package com.tang.bigcat.admin.modular.system.notice;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import javax.servlet.http.HttpSession;
import java.util.Map;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * 用户登陆之后往设置session设置登陆名，之后跳转到发送消息页面；
 * 加载页面时创建websocket连接，这时，springmvc拦截器拦截到websocket请求，
 * 把session中登陆名保存到attributes中；
 * 这个值会映射到WebSocketSession里，从而在SpringWebSocketHandler类中使用
 * HttpSession-->WebSocketSession
 * @author tangcaiji
 *
 */

public class HandshakeInterceptordemo extends HttpSessionHandshakeInterceptor {
	
	//初次握手访问前
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
		System.out.println("Before Handshake::初次握手访问前");
		
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			if (session != null) {
				// 使用userName区分WebSocketHandler，以便定向发送消息
				String userName = (String) session.getAttribute("SESSION_USERNAME"); // 一般直接保存user实体
				//if (userName != null) {
					//attributes.put("WEBSOCKET_USERID", userName);//session中登陆名保存到attributes
					
					//--------------------模拟登录名开始---------------------
					
					attributes.put("WEBSOCKET_USERID", session.getId());
					
					//--------------------模拟登录名结束---------------------
					
				//}

			}
		}
		return super.beforeHandshake(request, response, wsHandler, attributes);

	}
	
	//初次握手访问后
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		
		System.out.println("初次握手访问后");
		super.afterHandshake(request, response, wsHandler, ex);
	}

}
