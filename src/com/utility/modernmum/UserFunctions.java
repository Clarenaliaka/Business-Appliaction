package com.utility.modernmum;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;

import com.network.modernmum.JSONParser;

public class UserFunctions {
private JSONParser jsonParser;
private Context context;

//constructor
public UserFunctions(){
	jsonParser = new JSONParser();
}
//the function to make login Request
public JSONObject LoginUser(String names,String email,String password,String phonenumber,String location, String string) {
	List<NameValuePair> params = new ArrayList<NameValuePair>();
	params.add(new BasicNameValuePair("tag", constants.REGISTER_TAG));
	params.add(new BasicNameValuePair("names", names));
	params.add(new BasicNameValuePair("email", email));
	params.add(new BasicNameValuePair("password", password));
	params.add(new BasicNameValuePair("phone",phonenumber));
	params.add(new BasicNameValuePair("location", location));
	
	//Return a JSON Object
	return jsonParser.getJSONFromUrl(constants.LOCALHOST_URL, params);
}
	//
	public boolean UserLoggedIn(Context context){
	SqliteOpenHelper db = new SqliteOpenHelper(context);
	int count = db.getRowCount();
	return count>0;
}
//function to logout user
//Reset Database
	public boolean logoulUser(Context context) {
	SqliteOpenHelper db = new SqliteOpenHelper(context);
	db.resetTables();
	return true;
}
	public JSONObject LoginUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}	
}
