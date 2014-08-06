package com.example.modernmum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class HomeScreenActivity extends Activity implements OnClickListener {
Button btnadvert,btnchat,btnbuy;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		btnadvert = (Button) findViewById(R.id.btnadvert);
		btnadvert.setOnClickListener(this);
		
		btnchat = (Button) findViewById(R.id.btnchat);
		btnchat.setOnClickListener(this);
		
		btnbuy = (Button) findViewById(R.id.btnbuy);
		btnbuy.setOnClickListener(this);
		
		
		
	}
	@Override
	public void onClick(View v) {
	switch (v.getId()) {
	case R.id.btnadvert:
		startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
		break;
case R.id.btnchat:
	startActivity(new Intent(getApplicationContext(),ChatScreenActivity.class));
	break;
case R.id.btnbuy:
	startActivity(new Intent(getApplicationContext(),ProductScreenActivity.class));
	break;


	default:
		break;
	}
		
	}

}
