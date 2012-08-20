package com.example.medical.map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MySecondArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	
	public MySecondArrayAdapter(Context context, String[] values) {
		//super (context,R.id.label, values);
		super(context, R.id.label, values);
		this.context = context;
		this.values = values; 
	}
	
	public View getView(int position, View convertview, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View Rowview = inflater.inflate(R.layout.rowlayout, parent, false);
		TextView textview = (TextView) Rowview.findViewById(R.id.label);
		textview.setText(values[position]);
		String s = values[position];
		if (s.contains("t")) {
	        textview.setText(s);
		} else {

		}
		return Rowview;
	}

}
