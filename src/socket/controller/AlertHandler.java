package socket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class AlertHandler extends TextWebSocketHandler {
	List<WebSocketSession> slist;
	@PostConstruct
	public void init() {
		slist = new ArrayList<>();
	}
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		slist.add(session);
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		slist.remove(session);
	}
	
	public void sendMessageToAll(String m) {
		for(int i=0; i<slist.size(); i++) {
			WebSocketSession session =slist.get(i);
				try {
					session.sendMessage(new TextMessage(m));
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
}




