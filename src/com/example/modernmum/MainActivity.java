package com.example.modernmum;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
	Button btnlogin,btnregister;
	TextView tvdes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvdes = (TextView) findViewById(R.id.tvdes);
		
		btnlogin = (Button) findViewById(R.id.btnlogin);
		btnlogin.setOnClickListener(this);
		
		btnregister = (Button) findViewById(R.id.btnregister);
		btnregister.setOnClickListener(this);

		
	}

	@Override
	public void onClick(View v) {
	switch (v.getId()) {
	
    case R.id.btnregister:
	    Toast.makeText(MainActivity.this, "modernmum" , Toast.LENGTH_SHORT).show();
		
	   startActivity(new Intent(getApplicationContext(),RegisterScreenActivity.class));
		
		break;
    case R.id.btnlogin:
		Toast.makeText(MainActivity.this, "welcome to the world of application" , Toast.LENGTH_SHORT).show();
		
		startActivity(new Intent(getApplicationContext(),LoginScreenActivity.class));
		break;
	default:
		break;
	}
		
	}

	
}
