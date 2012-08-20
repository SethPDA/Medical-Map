package com.example.medical.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {

	Button searchButton;
	Button closeButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

	}

	public void handleClick_medic(View v) {

		Intent intent = new Intent();
		intent.setClass(this, Medici.class);
		startActivity(intent);
	}

	public void handleClick_hospital(View v) {

		Intent intent = new Intent();
		intent.setClass(this, Spitale.class);
		startActivity(intent);
	}

	public void handleClick_pharmacy(View v) {

		Intent intent = new Intent();
		intent.setClass(this, Farmacii.class);
		startActivity(intent);
	}
	
	public void handleClick_maps(View v) {

		Intent intent = new Intent();
		intent.setClass(this, CustomMapActivity.class);
		startActivity(intent);
	}

	public void handleClick_search(View v) {

		Intent intent = new Intent();
		intent.setClass(this, SearchActivity.class);
		startActivity(intent);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.optionsMenuTextItem:     
	        	Intent i = new Intent();
	        	i.setClass(this, AboutActivity.class);
	        	startActivity(i);
	                            break;
	    }
	    return true;
	}

}
