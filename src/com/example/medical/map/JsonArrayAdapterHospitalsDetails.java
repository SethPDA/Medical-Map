package com.example.medical.map;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.medical.map.jsonhelper.Doctors;

public class JsonArrayAdapterHospitalsDetails extends ArrayAdapter<Doctors> {
	private final Context context;
	private final ArrayList<Doctors> values;

	
	
	public JsonArrayAdapterHospitalsDetails(Context context, ArrayList<Doctors> tempName) {
		//super (context,R.id.label, values);
		super(context, R.id.nameLabel,tempName);
		this.context = context;
		this.values = tempName;
		

	}

	
	public View getView(int position, View convertview, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View Rowview = inflater.inflate(R.layout.detailslayout, parent, false);
		
		TextView textviewThree = (TextView) Rowview.findViewById(R.id.label);
		textviewThree.setText((CharSequence) values.get(position));
	
		TextView textview = (TextView) Rowview.findViewById(R.id.descDetailsPhone);
//		TextView textviewtwo = (TextView) Rowview.findViewById(R.id.descDetailsPoi);
//		TextView textviewthree = (TextView) Rowview.findViewById(R.id.descDetailsSpecialities);
	
	

	textview.setText(values.get(position).getPhone());
//	textviewtwo.setText((CharSequence) values.get(position).getPOIName());
//	textviewthree.setText(values.get(position).getSpeciality().getName());


		
	
		return Rowview;
	}

}
