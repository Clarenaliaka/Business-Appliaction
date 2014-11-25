package com.example.modernmum;





import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
	Button btnlogin,btnregister;
	TextView tvdes;
	private static final int DIALOG_ALERT = 10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		btnlogin = (Button) findViewById(R.id.btnlogin);
		btnlogin.setOnClickListener(this);
		
		btnregister = (Button) findViewById(R.id.btnregister);
		btnregister.setOnClickListener(this);

		
	}

	@Override
	public void onClick(View v) {
		showDialog(DIALOG_ALERT);
	switch (v.getId()) {
	
    case R.id.btnregister:
	    Toast.makeText(MainActivity.this, "register" , Toast.LENGTH_SHORT).show();
		
	   startActivity(new Intent(getApplicationContext(),RegisterScreenActivity.class));
		
		break;
    case R.id.btnlogin:
		Toast.makeText(MainActivity.this, "login" , Toast.LENGTH_SHORT).show();
		
		startActivity(new Intent(getApplicationContext(),LoginScreenActivity.class));
		break;
	default:
		break;
	}
	}
	public void signIn(View V)
    {
         final Dialog dialog = new Dialog(MainActivity.this);
         dialog.setContentView(R.layout.login);
         dialog.setTitle("Login");

         // get the Refferences of views
         final  EditText etmail=(EditText)dialog.findViewById(R.id.etemail);
         final  EditText etpassword=(EditText)dialog.findViewById(R.id.etpassword);
        
         btnlogin=(Button)dialog.findViewById(R.id.btnlogin);
		
	}

	
}


