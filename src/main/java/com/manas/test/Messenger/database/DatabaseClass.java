package com.manas.test.Messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.manas.test.Messenger.model.Message;
import com.manas.test.Messenger.model.Profile;

public class DatabaseClass {
	public static Map<Long, Message> messages= new HashMap<Long, Message>();
	public static Map<Long, Profile> profiles= new HashMap<Long, Profile>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	public static Map<Long, Profile> getProfiles(){
		return profiles;
	}
}
