package com.example.medical.map;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapsActivity extends MapActivity {

	@SuppressWarnings("unused")
	private MapController mapController;
	Button showButton;
	Button closeButton;
	private boolean isSearch = false;
	public MapView mapView;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_activity_layout);

		// Displaying Zooming controls
		mapView = (MapView) findViewById(R.id.mapView);
		mapController= mapView.getController();
		mapView.setBuiltInZoomControls(true);
		mapView.setTraffic(true); // Traffic View

		// Overlay buttons
		Button btnChangeView = (Button) findViewById(R.id.satView);
		btnChangeView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mapView.setSatellite(true);
				mapView.setVisibility(View.VISIBLE);
			}

		});

		Button btnChangeView2 = (Button) findViewById(R.id.trafficView);
		btnChangeView2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mapView.setSatellite(false);
				mapView.setVisibility(View.VISIBLE);
			}

		});
//		
//		
//		
//		 int latitude =  (int) (47.059188* 1E6);
//		 int longitude = (int) (21.922430* 1E6);
//
//		 GeoPoint locationPoint = new GeoPoint(latitude,longitude );
	}
	
	
	// Overlay buttons end here

	@SuppressLint("ParserError")
	protected boolean isRouteDisplayed() {
		return false;
	}

	// Show,hide overlay

	public void showOverlay(View v) {

		ImageView showButton = (ImageView) findViewById(R.id.showButton);
		showButton.setVisibility(View.INVISIBLE);
		LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout1);
		layout.setVisibility(View.VISIBLE);

	}

	public void hideOverlay(View v) {

		ImageView showButton = (ImageView) findViewById(R.id.showButton);
		showButton.setVisibility(View.VISIBLE);
		LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout1);
		layout.setVisibility(View.GONE);

	}

	public void showSearch() {

		if (isSearch != true) {
			isSearch = true;
			showButton.setVisibility(View.INVISIBLE);
			closeButton.setVisibility(View.VISIBLE);
			findViewById(R.layout.map_activity_layout_overlay).setVisibility(
					View.VISIBLE);

		}

	}

	public void hideSearch() {
		if (isSearch != false) {
			isSearch = false;
			showButton.setVisibility(View.VISIBLE);
			closeButton.setVisibility(View.GONE);
			findViewById(R.layout.map_activity_layout_overlay).setVisibility(
					View.GONE);
		}

	}

};