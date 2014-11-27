package com.example.modernmum;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.model.modermum.user;
import com.utility.modernmum.SqliteOpenHelper;
import com.utility.modernmum.UserFunctions;
import com.utility.modernmum.constants;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterScreenActivity extends Activity implements OnClickListener {
	EditText etnames, etregemail, etregpassword, etphone, etlocation,
			etconfirm;
	Button btnback, btnsubmit;
	 constants myConstants;
	
	user UserModel;
	TextView tvemail;
	String strnames, strregister, strphone, strlocation, strpassword,
			strconfirm;
	private static final String TAG = RegisterScreenActivity.class
			.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		// instantiation
		 myConstants = new constants();
		etnames = (EditText) findViewById(R.id.etnames);
		etregemail = (EditText) findViewById(R.id.etregemail);
		etregpassword = (EditText) findViewById(R.id.etregpassword);
		etphone = (EditText) findViewById(R.id.etphone);
		etlocation = (EditText) findViewById(R.id.etlocation);
		etconfirm = (EditText) findViewById(R.id.etconfirm);
		tvemail = (TextView) findViewById(R.id.textView4);

		btnback = (Button) findViewById(R.id.btnback);
		btnback.setOnClickListener(this);

		btnsubmit = (Button) findViewById(R.id.btnsubmit);
		btnsubmit.setOnClickListener(this);

		/* myconstants = new constants(getApplicationContext()); */

		UserModel = new user();
		
		
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnsubmit:

			if (etnames.getText().toString().equals("")
					|| etregemail.getText().toString().equals("")
					|| etregpassword.getText().toString().equals("")
					|| etconfirm.getText().toString().equals("")
					|| etphone.getText().toString().equals("")
					|| etlocation.getText().toString().equals(""))
				Toast.makeText(getApplicationContext(),
						"Please fill the fields", Toast.LENGTH_SHORT).show();
			{
			}
			 if (etregemail.getText().toString().equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter the email", Toast.LENGTH_SHORT).show();
			} else if (etregpassword.getText().toString().equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter the password", Toast.LENGTH_SHORT).show();
			} else if (etconfirm.getText().toString().equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please confirm your password", Toast.LENGTH_SHORT)
						.show();
			} else if (etphone.getText().toString().equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter the phonenumber", Toast.LENGTH_SHORT)
						.show();
			} else if (etlocation.getText().toString().equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter the location", Toast.LENGTH_SHORT).show();
			}

			else if (!etconfirm.getText().toString()
					.equals(etregpassword.getText().toString())) {
				Toast.makeText(getApplicationContext(),
						"password does not match", Toast.LENGTH_SHORT).show();
			}

			else if (etnames.getText().toString()
					.equals(etnames.getText().toString())
					&& etregemail.getText().toString()
							.equals(etregemail.getText().toString())
					&& etregpassword.getText().toString()
							.equals(etregpassword.getText())
					&& etphone.getText().toString().equals(etphone.getText())) {
				Toast.makeText(getApplicationContext(), "Login successful",
						Toast.LENGTH_SHORT).show();
			}

			else {
                 UserModel.setNames(etnames.getText().toString());
                 UserModel.setEmail(etregemail.getText().toString());
                 UserModel.setPassword(etregpassword.getText().toString());
                 UserModel.setConfirm(etconfirm.getText().toString());
                 UserModel.setPhoneNumber(etphone.getText().toString());
                 UserModel.setLocation(etlocation.getText().toString());
			RegisterAsyncTask reg = new RegisterAsyncTask();
			reg.execute();
			}

			break;
		case R.id.btnback:
			startActivity(new Intent(getApplicationContext(),
					MainActivity.class));
			break;

		default:
			break;
		}

	}

	// This class enables us to perform long operation in the background without
	// affecting the UI.

	// Params: Parameters sent to the background task for execution.
	// Progress: Display when the task is happening
	// Result: This is the type of result we expect once the background task is
	// completed

	public class RegisterAsyncTask extends AsyncTask<String, Void, JSONObject> {
		ProgressDialog progressDialog;

		// This step is normally used to setup the task,

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Setup the progressBar
			progressDialog = new ProgressDialog(RegisterScreenActivity.this);
			progressDialog.setMessage("Please Wait....");
			progressDialog.setCancelable(false);
			progressDialog.show();
		}

		// This step is used to perform background computation that can take a
		// long time.

		@Override
		protected JSONObject doInBackground(String... params) {
			UserFunctions userFunction = new UserFunctions();
			return userFunction.LoginUser(UserModel.getnames(),
                    UserModel.getEmail(), UserModel.getPassword(),
                    UserModel.getConfirm(), UserModel.getPhoneNumber(),
                    UserModel.getLocation());
		}

		// Invoked on the UI thread after the background computation finishes.

		// @param jsonObjectResult Result from the backgrounindex.phpd task

		@Override
		protected void onPostExecute(JSONObject jsonObjectResult) {
			super.onPostExecute(jsonObjectResult);

            Log.i(TAG, "result "+ jsonObjectResult);
			// Check if the dialog is showing and dismiss it.

			if (progressDialog.isShowing()) {
				progressDialog.dismiss();
			}
			// check for login response
			try {
				if (jsonObjectResult.getString(constants.kEY_JSON_SUCCESS) != null) {

					String res = jsonObjectResult
							.getString(constants.kEY_JSON_SUCCESS);
                    Log.i(TAG, "result Succcess "+ res);
					if (Integer.parseInt(res) == 1) {
						JSONObject jsonObject = jsonObjectResult
								.getJSONObject("modern");

						// user successfully registered
						// Store user details in SQLite Database

						SqliteOpenHelper db = new SqliteOpenHelper(
								getApplicationContext());
						UserModel.setNames(jsonObject
								.getString(constants.kEY_JSON_NAMES));
						UserModel.setEmail(jsonObject
								.getString(constants.kEY_JSON_EMAIL));
						UserModel.setPassword(jsonObject
								.getString(constants.kEY_JSON_PASSWORD));
						UserModel.setConfirm(jsonObject
								.getString(constants.kEY_JSON_CONFIRM));
						UserModel.setConfirm(jsonObject
								.getString(constants.kEY_JSON_PHONE));
						UserModel.setConfirm(jsonObject
								.getString(constants.kEY_JSON_LOCATION));
						
						db.AddUserDetails(UserModel);
						// Launch LoginScreen

						
						// Close Registration Screen
						finish();
					} else {
						// Error in registration
						displayToastMessage("Error occurred in registration");
					}
				};
				startActivity(new Intent(getApplicationContext(), HomeScreenActivity.class));
				displayToastMessage("Registration was Successful");	
			} catch (JSONException e) {
				e.printStackTrace();
				Log.e(TAG,
						"@onPostExecute JSONException Message: "
								+ e.getMessage());
			} catch (NullPointerException np) {
				Log.e(TAG,
						"@onPostExecute NullPointerException Message: "
								+ np.getMessage());
			}
		}
	}

	/**
	 * @param message
	 *            Message to be displayed
	 */
	public void displayToastMessage(String message) {
		Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT)
				.show();
	}

}
