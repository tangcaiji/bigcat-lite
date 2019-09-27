package com.tang.bigcat.admin.modular.system.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class HandshakeInterceptordemo implements HandshakeInterceptor {
    private HttpSession session;     // 初次握手访问前

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse,
                                   WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
            String sessionId = servletRequest.getSession().getId();//获取浏览器的sessionid
            String username = (String) servletRequest.getSession().getAttribute("name");
            System.out.println("获取session里面的name-------------------" + username);
            // 使用userName区分WebSocketHandler，以便定向发送消息
            /* String userName = (String)*/
            //session.getAttribute("WEBSOCKET_USERNAME");
            map.put("WEBSOCKET_USERNAME", username);
            servletRequest.getSession().setAttribute("WEBSOCKET_USERNAME", username);
        }
        return true;
    }
    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }

}
