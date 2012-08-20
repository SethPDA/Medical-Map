package com.example.medical.map.util;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager extends SQLiteOpenHelper {
	

	private final String create="CREATE TABLE rating (ID TEXT PRIMARY KEY, type TEXT, timestamp TEXT);";

	private final String table="rating";

	private final static String database="MMRating.db";
	
	private SQLiteDatabase db;

	public DbManager(Context context) {
		super(context, database, null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(create);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 db.execSQL("DROP TABLE IF EXISTS " + table);
	      onCreate(db);	
	}

	public void open(){
		this.db=this.getWritableDatabase();
	}

	public void close(){
		this.db.close();
	}

	public ArrayList<String[]> getAll(){
		ArrayList <String[]> result = new ArrayList<String[]>();
		int counter=0;

		Cursor cursor= this.db.query(table, new String[] {"ID","type","timestamp"}, null, null, null, null, "ID");

		if(cursor.moveToFirst()){
			 do {
				 result.add(new String[3]);
				 result.get(counter)[0] = cursor.getString(0).toString();
				 result.get(counter)[1] = cursor.getString(1).toString();
			     counter++;
			     } while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			 cursor.close();
		}
		return result;
	}

	public String[] getByIdAndType(String ID, String type){
		String[] result=new String[4];
		Cursor cursor= this.db.query(table, new String[] {"ID","type","timestamp"}, "ID=\""+ID+"\" AND type=\""+type+"\"", null, null, null, "ID");
		if(cursor.moveToFirst()){
			 do {
				 result[0] = cursor.getString(0).toString();
				 result[1] = cursor.getString(1).toString();
				 result[2] = cursor.getString(2).toString();
			     } while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			 cursor.close();
		}
		return result;
	}

	public void insert(String ID, String type, String timestamp){
		ContentValues row = new ContentValues();
		row.put("ID", ID);
		row.put("type",type);
		row.put("timestamp", timestamp);
		db.insert(table, null, row);
	}

	public void update(String ID, String type, String timestamp){
		ContentValues row = new ContentValues();
		row.put("timestamp",timestamp);
		db.update(table, row, "ID=?,type=?", new String[]{ID,type});
	}

	public void deleteById(String ID){
		db.delete(table, "ID=?", new String[] {ID});
	}
}
