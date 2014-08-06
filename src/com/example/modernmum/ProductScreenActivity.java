package com.example.modernmum;



import java.util.ArrayList;
import java.util.Arrays;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProductScreenActivity extends Activity implements OnItemClickListener {

	
		//Declaration
		private ListView listview;
		private android.widget.ArrayAdapter<String> stringArrayAdapter;
		String[] lists ={" Baby Stroller "," Baby's Romper ","Diaper Bag","Diaper","Play Gym",
				" Plush Duck Toy Baby Blanket "," Baby Rattle ","Baby Bottle Bank ","Baby Cloth Diapers "," Sunscreen Lotion","Pajamas & Leggings for Babies ","Baby Toys Games"};
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.product);
			
			//Initialization
		
			listview = (ListView) findViewById(R.id.list);
			ArrayList<String> List = new ArrayList<String>();
			List.addAll(Arrays.asList(lists));
			//Design the ListView
			stringArrayAdapter = new ArrayAdapter<String>(this,R.layout.simple_layout, List);
	        listview.setAdapter(stringArrayAdapter);
	        listview.setOnItemClickListener(this);
		}
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			String ListData = listview.getItemAtPosition(position).toString();
			switch (position) {
			case 0:
				startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
				break;
				
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


			default:
				break;
			}
			
			
	}

}
