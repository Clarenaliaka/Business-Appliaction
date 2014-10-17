package com.utility.modernmum;

import com.example.modernmum.LoginScreenActivity;

import android.R.string;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.GetChars;
//This class extends sqlite helper
public class SqliteOpenHelper extends SQLiteOpenHelper{
	//database fields
	
	public static final String DATABASE_NAME = "register.db";
	public static final String TABLE_NAME = "registers";
	public static final int    DATABASE_VERSION = 1;
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
		     + " integer primary key autoincrement, " 
		     
			 + COLUMN_FIRST + " text,"
			 
		     + COLUMN_LAST +" text,"
		     
			 + COLUMN_EMAIL +"text,"
			 
		     + COLUMN_PASSWORD +" text,"
		     
		     + COLUMN_CONFIRM +" text,"
		     
		     + COLUMN_PHONE +" text );";
	
	public SqliteOpenHelper(Context context){
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		
		
	}
 
	
   
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
		onCreate(db);
		
	}
	

	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
		onDowngrade(db, oldVersion, newVersion);
	}
	 
}


