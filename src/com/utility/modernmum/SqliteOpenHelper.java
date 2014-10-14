package com.utility.modernmum;

import android.R.string;
import android.content.Context;

public class SqliteOpenHelper {
	
	public static final String DATABASE_NAME = "register.db";
	public static final String TABLE_NAME = "registers";
	public static final int DATABASE_VERSION = 1;
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_FIRST = "first name";
	public static final String COLUMN_LAST = "last name";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_CONFIRM = "confirm password";
	public static final String COLUMN_PHONE = "phone number";
	
	//creating database
	public static final String DATABASE_CREATE = "create table"
			 + TABLE_NAME + "(" + COLUMN_ID
		      + " integer primary key autoincrement, " + COLUMN_FIRST
		      + " text," + COLUMN_LAST +" text,"+ COLUMN_EMAIL +" " +
		      "text," +COLUMN_PASSWORD +
		      " text,"+COLUMN_CONFIRM +" text,"+ COLUMN_PHONE +" text );";
	
	public SqliteOpenHelper(Context context){
		super();
	}
	
	
	
}


