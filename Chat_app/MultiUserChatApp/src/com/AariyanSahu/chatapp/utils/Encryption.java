package com.AariyanSahu.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
	
	public static String passwordencrypt(String plainpassword) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String encryptedPassword = null;
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(plainpassword.getBytes());
		byte[] encrypt = messageDigest.digest();
		StringBuffer sBuffer = new StringBuffer();
		for(byte b : encrypt) {			
			sBuffer.append(b);
		}
		encryptedPassword = sBuffer.toString();
		//System.out.println("Encrypted Password: "+encryptedPassword);
		return encryptedPassword;
	}
	
}
