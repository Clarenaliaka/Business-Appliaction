package com.example.modernmum;


import java.util.ArrayList;
import java.util.List;


import com.example.model.user;
import com.utility.modernmum.constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterScreenActivity extends Activity implements  OnClickListener {
EditText etfirst,etlast,etregemail,etregpassword,etphone,etlocation,etconfirm;
Button btnback,btnsubmit;
constants myconstants;
user UserModel;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		//instantiation
		UserModel = new user ();
		UserModel.setFirst(etfirst.getText().toString());
		UserModel.setLast(etlast.getText().toString());
		UserModel.setEmail(etregemail.getText().toString());
		UserModel.setPassword(etregpassword.getText().toString());
		UserModel.setConfirm(etconfirm.getText().toString());
		UserModel.setPhoneNumber(etphone.getText().toString());
		UserModel.setLocation(etlocation.getText().toString());
		
		etfirst = (EditText) findViewById(R.id.etfirst);
		etlast = (EditText) findViewById(R.id.etlast);
		etregemail= (EditText) findViewById(R.id.etregemail);
		etregpassword = (EditText) findViewById(R.id.etregpassword);
		etphone = (EditText) findViewById(R.id.etphone);
		etlocation= (EditText) findViewById(R.id.etlocation);
		etconfirm= (EditText) findViewById(R.id.etconfirm);
		
		btnback = (Button) findViewById(R.id.btnback);
		btnback.setOnClickListener(this);
		
		btnsubmit= (Button) findViewById(R.id.btnsubmit);
		btnsubmit.setOnClickListener(this);
		
		myconstants = new constants(getApplicationContext());
		
		
		        
			}
			
			@Override
			public void onClick(View v) {
				/*String first = "";
				String last = "";
				String PhoneNumber= "";
				String Email = "";
				String Password = "";
				String confirm= "";
				String Location = "";*/
				
				
				switch (v.getId()) {
	               case R.id.btnsubmit:
				
				if(etfirst.getText().toString().equals("") &&etlast .getText().toString().equals("") &&etregemail.getText().toString().equals("")
					&&etregpassword.getText().toString().equals("") &&etphone.getText().toString().equals("") &&etlocation.getText().toString().equals("")
					&&etconfirm.getText().toString().equals("")){
					Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
				}
				else if (etfirst.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "Please enter the firstname", Toast.LENGTH_SHORT).show();
				}
				else if (etlast.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "Please enter the lastname", Toast.LENGTH_SHORT).show();
				}
				else if (etregemail.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "Please enter the email", Toast.LENGTH_SHORT).show();
				}
				else if (etregpassword.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "Please enter the password", Toast.LENGTH_SHORT).show();
				}
				else if (etconfirm.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "Please confirm your password", Toast.LENGTH_SHORT).show();
				}
				else if (etphone.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "Please enter the phonenumber", Toast.LENGTH_SHORT).show();
				}
				else if (etlocation.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "Please enter the location", Toast.LENGTH_SHORT).show();
				}
				
				
				else if (!etconfirm.getText().toString().equals(etregpassword)) {
					Toast.makeText(getApplicationContext(), "password does not match", Toast.LENGTH_SHORT).show();
				}
				
				else if(etfirst.getText().toString().equals(etfirst.getText().toString()) && etlast.getText().toString().equals(etlast.getText().toString())&&etregemail.getText().toString().equals(etregemail.getText().toString())
						&&etregpassword.getText().toString().equals(etregpassword.getText()) &&etphone.getText().toString().equals(etphone.getText())){
					Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
				}
				startActivity(new Intent(getApplicationContext(),HomeScreenActivity.class));
				break;
				case R.id.btnback:
					startActivity(new Intent(getApplicationContext(),MainActivity.class));
					break;

				default:
					break;
				}
				
	}}
	

