package com.utility.modernmum;

import com.example.modernmum.LoginScreenActivity;
import com.model.modermum.user;

import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract.Constants;
import android.text.GetChars;
//This class extends sqlite helper
public class SqliteOpenHelper extends SQLiteOpenHelper{
	//database fields
	
	public static final String DATABASE_NAME = "register.db";
	public static final String TABLE_NAME = "registers";
	public static final int    DATABASE_VERSION = 1;
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_FIRST = "first name";
	public static final String COLUMN_LAST = "last name";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_CONFIRM = "confirm password";
	public static final String COLUMN_PHONE = "phone number";
	
	ContentValues ContentValue;
	//creating database
	public static final String DATABASE_CREATE = "create table"
			 + TABLE_NAME + "(" + COLUMN_ID
		     + " integer primary key autoincrement, " 
		     
			 + COLUMN_FIRST + " text,"
			 
		     + COLUMN_LAST +" text,"
		     
			 + COLUMN_EMAIL +"text,"
			 
		     + COLUMN_PASSWORD +" text,"
		     
		     + COLUMN_CONFIRM +" text,"
		     
		     + COLUMN_PHONE +" text );";
	private static final SQLiteDatabase database = null;
	
	public SqliteOpenHelper(Context context){
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		
		
	}
  public void deleteRegister(user User) {
	    int id = User.getId();
	    System.out.println("Comment deleted with id: " + id);
	    database.delete(SqliteOpenHelper.TABLE_NAME,
	    SqliteOpenHelper.COLUMN_ID
	        + " = " + id, null);
	     String first = User.getnames();
	     System.out.println("row deleted " + first);
	     
	  }
  
	public void AddUserDetails(user User){
		SQLiteDatabase sqliteOpenHelper = this.getWritableDatabase();
		ContentValue.put(constants.KEY_NAMES,User.getnames());
		SqliteOpenHelper.Insert(TABLE_NAME,null,ContentValue);
		
	}
   


	private static void Insert(String tableName, Object object,
			ContentValues contentValue2) {
		// TODO Auto-generated method stub
		
	}



	// New value for one column
	ContentValues values = new ContentValues();

	// Which row to update, based on the ID
	String selection = SqliteOpenHelper.COLUMN_ID + " LIKE ?";
	String[] selectionArgs = { String.valueOf(true) };

	int count = database.update(
	    SqliteOpenHelper.TABLE_NAME,
	    values,
	    selection,
	    selectionArgs);

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
		onCreate(db);
		
	}
	

	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
		onDowngrade(db, oldVersion, newVersion);
	}


	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void resetTables() {
		// TODO Auto-generated method stub
		
	}
	 
}


