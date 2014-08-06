package com.example.modernmum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ContactsScreenActivity extends Activity implements OnClickListener {

Button btncoback,btncosubmit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		
		
		btncoback = (Button) findViewById(R.id.btncoback);
		btncoback.setOnClickListener(this);
		
		btncosubmit = (Button) findViewById(R.id.btncosubmit);
		btncosubmit.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btncoback:
			startActivity(new Intent(getApplicationContext(),ProductScreenActivity.class));
			
			break;
        case R.id.btncosubmit:
        	startActivity(new Intent(getApplicationContext(),MainActivity.class));
			break;

		default:
			break;
		}
		
	}

}
