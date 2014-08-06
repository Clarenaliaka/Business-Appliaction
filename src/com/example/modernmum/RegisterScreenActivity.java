package com.example.modernmum;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
				case R.id.btnback:
					startActivity(new Intent(getApplicationContext(),MainActivity.class));
					break;
					
               case R.id.btnsubmit:
					startActivity(new Intent(getApplicationContext(),HomeScreenActivity.class));
					break;
				default:
					break;
				}
				// TODO Auto-generated method stub
				
			}
	}

	

