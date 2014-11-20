package com.example.modernmum;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import android.widget.Toast;


public class ProActivity extends Activity implements OnItemSelectedListener {
Spinner product;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro);
		
		
		
		product=(Spinner) findViewById(R.id.product);
		//Spinner on click
		product.setOnItemSelectedListener(this);
		//This are my spinner drop down elements
		List<String> list = new ArrayList<String>();
		list.add("choose products");
		list.add(" Baby Stroller");
        list.add("Baby's Romper");
        list.add("Diaper Bag");
        list.add("Diaper");
        list.add("Plush Duck Toy Baby Blanket");
        list.add("Baby Rattle");
        list.add("Baby Bottle Bank ");
        list.add("Sunscreen Lotion");
        list.add("Pajamas & Leggings for Babies");
        list.add("Baby Toys Games");
        //design
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//attaching data adapter to spinners
		product.setAdapter(dataAdapter);
		
		
		
		
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
	//on selecting a spinner item
		String item = parent.getItemAtPosition(position).toString();
		Toast.makeText(ProActivity.this, "product : "+ String.valueOf(product.getSelectedItem()), Toast.LENGTH_LONG).show();
		switch (position) {
		case 1:
			startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
			break;
			
		case 2:
			startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	         break;
	         
	     case 3:
	    	 startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	        break;

         case 4:
        	 startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	        break;

           case 5:
        	startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	       break;

            case 6:
            	startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	        break;
	        
            case 7:
            	startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	        break;
            case 8:
            	startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	        break;

            case 9:
            	startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	        break;

            case 10:
            	startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	        break;

            case 11:
            	startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
	        break;


		}
        
	}
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
	
		
	}
	}

	

