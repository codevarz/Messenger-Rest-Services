package org.vamsi.restful.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vamsi.restful.messenger.database.DatabaseClass;
import org.vamsi.restful.messenger.model.Profile;


public class ProfileService {

	
	public ProfileService(){
		profiles.put("vamsi", new Profile(1,"vamsi","vamsi","kakuru"));
	}
	
	private static Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public List<Profile> getAllProfiles(){
		
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile Profile){
		Profile.setId(profiles.size()+1);
		profiles.put(Profile.getProfileName(), Profile);
		return Profile;
	}
	
	public Profile updateProfile(Profile Profile){
		if(Profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(Profile.getProfileName(), Profile);
		return Profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}
