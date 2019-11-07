package io.yosep.agile.socket;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import io.yosep.agile.task.domain.dao.TaskDAO;
import io.yosep.agile.task.domain.dto.TaskDTO;

public class KanbanSocket extends TextWebSocketHandler {
	private Map<String, LinkedList<WebSocketSession>> sprintUsers = new ConcurrentHashMap<>();
	@Autowired
	TaskDAO taskDAO;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("connected");
		Map<String, Object> map = session.getAttributes();
//		Iterator<String> itr = map.keySet().iterator();
		
//		while(itr.hasNext()) {
//			String key = itr.next();
//			System.out.println(key + ": " + map.get(key));
//		}
		
		String sprintId = (String)map.get("sprintId");
		System.out.println((String)map.get("userId"));
		System.out.println("스프린트: " + sprintId);
		if(sprintUsers.getOrDefault(sprintId, null) == null) {
			sprintUsers.put(sprintId, new LinkedList<WebSocketSession>());
		}
		
		LinkedList<WebSocketSession> users = sprintUsers.get(sprintId);
		users.add(session);
		
		super.afterConnectionEstablished(session);
	}



	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		String msg = message.getPayload();
//		int indexReg = msg.indexOf(",");
		String[] str = msg.split("\\|");
		
//		String item = msg.substring(0, indexReg);
//		String dropTarget = msg.substring(indexReg+1,msg.length());
		Map<String, Object> map = session.getAttributes();
		String sprintId = (String)map.get("sprintId");
		
		TaskDTO taskDTO = new TaskDTO();
		System.out.println(str.length);
		taskDTO.setTaskId(str[0]);
		taskDTO.setTaskStatus(str[1]);
		System.out.println(str[0]);
		System.out.println(str[1]);
		taskDAO.updateRealTimeTask(taskDTO);
		
		LinkedList<WebSocketSession> users = sprintUsers.get(sprintId);
//		
		System.out.println("msg: " + msg);
		
		for(WebSocketSession user : users) {
			if(user != session)
				user.sendMessage(message);
		}
		
		super.handleTextMessage(session, message);
	}



	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = session.getAttributes();
		String sprintId = (String)map.get("sprintId");
		LinkedList<WebSocketSession> users = sprintUsers.get(sprintId);
		
		users.remove(session);
		
		System.out.println("closed");
		super.afterConnectionClosed(session, status);
	}
	
}
