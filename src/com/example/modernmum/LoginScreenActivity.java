package com.example.modernmum;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.utility.modernmum.constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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
		myconstants = new constants(getApplicationContext());
		
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
			break;
			}
			}
	//validating email id
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




		
		
	

	

