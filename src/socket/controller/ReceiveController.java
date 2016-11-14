package socket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*
 * ws:// ~~/socket/conn.do
 * 
 */
public class ReceiveController extends TextWebSocketHandler { 
	
	List<WebSocketSession> slist;
	@PostConstruct
	public void init(){
		slist = new ArrayList<>();
	}
	
	// 접속했을 때 
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("연결 발생!");
		slist.add(session);
	}
	
	// 연결이 되고 있는 상태에서 데이터 주고받기
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		String m = (String)message.getPayload();
		System.out.println("메세지 받음!"+m);
		for(int i = 0 ; i < slist.size(); i++){
			//session.sendMessage(new TextMessage("all#"+m));
			slist.get(i).sendMessage(new TextMessage("all#"+m));
		}
	}
	
	// 연결 해제시
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		System.out.println("연결 해제!");
		slist.remove(session);
	}
	
}
