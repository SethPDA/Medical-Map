package com.example.medical.map;

import java.util.List;

import android.content.Intent;
import android.content.IntentSender.OnFinished;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.medical.map.jsonhelper.Hospitals;
import com.example.medical.map.jsonhelper.Pharmacy;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class SimpleMapActivity extends MapActivity {

	@SuppressWarnings("unused")
	private MapController mapController;
	Button showButton;
	Button closeButton;
	private boolean isSearch = false;
	MapView mapView;
	List<Overlay> mapOverlays;
	Drawable drawable;
	CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay;

	public MapController mc;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_activity_layout);

		mapView = (MapView) findViewById(R.id.mapView);
		mapController = mapView.getController();
		mapView.setBuiltInZoomControls(true);
		mapOverlays = mapView.getOverlays();
		mapView.postInvalidate();
		mc = mapView.getController();

		drawable = getResources().getDrawable(R.drawable.marker);

		itemizedOverlay = new CustomItemizedOverlay<CustomOverlayItem>(
				drawable, mapView);
		
		itemizedOverlay.setOnBalloonTapListener(new OnBalloonTapListener() {

			public void OnBalloonTap(int index, CustomOverlayItem item) {

			}
		});

		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			Object object=extras.getSerializable("Value");
			if(object instanceof Hospitals )
			{
				
				showHospital((Hospitals) object);
			}else if(object instanceof Pharmacy)
			{
				showPharmacy((Pharmacy) object);
			}
			
		}
		
		
	}
	
	public void balloonClose(View v) {
		
		itemizedOverlay.hideAllBalloons();
		}

	public void clickTrafficView(View v) {

		mapView.setSatellite(true);
		mapView.setVisibility(View.VISIBLE);
	}

	public void clickSatView(View v) {

		mapView.setSatellite(false);
		mapView.setVisibility(View.VISIBLE);
	}

	public void showHospital(Hospitals hospital) {

		CustomOverlayItem temp1 = toOverlay(hospital);
		itemizedOverlay.addOverlay(temp1);

		mc.animateTo(new GeoPoint((int) (hospital.Latitude * 1E6),
				(int) (hospital.Longitude * 1E6)));
		mc.setZoom(15);
		if (itemizedOverlay != null)
			mapOverlays.add(itemizedOverlay);

	}

	public void showPharmacy(Pharmacy pharmacy) {

		CustomOverlayItem temp2 = toOverlay(pharmacy);
		itemizedOverlay.addOverlay(temp2);

		mc.animateTo(new GeoPoint((int) (pharmacy.Latitude * 1E6),
				(int) (pharmacy.Longitude * 1E6)));
		mc.setZoom(15);
		if (itemizedOverlay != null)
			mapOverlays.add(itemizedOverlay);
	}

	public CustomOverlayItem toOverlay(Pharmacy pharmacy) {
		CustomOverlayItem tempHospitals = new CustomOverlayItem(pharmacy);

		return tempHospitals;
	}

	public CustomOverlayItem toOverlay(Hospitals hospitals) {

		CustomOverlayItem tempPharmacy = new CustomOverlayItem(hospitals);

		return tempPharmacy;
	}

	// Show,hide overlay

	public void showOverlay(View v) {

		// ImageView showButton = (ImageView) findViewById(R.id.showButton);
		// showButton.setVisibility(View.INVISIBLE);
		LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout1);
		layout.setVisibility(View.VISIBLE);

	}

	public void hideOverlay(View v) {

		// ImageView showButton = (ImageView) findViewById(R.id.showButton);
		// showButton.setVisibility(View.VISIBLE);
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

	// Overlay stuff end here

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	public void OnFinished(Bundle savedInstanceState){
		;
	}
	public void OnPause(Bundle savedInstanceState){
		;
	}
}
