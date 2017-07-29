package com.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rest.messenger.bootstrap.MessengerBootstrap;
import com.rest.messenger.model.Profile;

public class ProfileService {

	private Map<String,Profile> profiles = MessengerBootstrap.getProfiles();
	
	public List<Profile> getProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(String profileName,Profile profile) {
		profile.setId(profiles.get(profileName).getId());
		profile.setProfileName(profileName);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public void deleteProfile(String profileName) {
		profiles.remove(profileName);
	}
	
} 
