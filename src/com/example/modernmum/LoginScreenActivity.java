package com.example.modernmum;


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
EditText etemail,etpassword;
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
		case R.id.btnlogback:
			startActivity(new Intent(getApplicationContext(),MainActivity.class));
			break;
        case R.id.btnlogsubmit:

			if(etemail.getText().toString().equals("") &&etpassword .getText().toString().equals("")){
				Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
			}
			else if (etemail.getText().toString().equals("")) {
				Toast.makeText(getApplicationContext(), "Please enter the email", Toast.LENGTH_SHORT).show();
			}
			else if (etpassword.getText().toString().equals("")) {
				Toast.makeText(getApplicationContext(), "Please enter the password", Toast.LENGTH_SHORT).show();
			}
		
			else if (!etemail.getText().toString().equals(etemail)) {
				Toast.makeText(getApplicationContext(), "Please enter the correct email", Toast.LENGTH_SHORT).show();
			}
			else if (!etpassword.getText().toString().equals(etpassword)) {
				Toast.makeText(getApplicationContext(), "Please enter the correct password", Toast.LENGTH_SHORT).show();
			}
			
			else if(etemail.getText().toString().equals("") && etpassword.getText().toString().equals("")){
				Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
			}
			startActivity(new Intent(getApplicationContext(),HomeScreenActivity.class));
			break;

		default:
			break;
		}
		
	}

	
}
