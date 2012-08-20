package com.example.medical.map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medical.map.jsonhelper.Doctors;
import com.example.medical.map.util.ImageDownloader;

public class DetailsDoctors extends Activity {
	
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
					
			Bundle extras = getIntent().getExtras();
			if (extras != null)
		    {
		        Doctors doctors = (Doctors)extras.getSerializable("Value");
		        TextView textView = (TextView)findViewById(R.id.label);
		        TextView textViewTwo = (TextView)findViewById(R.id.descDetailsPhone);
		        TextView textViewThree = (TextView)findViewById(R.id.descDetailsSpeciality);
		        TextView textViewFour = (TextView)findViewById(R.id.labelSurrname);
		        TextView textViewFive = (TextView)findViewById(R.id.descDetailsPoi);
		        
		        textView.setText(doctors.getName());
		        textViewTwo.setText(doctors.getPhone());
		        textViewThree.setText(doctors.getSpeciality());
		        textViewFour.setText(doctors.getSurname());
		        
		        ImageView imageView = (ImageView)findViewById(R.id.contactImage1);
		        
		        ImageDownloader imageDownloader=new ImageDownloader();
		        
		        if(!TextUtils.isEmpty(doctors.getPicture()))
		        {
		        	imageDownloader.download(getString(R.string.url_base)+doctors.getPicture(), imageView);
		        }
		        
		        if(doctors.getPOIName().size()>0)
		        {
		        	textViewFive.setText(doctors.getPOIName().get(0).getName());
		        }
		        

		    }
		    else
		    {

		    }}
		

}	