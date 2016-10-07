package org.vamsi.restful.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.vamsi.restful.messenger.model.Message;
import org.vamsi.restful.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Integer,Message> messages = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();
	
	public static Map<Integer,Message> getMessages(){
		
		return messages;
	}
	
	public static Map<String,Profile> getProfiles(){
		
		return profiles;
	}
	
}
