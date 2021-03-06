package com.example.modernmum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;


public class SplashScreenActivity extends Activity {
	private static int SPLASH_TIME_OUT = 2000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		        new Handler().postDelayed(new Runnable() {
		        	/*
		             * Showing splash screen with a timer. This will be useful when you
		             * want to show case your app logo / company
		             */
		 
		            @Override
		            public void run() {
		                // This method will be executed once the timer is over
		                // Start your app main activity
		                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
		                startActivity(i);
                        Toast.makeText(SplashScreenActivity.this, "ModernMum" , Toast.LENGTH_SHORT).show();
		 
		                // close this activity
		                finish();
		            }
		        }, SPLASH_TIME_OUT);
		
	}

	
}
