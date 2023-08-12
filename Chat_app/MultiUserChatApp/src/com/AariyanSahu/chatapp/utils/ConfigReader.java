package com.AariyanSahu.chatapp.utils;

import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxSession.ResetOrBuilder;

public class ConfigReader {
	
	ConfigReader() {}
	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	public static String getValue(String key) {
		return rb.getString(key);
	}
}
