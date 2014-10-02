package com.example.modernmum;


import java.util.ArrayList;
import java.util.List;


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

public class RegisterScreenActivity extends Activity implements OnItemSelectedListener, OnClickListener {
Spinner modern;
EditText etfirst,etlast,etregemail,etregpassword,etphone;
Button btnback,btnsubmit;
constants myconstants;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		etfirst = (EditText) findViewById(R.id.etfirst);
		etlast = (EditText) findViewById(R.id.etlast);
		etregemail= (EditText) findViewById(R.id.etregemail);
		etregpassword = (EditText) findViewById(R.id.etregpassword);
		etphone = (EditText) findViewById(R.id.etphone);
		
		btnback = (Button) findViewById(R.id.btnback);
		btnback.setOnClickListener(this);
		
		btnsubmit= (Button) findViewById(R.id.btnsubmit);
		btnsubmit.setOnClickListener(this);
		
		myconstants = new constants(getApplicationContext());
		
		//Spinner element
				modern=(Spinner) findViewById(R.id.modern);
				//Spinner on click
				modern.setOnItemSelectedListener(this);
				//This are my spinner drop down elements
				List<String> list = new ArrayList<String>();
		        list.add("location");
		        list.add("Westlands");
		        list.add("Ngong road");
		        list.add("Loresho");
		        list.add("Kasarani");
		        list.add("Karen");
		        list.add("langata");
		        list.add("Mt.View");
		        list.add("Uthiru");
		        list.add("Parklands");
		        list.add("Upper Hill");
		        list.add("Nairobi West");
		        list.add("South B");
		        list.add("South C");
		        
		    
		        //design
		        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
				dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				
				//attaching data adapter to spinners
				modern.setAdapter(dataAdapter);
				
				
				
				
			}
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position,
					long id) {
			//on selecting a spinner item
				String item = parent.getItemAtPosition(position).toString();
				Toast.makeText(RegisterScreenActivity.this, "modern: "+ String.valueOf(modern.getSelectedItem()), Toast.LENGTH_SHORT).show();
				 
		        
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			
				
			}
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				
	               case R.id.btnsubmit:
				
				if(etfirst.getText().toString().equals("") &&etlast .getText().toString().equals("") &&etregemail.getText().toString().equals("")
					&&etregpassword.getText().toString().equals("") &&etphone.getText().toString().equals("")){
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
				else if (etphone.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "Please enter the phonenumber", Toast.LENGTH_SHORT).show();
				}
				else if (!etfirst.getText().toString().equals(etfirst)) {
					Toast.makeText(getApplicationContext(), "Please enter the correct firstname", Toast.LENGTH_SHORT).show();
				}
				else if (!etlast.getText().toString().equals(etlast)) {
					Toast.makeText(getApplicationContext(), "Please enter the correct lastname", Toast.LENGTH_SHORT).show();
				}
				else if (!etregemail.getText().toString().equals(etregemail)) {
					Toast.makeText(getApplicationContext(), "Please enter the correct password", Toast.LENGTH_SHORT).show();
				}
				
				else if (!etregpassword.getText().toString().equals(etregpassword)) {
					Toast.makeText(getApplicationContext(), "Please enter the correct password", Toast.LENGTH_SHORT).show();
				}
				
				else if(etfirst.getText().toString().equals("") && etlast.getText().toString().equals("")&&etregemail.getText().toString().equals("")
						&&etregpassword.getText().toString().equals("") &&etphone.getText().toString().equals("")){
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
	

	

