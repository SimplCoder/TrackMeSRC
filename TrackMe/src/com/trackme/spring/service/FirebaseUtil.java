package com.trackme.spring.service;

import java.util.Map;

import com.firebase.client.Firebase;

public class FirebaseUtil {
	public static void writeToList(String url, Map<String, Object> map) {
		long num = 1;//RandomNumberGenerator.generate();
		Firebase listRef = new Firebase(url + "/data/");
		map.put("_id", num);
		Firebase push = listRef.child("" + num);
		push.setValue(map);
	}
}
