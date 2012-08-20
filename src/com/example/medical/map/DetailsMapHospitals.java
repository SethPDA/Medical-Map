package com.example.medical.map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.medical.map.jsonhelper.Doctors;
import com.example.medical.map.util.WebService;

public class DetailsMapHospitals extends Activity {
	
	@SuppressWarnings("unused")
	private Context context;
	@SuppressWarnings("unused")
	private String[] values;

	
	public void MySimpleArrayAdapter(Context context, String[] values) {
		this.context = context;
		this.values = values;
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.detailslayout_hospitals);
			
			WebService.GetAllMedic("http://82.77.55.81:9090/MedicalMap/MedicalMap.svc/GetAllMedic");
		
			Bundle extras = getIntent().getExtras();
			if (extras != null)
		    {
				String Name = extras.getString("Name");
				String Phone = extras.getString("Phone");
				if (Name != null && Phone != null) {
					EditText text1 = (EditText) findViewById(R.id.label);
					EditText text2 = (EditText) findViewById(R.id.descPhone);
					text1.setText(Name);
					text2.setText(Phone);
				}

		    }
		    else
		    {

		    }}
		

}	