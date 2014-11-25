package com.utility.modernmum;

import android.content.Context;
import android.content.SharedPreferences;

public class constants {
	
	public static final int DELAY_TIME = 2500;
	public static final String LOCALHOST_URL = "http://192.168.44.58/html/Akirachix/?";
	public static final String LOGIN_TAG = "login";
	public static final String REGISTER_TAG = "register";

	//shared preference

		public static final String KEY_NAMES="names";
		public static final String KEY_PHONE="phone number";
		public static final String KEY_EMAIL="email";
		public static final String KEY_PASSWORD="password";
		public static final String KEY_PREFS_NAME="myprefs";
		
		public constants() {
			// TODO Auto-generated constructor stub
		}
		//JSON Response node names
		public static String kEY_JSON_SUCCESS = "success";
		public static String kEY_JSON_ERROR = "error";
		public static String kEY_JSON_ERROR_MSG = "error_msg";
		public static String kEY_JSON_UID = "uid";
		public static String kEY_JSON_NAMES = "names";
		public static String kEY_JSON_EMAIL = "email";
		public static String kEY_JSON_PASSWORD = "password";
		public static String kEY_JSON_CONFIRM = "confirm password";
		public static String kEY_JSON_PHONE= "phone";
		public static String kEY_JSON_LOCATION = "location";
		public static String kEY_JSON_CREATED_AT = "created_at";
		
		{
			
		}

}
