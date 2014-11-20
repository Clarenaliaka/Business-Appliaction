package com.example.modernmum;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import com.model.modermum.user;
import com.utility.modernmum.SessionManager;
import com.utility.modernmum.SqliteOpenHelper;
import com.utility.modernmum.UserFunctions;
import com.utility.modernmum.constants;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.UserManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class LoginScreenActivity extends Activity implements OnClickListener {
	//declaration
Button btnback,btnsubmit;
EditText etemail,etpassword,etregemail,etregpassword;
CheckBox chkpassword;
user UserModel;
private static String TAG = LoginScreenActivity.class.getSimpleName();
constants myconstants;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		etemail = (EditText) findViewById(R.id.etemail);
		etpassword = (EditText) findViewById(R.id.etpassword);
		
		btnback = (Button) findViewById(R.id.btnlogback);
		btnback.setOnClickListener(this);
		
		btnsubmit = (Button) findViewById(R.id.btnlogsubmit);
		btnsubmit.setOnClickListener(this);
		//instantiation
		//myconstants = new constants(getApplicationContext());
        /*UserModel = new user ();
		
		
		UserModel.setEmail(etregemail.getText().toString());
		UserModel.setPassword(etregpassword.getText().toString());*/
		
		chkpassword = (CheckBox) findViewById(R.id.chkpassword);
		chkpassword.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (!isChecked) {
					//show password
					etpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
					
				} else {
					//hide password
					etpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				}
				
			}
		});
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
        case R.id.btnlogsubmit:

			if(etemail.getText().toString().equals("") || (etpassword.getText().toString().equals(""))){

			 if (etemail.getText().toString().equals("")) {
				Toast.makeText(getApplicationContext(), "Please enter the email", Toast.LENGTH_SHORT).show();
			}
			else if (etpassword.getText().toString().equals("")) {
				Toast.makeText(getApplicationContext(), "Please enter the password", Toast.LENGTH_SHORT).show();
			}
		
			else if (!etemail.getText().toString().equals(etregemail.getText().toString())) {
				Toast.makeText(getApplicationContext(), "Please enter the correct email", Toast.LENGTH_SHORT).show();
			}
			else if (!etpassword.getText().toString().equals(etregpassword.getText().toString())) {
				Toast.makeText(getApplicationContext(), "Please enter the correct password", Toast.LENGTH_SHORT).show();
			}
			
			else if(etemail.getText().toString().equals(etregemail.getText().toString()) && etpassword.getText().toString().equals(etregpassword.getText().toString())){
				Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
			}
			}
			else{startActivity(new Intent(getApplicationContext(),HomeScreenActivity.class));
			}
			
		    break;
        case R.id.btnlogback:
			startActivity(new Intent(getApplicationContext(),HomeScreenActivity.class));
			break;
			
        default:
        	Log.e(TAG, "we have a problem.Sermon @code_wizard!!!");
			break;
			}
			}
	 private class LoginAsyncTask extends AsyncTask<String, Void, JSONObject>{
		 ProgressDialog progressDialog;
		 @Override
		 protected void onPreExecute() {
		 super.onPreExecute();
		 progressDialog = new ProgressDialog(LoginScreenActivity.this);
		 progressDialog.setMessage("Logging in ....");
		 progressDialog.setCancelable(false);
		 progressDialog.show();
		 }
		 @Override
		 protected JSONObject doInBackground(String... params) {
		 UserFunctions userFunction = new UserFunctions();
		 return userFunction.LoginUser(UserModel.getEmail(), UserModel.getPassword());
		 }
		 @Override
		 protected void onPostExecute(JSONObject jsonObject) {
		 super.onPostExecute(jsonObject);
		 if(progressDialog.isShowing()){
		 progressDialog.dismiss();
		 }
		 try {
		 if (jsonObject.getString(constants.kEY_JSON_SUCCESS) != null) {
		 String res = jsonObject.getString(constants.kEY_JSON_SUCCESS);
		 if(Integer.parseInt(res) == 1){
		 // user successfully logged in
		 // Store user details in SQLite Database
		SqliteOpenHelper db = new SqliteOpenHelper(getApplicationContext());
		 JSONObject json_user = jsonObject.getJSONObject("user");
		 UserModel.setEmail(json_user.getString(constants.kEY_JSON_EMAIL));
		 UserModel.setPassword(json_user.getString(constants.kEY_JSON_PASSWORD));
		
		 // Clear all previous data in database
		 db.AddUserDetails(UserModel);
		 // Launch Home Screen
		 Intent intentHomeScreen = new Intent(getApplicationContext(), HomeScreenActivity.class);
		 // Close all views before launching Dashboard
		 intentHomeScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		 startActivity(intentHomeScreen);
		 displayToastMessage("Welcome");
		 // Close Login Screen
		 finish();
		 }else{
		 // Error in login
		 displayToastMessage("Incorrect username/password");
		 }
		 }
		 } catch (JSONException e) {
		 e.printStackTrace();
		 }
		 }
		 }
		 /**
		 * @param message Message to be displayed
		 */
		 public void displayToastMessage(String message) {
		 Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
		 }
		 

	
			private boolean isValidEmail(String email) {
				String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

				Pattern pattern = Pattern.compile(EMAIL_PATTERN);
				Matcher matcher = pattern.matcher(email);
				return matcher.matches();
			}

			// validating password with retype password
			private boolean isValidPassword(String pass) {
				if (pass != null && pass.length() > 6) {
					return true;
				}
				return false;
			}
		}



