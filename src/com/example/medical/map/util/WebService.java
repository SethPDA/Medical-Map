package com.example.medical.map.util;

import java.util.ArrayList;
import java.util.List;

import com.example.medical.callbacks.OnFinishAllHospitals;
import com.example.medical.callbacks.OnFinishAllMedics;
import com.example.medical.callbacks.OnFinishAllPharmacy;
import com.example.medical.callbacks.OnFinishAllPoi;
import com.example.medical.map.jsonhelper.Doctors;
import com.example.medical.map.jsonhelper.Hospitals;
import com.example.medical.map.jsonhelper.JsonHelper;
import com.example.medical.map.jsonhelper.Pharmacy;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class WebService {

	private static OnFinishAllPoi mOnFinishAllPoi;

	public static void setOnFinishAllPoi(OnFinishAllPoi mOnFinishAllPoi1) {
		mOnFinishAllPoi = mOnFinishAllPoi1;
	}

	private static OnFinishAllMedics mOnFinishAllMedics;

	public static void setOnFinishAllMedics(
			OnFinishAllMedics mOnFinishAllMedics1) {
		mOnFinishAllMedics = mOnFinishAllMedics1;
	}

	private static OnFinishAllHospitals mOnFinishAllHospitals;

	public static void setOnFinishAllHospitals(
			OnFinishAllHospitals mOnFinishAllHospitals1) {
		mOnFinishAllHospitals = mOnFinishAllHospitals1;
	}
	
	private static OnFinishAllPharmacy mOnFinishAllPharmacy;

	public static void setOnFinishAllPharmacy(
			OnFinishAllPharmacy mOnFinishAllPharmacy1) {
		mOnFinishAllPharmacy = mOnFinishAllPharmacy1;
	}


	public static List<Hospitals> GetPOIByType(String url) {

		AsyncHttpClient client = new AsyncHttpClient();
		client.get(url, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(String response) {

				ArrayList<Hospitals> list = JsonHelper.parseHospitals(response);

				if (mOnFinishAllHospitals != null) {
					mOnFinishAllHospitals.onFinishAllHospitals(list);
				}

			}

			@Override
			public void onFailure(Throwable e, String response) {
				System.out.println(e.getLocalizedMessage());
			}
		});

		return null;
	}
	
	public static List<Pharmacy> GetPOIByTypePharmacy(String url) {

		AsyncHttpClient client = new AsyncHttpClient();
		client.get(url, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(String response) {

				ArrayList<Pharmacy> list = JsonHelper.parsePharmacy(response);

				if (mOnFinishAllPharmacy != null) {
					mOnFinishAllPharmacy.onFinishAllPharmacy(list);
				}

			}

			@Override
			public void onFailure(Throwable e, String response) {
				System.out.println(e.getLocalizedMessage());
			}
		});

		return null;
	}


	public static List<Doctors> GetAllMedic(String url) {

		AsyncHttpClient client = new AsyncHttpClient();

		client.get(url, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(String response) {

				ArrayList<Doctors> list = JsonHelper.parseDoctors(response);

				if (mOnFinishAllMedics != null) {
					mOnFinishAllMedics.onFinshAllMedics(list);
				}

			}

			@Override
			public void onFailure(Throwable e, String response) {
				System.out.println(e.getLocalizedMessage());
			}
		});

		return null;

	}

}
