package com.utility.modernmum;

import java.util.HashMap;

import com.example.modernmum.LoginScreenActivity;

import android.R.string;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.SyncStateContract.Constants;
import android.widget.EditText;

public class SessionManager {
	//declaration
	SharedPreferences sharedpreferences;
	Editor editor;
	SharedPreferences pref;
	Context _context;	
	
public void sessionmanager(Context context){
	//initialization
	this._context = context;
	//Instantiation the class constants
	;
	sharedpreferences = _context.getSharedPreferences(constants.KEY_PREFS_NAME, 0);
	
	SqliteOpenHelper dbOpenHelper = new SqliteOpenHelper(context);
}
//creating a Register session
	public void CreateRegisteruser(String email, String password,String username,
			String firstname,String lastname,String phonenumber)
	{
	editor.putString("constants.KEY_EMAIL",email);
	editor.putString("constants.KEY_PASSWORD",password);
	editor.putString("constants.KEY_FIRST",firstname);
	editor.putString("constants.KEY_LAST",lastname);
	editor.putString("constants.KEY_PHONE",phonenumber);
	editor.commit();
	}	
	//creating a login session
	public void CreateLoginSession(String email, String password){
		sharedpreferences.getString(constants.KEY_EMAIL,email);
		sharedpreferences.getString(constants.KEY_PASSWORD,password);
		editor.commit();
	}
	
	
	public void checkLogin(){
		//This is to check login status
		if (!this.equals(editor)) {
			//This is when the user is not logged in redirect the user to login screen
			Intent c = new Intent(_context,LoginScreenActivity.class);
			
			//Because the user was not logged in correctly this is closing all the activities
			c.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			//This is to add new flag to start activity
			c.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			//To start login activity
			_context.startActivity(c);
			
		}
	}
	
	public HashMap<String, String> getPrompterDetails() {
		HashMap<String, String> Prompter = new HashMap<String, String>();
		//user first name
		Prompter.put(constants.KEY_FIRST, null);
		//user last name
		Prompter.put(constants.KEY_LAST, null);
		//user phone number
		Prompter.put(constants.KEY_PHONE, null);
		//user email
		Prompter.put(constants.KEY_EMAIL, null);
		//user password
		Prompter.put(constants.KEY_PASSWORD, null);
		
		//return the user
		return Prompter;
		
	}
	
	
public void logoutPrompter(){
	//This is to clear all data  from shared preference
	editor.clear();
	editor.commit();
	//
	Intent c = new Intent(_context,LoginScreenActivity.class);
	//closing the activity
	c.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	
	//add flag to start activity
	
	c.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
	
	//
	_context.startActivity(c);
	
}
//check if the prompter is logged in
public boolean isLoggedIn(){
	return sharedpreferences.getBoolean(constants.KEY_PREFS_NAME, false);
}
}





