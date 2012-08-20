package com.example.medical.map.jsonhelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonHelper {

	public static String GetStringRaw(Context context, int rawId) {
		String tempString = null;
		InputStream inputStream = null;
		try {
			inputStream = context.getResources().openRawResource(rawId);
			byte[] reader = new byte[inputStream.available()];
			while (inputStream.read(reader) != -1) {
			}

			tempString = new String(reader);

		} catch (IOException e) {

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {

				}
			}
		}
		return tempString;
	}
	
	public static ArrayList<HospitalsAddress> parseHospitalsAddress(String jsonResponse) {

		ArrayList<HospitalsAddress> hospitals = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONArray j;

		try {
			j = new JSONArray(jsonResponse);

			hospitals = gson.fromJson(j.toString(),
					new TypeToken<ArrayList<HospitalsAddress>>() {
					}.getType());

			System.out.println(hospitals);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return hospitals;

	}
	
	public static ArrayList<HospitalsSpecialities> parseHospitalsSpecialities(String jsonResponse) {

		ArrayList<HospitalsSpecialities> hospitals = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONArray j;

		try {
			j = new JSONArray(jsonResponse);

			hospitals = gson.fromJson(j.toString(),
					new TypeToken<ArrayList<HospitalsSpecialities>>() {
					}.getType());

			System.out.println(hospitals);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return hospitals;

	}
	
	public static ArrayList<PharmacyAddress> parsePharmacyAddress(String jsonResponse) {

		ArrayList<PharmacyAddress> pharmacy = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONArray j;

		try {
			j = new JSONArray(jsonResponse);

			pharmacy = gson.fromJson(j.toString(),
					new TypeToken<ArrayList<PharmacyAddress>>() {
					}.getType());

			System.out.println(pharmacy);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return pharmacy;

	}
	
	public static ArrayList<PharmacySpecialities> parsePharmacySpecialities(String jsonResponse) {

		ArrayList<PharmacySpecialities> pharmacy = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONArray j;

		try {
			j = new JSONArray(jsonResponse);

			pharmacy = gson.fromJson(j.toString(),
					new TypeToken<ArrayList<PharmacySpecialities>>() {
					}.getType());

			System.out.println(pharmacy);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return pharmacy;

	}

	public static ArrayList<Speciality> parseSpeciality(String jsonResponse) {

		ArrayList<Speciality> medics = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONArray j;

		try {
			j = new JSONArray(jsonResponse);

			medics = gson.fromJson(j.toString(),
					new TypeToken<ArrayList<Speciality>>() {
					}.getType());

			System.out.println(medics);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return medics;

	}


	public static ArrayList<Doctors> parseDoctors(String jsonResponse) {

		ArrayList<Doctors> medics = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONObject j;

		try {
			j = new JSONObject(jsonResponse);

			GetAllMedicResult tempMedics = gson.fromJson(j.toString(),
					new TypeToken<GetAllMedicResult>() {
					}.getType());

			if (tempMedics != null) {
				medics = tempMedics.getGetAllMedicResult();
			}
			System.out.println(medics);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return medics;

	}

	public static ArrayList<Doctors> parseName(String jsonResponse) {

		ArrayList<Doctors> medics = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONArray j;

		try {
			j = new JSONArray(jsonResponse);

			medics = gson.fromJson(j.toString(),
					new TypeToken<ArrayList<Doctors>>() {
					}.getType());

			System.out.println(medics);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return medics;

	}
	
	public static ArrayList<Pharmacy> parsePharmacy(String jsonResponse) {

		ArrayList<Pharmacy> pharmacy = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONObject j;

		try {
			j = new JSONObject(jsonResponse);

			GetPOIByTypeResultPharmacy tempPharmacy = gson.fromJson(j.toString(),
					new TypeToken<GetPOIByTypeResultPharmacy>() {
					}.getType());

			if (tempPharmacy != null) {
				pharmacy = tempPharmacy.getGetPOIByTypeResultPharmacy();
			}
			System.out.println(pharmacy);

		} catch (Exception e) {

			e.printStackTrace();

		}
		Log.d("parse", pharmacy.toString());
		return pharmacy;
		

	}
	
	public static ArrayList<Pharmacy> parseName2(String jsonResponse) {

		ArrayList<Pharmacy> pharmacy = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONArray j;

		try {
			j = new JSONArray(jsonResponse);

			pharmacy = gson.fromJson(j.toString(),
					new TypeToken<ArrayList<Pharmacy>>() {
					}.getType());

			System.out.println(pharmacy);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return pharmacy;

	}
	
	public static ArrayList<Hospitals> parseHospitals(String jsonResponse) {

		ArrayList<Hospitals> hospitals = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONObject j;

		try {
			j = new JSONObject(jsonResponse);

			GetPOIByTypeResult tempHospitals = gson.fromJson(j.toString(),
					new TypeToken<GetPOIByTypeResult>() {
					}.getType());

			if (tempHospitals != null) {
				hospitals = tempHospitals.getGetPOIByTypeResult();
			}
			System.out.println(hospitals);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return hospitals;

	}
	
	public static ArrayList<Hospitals> parseName1(String jsonResponse) {

		ArrayList<Hospitals> hospitals = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONArray j;

		try {
			j = new JSONArray(jsonResponse);

			hospitals = gson.fromJson(j.toString(),
					new TypeToken<ArrayList<Hospitals>>() {
					}.getType());

			System.out.println(hospitals);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return hospitals;

	}
	
	
	public static FilterHospital parseFilterhospital(String jsonResponse) {

		FilterHospital hospitals = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONObject j;

		try {
			j = new JSONObject(jsonResponse);

			hospitals = gson.fromJson(j.toString(),
					new TypeToken<FilterHospital>() {
					}.getType());

			System.out.println(hospitals);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return hospitals;

	}
	
	public static FilterDoctors parseFilterdoctors(String jsonResponse) {

		FilterDoctors doctors = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONObject j;

		try {
			j = new JSONObject(jsonResponse);

			doctors = gson.fromJson(j.toString(),
					new TypeToken<FilterDoctors>() {
					}.getType());

			System.out.println(doctors);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return doctors;

	}
	
	public static FilterPharmacy parseFilterpharmacy(String jsonResponse) {

		FilterPharmacy pharmacy = null;

		GsonBuilder gsonb = new GsonBuilder();

		Gson gson = gsonb.create();

		JSONObject j;

		try {
			j = new JSONObject(jsonResponse);

			pharmacy = gson.fromJson(j.toString(),
					new TypeToken<FilterPharmacy>() {
					}.getType());

			System.out.println(pharmacy);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return pharmacy;

	}


}
