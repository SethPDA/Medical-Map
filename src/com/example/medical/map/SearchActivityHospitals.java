package com.example.medical.map;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.medical.callbacks.OnFinishAllHospitals;
import com.example.medical.map.jsonhelper.Hospitals;
import com.example.medical.map.util.WebService;

public class SearchActivityHospitals extends ListActivity {

	Button searchButton;
	Button closeButton;
	public Spinner spinner1;
	private String poiType[];
	private boolean isSearch = false;
	EditText editText, editText2;
	SearchArrayAdapterHospitals adapter;
	ArrayList<Hospitals> tempName = new ArrayList<Hospitals>();
	private MyOnItemSelectedListener itemSelectListener;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_activity_layout_actionbar_hospitals);
		adapter = new SearchArrayAdapterHospitals(this, tempName);
		setListAdapter(adapter);

		poiType = new String[] { "", "Stomatologie", "Radiologie",
				"Cardiologie", "Ginecologie", "Pediatrie", "Patologie",
				"Oncologie", "Macelarie", "Oftalmologie", "Ghipsologie" };

		ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(
				SearchActivityHospitals.this,
				android.R.layout.simple_spinner_item, poiType);
		adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		itemSelectListener = new MyOnItemSelectedListener();
		spinner1 = (Spinner) findViewById(R.id.spinnerSpecialityHospitals);
		spinner1.setAdapter(adapter0);
		spinner1.setOnItemSelectedListener(itemSelectListener);

		WebService.setOnFinishAllHospitals(new OnFinishAllHospitals() {

			public void onFinishAllHospitals(ArrayList<Hospitals> hospitals) {

				if (hospitals != null) {
					if (hospitals.size() > 0) {
						tempName.clear();
						tempName.addAll(hospitals);
						adapter.notifyDataSetChanged();
					}

				}

			}

		});

		WebService
				.GetPOIByType("http://82.77.55.81:9090/MedicalMap/MedicalMap.svc/Getpoibytype/hospital");

		final ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(SearchActivityHospitals.this,
						DetailsHospitals.class);
				intent.putExtra("Value", adapter.getItem(position));
				startActivity(intent);

			}
		});

		editText = (EditText) findViewById(R.id.editNameTextHospitals);
		editText.addTextChangedListener(new TextWatcher() {

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				adapter.getFilter().filter(s); // Filter from my adapter
				adapter.notifyDataSetChanged(); // Update my view
				search();

			}

			public void afterTextChanged(Editable s) {
				search();
			}

		});

		editText2 = (EditText) findViewById(R.id.editAddressTextHospitals);
		editText2.addTextChangedListener(new TextWatcher() {

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				adapter.getFilter().filter(s); // Filter from my adapter
				adapter.notifyDataSetChanged(); // Update my view
				search();
			}

			public void afterTextChanged(Editable s) {
				search();
			}

		});

	}
	
	public void handleClick_search(View v) {

		ImageView searchButton = (ImageView) findViewById(R.id.searchButtonHospitals);
		searchButton.setVisibility(View.INVISIBLE);
		ImageView closeButton = (ImageView) findViewById(R.id.closeButtonHospitals);
		closeButton.setVisibility(View.VISIBLE);
		LinearLayout layout = (LinearLayout) findViewById(R.id.searchFieldLayout);
		layout.setVisibility(View.VISIBLE);

	}

	public void handleClick_closeSearch(View v) {

		ImageView searchButton = (ImageView) findViewById(R.id.searchButtonHospitals);
		searchButton.setVisibility(View.VISIBLE);
		ImageView closeButton = (ImageView) findViewById(R.id.closeButtonHospitals);
		closeButton.setVisibility(View.INVISIBLE);
		LinearLayout layout = (LinearLayout) findViewById(R.id.searchFieldLayout);
		layout.setVisibility(View.GONE);

	}

	public void showSearch() {

		if (isSearch != true) {
			isSearch = true;
			searchButton.setVisibility(View.INVISIBLE);
			closeButton.setVisibility(View.VISIBLE);
			findViewById(R.layout.search_field).setVisibility(View.VISIBLE);

		}

	}

	public void hideSearch() {
		if (isSearch != false) {
			isSearch = false;
			searchButton.setVisibility(View.VISIBLE);
			closeButton.setVisibility(View.GONE);
			findViewById(R.layout.search_field).setVisibility(View.GONE);

		}

	}

	public void search() {

		String name = editText.getText().toString();
		String address = editText2.getText().toString();

		JSONObject object = new JSONObject();
		try {
			object.put("name", name.toUpperCase());
			object.put("address", address.toUpperCase());
			object.put("poiType", poiType[spinner1.getSelectedItemPosition()]);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		adapter.getFilter().filter(object.toString());
		adapter.notifyDataSetChanged();
	}

	public class MyOnItemSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			if (spinner1.getSelectedItem().equals("Stomatologie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Radiologie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Cardiologie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Ginecologie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Pediatrie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Patologie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Oncologie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Macelarie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Oftalmologie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Ghipsologie")) {
				search();
			} else {

			}

		}

		public void onNothingSelected(AdapterView<?> arg0) {
			spinner1.getSelectedItem().equals("");
			{

			}
		}
	}
}
