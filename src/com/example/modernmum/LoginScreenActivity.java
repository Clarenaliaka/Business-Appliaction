package com.example.modernmum;


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
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class LoginScreenActivity extends Activity implements OnClickListener {
Button btnback,btnsubmit;
EditText etemail,etpassword;
CheckBox chkpassword;
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
			startActivity(new Intent(getApplicationContext(),HomeScreenActivity.class));
			break;

		default:
			break;
		}
		
	}

	
}
