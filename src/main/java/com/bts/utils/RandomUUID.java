package com.bts.utils;

import java.util.UUID;

public class RandomUUID {
	
	public static String get() {
		String token = UUID.randomUUID().toString();
		return token;
	}
}
