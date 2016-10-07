package org.vamsi.restful.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.vamsi.restful.messenger.database.DatabaseClass;
import org.vamsi.restful.messenger.model.Message;

public class MessageService {

	public MessageService(){
		messages.put(1, new Message(1,"Hello Rest", "Vamsi"));
		messages.put(2, new Message(2,"Hello webservices", "Krishna"));
	}
	private static Map<Integer,Message> messages = DatabaseClass.getMessages();
	
	
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for(Message message:messages.values()){
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getMessagesPaginated(int start, int size){
		List<Message> messagesPaginated = new ArrayList<>(messages.values());
		if(start+size>messagesPaginated.size()) 
			return messagesPaginated;
		return messagesPaginated.subList(start, size+start);
	}
	
	public Message getMessage(int id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(int id){
		return messages.remove(id);
	}
	
	
}
