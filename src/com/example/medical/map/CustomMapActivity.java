package com.example.medical.map;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.medical.callbacks.OnFinishAllHospitals;
import com.example.medical.callbacks.OnFinishAllPharmacy;
import com.example.medical.map.jsonhelper.Hospitals;
import com.example.medical.map.jsonhelper.Pharmacy;
import com.example.medical.map.util.WebService;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class CustomMapActivity extends MapActivity {

	Button showButton;
	Button closeButton;
	private boolean isSearch = false;
	MapView mapView;
	List<Overlay> mapOverlays;
	Drawable drawable;
	Drawable drawable2;
	CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay;
	CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay2;
	ArrayList<Hospitals> hospitalsList = new ArrayList<Hospitals>();
	ArrayList<Pharmacy> pharmacyList = new ArrayList<Pharmacy>();
	private MapController mc;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_activity_layout);

		mapView = (MapView) findViewById(R.id.mapView);
		

		mapView.setBuiltInZoomControls(true);
		mapOverlays = mapView.getOverlays();
		mapView.postInvalidate();
		mc = mapView.getController();

		WebService.setOnFinishAllHospitals(new OnFinishAllHospitals() {

			public void onFinishAllHospitals(ArrayList<Hospitals> hospitals) {

				if (hospitals != null) {
					if (hospitals.size() > 0) {
						hospitalsList.clear();
						hospitalsList.addAll(hospitals);
						showHospitalList(hospitalsList);

					}

				}

			}

		});

		WebService
				.GetPOIByType("http://82.77.55.81:9090/MedicalMap/MedicalMap.svc/Getpoibytype/hospital");

		WebService.setOnFinishAllPharmacy(new OnFinishAllPharmacy() {

			public void onFinishAllPharmacy(ArrayList<Pharmacy> pharmacy) {

				if (pharmacy != null) {
					if (pharmacy.size() > 0) {

						pharmacyList.clear();
						pharmacyList.addAll(pharmacy);
						showPharmacyList(pharmacyList);
					}

				}

			}

		});

		WebService
				.GetPOIByTypePharmacy("http://82.77.55.81:9090/MedicalMap/MedicalMap.svc/Getpoibytype/Pharmacy");

		drawable = getResources().getDrawable(R.drawable.marker);
		itemizedOverlay = new CustomItemizedOverlay<CustomOverlayItem>(
				drawable, mapView);

		itemizedOverlay.setOnBalloonTapListener(new OnBalloonTapListener() {

			public void OnBalloonTap(int index, CustomOverlayItem item) {

				Hospitals hospitals = item.getHospitals();
				Intent i = new Intent();
				if (hospitals != null) {
					i.putExtra("Value", hospitals);
					i.setClass(CustomMapActivity.this, DetailsHospitals.class);
				} else {
					Pharmacy pharmacy = item.getPharmacy();
					i.putExtra("Value", pharmacy);
					i.setClass(CustomMapActivity.this, DetailsPharmacy.class);
				}

				startActivity(i);

			}
		});

		itemizedOverlay2 = new CustomItemizedOverlay<CustomOverlayItem>(
				drawable, mapView);

		GeoPoint point = new GeoPoint((int) (47.06431579589844 * 1E6),
				(int) (21.90926170349121 * 1E6));
		mc.animateTo(point);
		mc.setZoom(15);

	}
	
	public void balloonClose(View v) {
		
/*
		LinearLayout layout = (LinearLayout) findViewById(R.id.balloon_main_layout);
		layout.setVisibility(View.INVISIBLE);*/
	//	v.setVisibility(View.INVISIBLE);
	//	((View) v.getParent().getParent()).setVisibility(View.INVISIBLE);
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

	public void showHospitalList(ArrayList<Hospitals> hospitals) {

		for (int i = 0; i < hospitals.size(); i++) {

			Hospitals hospital = hospitals.get(i);
			CustomOverlayItem temp1 = toOverlay(hospital);
			itemizedOverlay.addOverlay(temp1);
		}
		if (itemizedOverlay != null)
			mapOverlays.add(itemizedOverlay);

	}

	public void showPharmacyList(ArrayList<Pharmacy> pharmacy) {

		for (int i = 0; i < pharmacy.size(); i++) {

			Pharmacy pharmacys = pharmacy.get(i);
			CustomOverlayItem temp2 = toOverlay(pharmacys);
			itemizedOverlay2.addOverlay(temp2);
		}
		if (itemizedOverlay2 != null)
			mapOverlays.add(itemizedOverlay2);
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

}
