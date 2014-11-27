package com.example.modernmum;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

import android.widget.Button;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class AdvtwoScreenActivity<ByteArrayBody, MultipartEntity> extends Activity implements OnClickListener {

	private static final int SELECT_PICTURE = 0;
	private ImageView imageView;
	Button btnpost;
  
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.advtwo);
        imageView = (ImageView) findViewById(android.R.id.icon);
        btnpost = (Button) findViewById(R.id.btnpost);
        btnpost.setOnClickListener(this);
     

    }
    
    public void pickPhoto(View view) {
    	//TODO: launch the photo picker
    	Intent intent = new Intent();
    	 intent.setType("image/*");
    	 intent.setAction(Intent.ACTION_GET_CONTENT);
    	 startActivityForResult(Intent.createChooser(intent,
    	 "Select Picture"), SELECT_PICTURE);
    	
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	if(resultCode == RESULT_OK) {
    		Bitmap bitmap = getPath(data.getData());
    		imageView.setImageBitmap(bitmap);
    	}
    }
    
    private Bitmap getPath(Uri uri) {

		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = managedQuery(uri, projection, null, null, null);
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		String filePath = cursor.getString(column_index);
		cursor.close();
		// Convert file path into bitmap image using below line.
		Bitmap bitmap = BitmapFactory.decodeFile(filePath);
		
		return bitmap;
	}
    
    public void uploadPhoto(View view) {
    	try {
			executeMultipartPost(fileList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void executeMultipartPost(Object HttpMultipartMode) throws Exception {

		try {

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
			
			Bitmap bitmap = drawable.getBitmap();

			bitmap.compress(CompressFormat.JPEG, 50, bos);

			byte[] data = bos.toByteArray();

			HttpClient httpClient = new DefaultHttpClient();

			HttpPost postRequest = new HttpPost(

			"http://192.168.1.107:8888/files/upload_file.php");

			String fileName = String.format("File_%d.png",new Date().getTime());
			/*ByteArrayBody bab = new ByteArrayBody(data, fileName);*/

			// File file= new File("/mnt/sdcard/forest.png");

			// FileBody bin = new FileBody(file);

			/*MultipartEntity reqEntity = new MultipartEntity(

			HttpMultipartMode.BROWSER_COMPATIBLE);

			((Object) reqEntity).addPart("file", bab);

			postRequest.setEntity((HttpEntity) reqEntity);*/
			int timeoutConnection = 60000;
			HttpParams httpParameters = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParameters,
					timeoutConnection);
			int timeoutSocket = 60000;
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
			HttpConnectionParams.setTcpNoDelay(httpParameters, true);

			HttpResponse response = httpClient.execute(postRequest);

			BufferedReader reader = new BufferedReader(new InputStreamReader(

			response.getEntity().getContent(), "UTF-8"));

			String sResponse;

			StringBuilder s = new StringBuilder();

			while ((sResponse = reader.readLine()) != null) {

				s = s.append(sResponse);

			}

			System.out.println("Response: " + s);

		} catch (Exception e) {

			// handle exception here
			e.printStackTrace();

			// Log.e(e.getClass().getName(), e.getMessage());

		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnpost:
			startActivity(new Intent(getApplicationContext(),AdvertScreenActivity.class));
			
			break;

		default:
			break;
		}
		
	}
}