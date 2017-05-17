package com.example.wordgame;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper
{

	public static final int Database_Version = 3 ;
	public static final String Database_Name = "contactManager" ;
	private static final String KEY_NAME = "word";
	private static final String KEY_CATEGORY = "category";
	private static final String TABLE_NAME = "words";
	
	public DatabaseHandler(Context context) 
	{
		super(context, Database_Name, null, Database_Version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
				+ KEY_NAME + " TEXT PRIMARY KEY , " + KEY_CATEGORY +" TEXT)";
		db.execSQL(CREATE_CONTACTS_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		
		// Create tables again
		onCreate(db);
	}
	
	void addWord(String word , String category) 
	{
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, word);
		values.put(KEY_CATEGORY, category);

		db.insert(TABLE_NAME, null, values);
		db.close(); // Closing database connection
		Log.d("one","Data is inserted");	
	}
	
	public String getWord(String category) 
	{
		String word = new String();
		// Select All Query
		String selectQuery = "SELECT * FROM " + TABLE_NAME +" "+category+ " order by random() LIMIT 1" ;

		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) 
		{
			word = cursor.getString(0);
		}
		cursor.close();
		db.close();
		return word ;
	}
}
