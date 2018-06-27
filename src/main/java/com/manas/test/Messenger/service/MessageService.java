package com.manas.test.Messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.manas.test.Messenger.database.DatabaseClass;
import com.manas.test.Messenger.model.Message;
import com.manas.test.Messenger.model.Profile;

public class MessageService {
	
	private Map<Long, Message> messages= DatabaseClass.getMessages();
	private static Map<Long,Profile> profiles= DatabaseClass.getProfiles();
	
	public MessageService(){
		messages.put(1L, new Message(1,"Hello First","Manas"));
		messages.put(2L, new Message(2,"Hello Second","Manas"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Message getMessage(long id){		
		return messages.get(id);
	}
	public Message addMessage(Message message){
		message.setId(messages.size()+1L);
		messages.put(message.getId(), message);
		return message;
	}
	public Message updateMessage(Message message){
		messages.put(message.getId(), message);
		return message;
	}
	
	public List<Message> getMessagesForYear(int year){
		if(year>=0){
			List<Message> messagesList=new ArrayList<Message>();
			Calendar cal= Calendar.getInstance();
			for(Message message:messages.values()){
				cal.setTime(message.getCreated());
				if(cal.get(Calendar.YEAR)==year){
					messagesList.add(message);
				}
			}
			return messagesList;
		}
		else
			return new ArrayList<Message>();
	}
	
	public List<Message> getMessagesPaginated(int start, int size){
		if(start+size>messages.size()){
			return new ArrayList<Message>();
		}else
			return getAllMessages().subList(start, start+size);
	}
}
