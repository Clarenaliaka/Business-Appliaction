package com.example.modernmum;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class AdvertScreenActivity extends Activity implements OnClickListener {
ImageButton ibstroller,ibnipo,ibdiaper,ibca,ibsa,ibcloth;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advert);
		
		//imageview = (ImageView) findViewById(R.id.imgmother);
		
		ibstroller = (ImageButton) findViewById(R.id.ibstroller);
		ibstroller.setOnClickListener(this);
		
		ibdiaper = (ImageButton) findViewById(R.id.ibbaby);
		ibdiaper.setOnClickListener(this);
		
		ibnipo = (ImageButton) findViewById(R.id.ibnipo);
		ibnipo.setOnClickListener(this);
		
		ibca = (ImageButton) findViewById(R.id.ibca);
		ibca.setOnClickListener(this);
		
		ibsa = (ImageButton) findViewById(R.id.ibsa);
		ibsa.setOnClickListener(this);
		
		ibcloth = (ImageButton) findViewById(R.id.ibcloth);
		ibcloth.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

	switch (v.getId()) {
	case R.id.ibstroller:
		Toast.makeText(AdvertScreenActivity.this, "enter a message", Toast.LENGTH_LONG).show();
		startActivity(new Intent(getApplicationContext(),ContactsScreenActivity.class));
		break;
		
	case R.id.ibbaby:
		Toast.makeText(AdvertScreenActivity.this, "enter a message", Toast.LENGTH_LONG).show();
		startActivity(new Intent(getApplicationContext(),ContactsScreenActivity.class));
		break;
		
	case R.id.ibnipo:
		Toast.makeText(AdvertScreenActivity.this, "enter a message", Toast.LENGTH_LONG).show();
		startActivity(new Intent(getApplicationContext(),ContactsScreenActivity.class));
		break;
		
	case R.id.ibca:
		Toast.makeText(AdvertScreenActivity.this, "enter a message", Toast.LENGTH_LONG).show();
		startActivity(new Intent(getApplicationContext(),ContactsScreenActivity.class));
		break;

	case R.id.ibsa:
		Toast.makeText(AdvertScreenActivity.this, "enter a message", Toast.LENGTH_LONG).show();
		startActivity(new Intent(getApplicationContext(),ContactsScreenActivity.class));
		break;

	case R.id.ibcloth:
		Toast.makeText(AdvertScreenActivity.this, "enter a message", Toast.LENGTH_LONG).show();
		startActivity(new Intent(getApplicationContext(),ContactsScreenActivity.class));
		break;

	default:
		break;
	}		
}
	
}


