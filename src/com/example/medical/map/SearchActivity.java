package com.example.medical.map;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.medical.map.jsonhelper.Doctors;

public class SearchActivity extends ListActivity {

	EditText editText;
	JsonArrayAdapter adapter;
	ArrayList<Doctors> tempName = new ArrayList<Doctors>();

	String[] values = new String[] { "Doctors", "Hospitals", "Pharmacys" };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_activity_layout);
		ListView lv = getListView();
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values));
	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		if ("Doctors".equals(values[position])) {
			Intent intent = new Intent();
			intent.setClass(this, SearchActivityDoctors.class);
			startActivity(intent);
		} else if ("Hospitals".equals(values[position])) {
			Intent intent = new Intent();
			intent.setClass(this, SearchActivityHospitals.class);
			startActivity(intent);
		} else if ("Pharmacys".equals(values[position])) {
			Intent intent = new Intent();
			intent.setClass(this, SearchActivityPharmacys.class);
			startActivity(intent);
		}

	}
}