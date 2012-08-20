package com.example.medical.map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.medical.map.jsonhelper.Doctors;
import com.example.medical.map.util.WebService;

public class Details extends Activity {
	
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
			setContentView(R.layout.detailslayout);
			
			WebService.GetAllMedic("http://82.77.55.81:9090/MedicalMap/MedicalMap.svc/GetAllMedic");
		
			Bundle extras = getIntent().getExtras();
			if (extras != null)
		    {
		        Doctors doctors = (Doctors)extras.getSerializable("Value");
		        TextView textView = (TextView)findViewById(R.id.label);
		        TextView textViewTwo = (TextView)findViewById(R.id.descDetailsPhone);
		        TextView textViewThree = (TextView)findViewById(R.id.descDetailsSpeciality);
		        TextView textViewFour = (TextView)findViewById(R.id.labelSurrname);
		        textView.setText(doctors.getName());
		        textViewTwo.setText(doctors.getPhone());
		        textViewThree.setText(doctors.getSpeciality());
		        textViewFour.setText(doctors.getSurname());
		    //    textViewFour.setText(doctors.getSpeciality().getName());

		    }
		    else
		    {

		    }}
		

}	