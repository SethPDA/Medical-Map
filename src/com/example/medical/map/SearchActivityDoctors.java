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

import com.example.medical.callbacks.OnFinishAllMedics;
import com.example.medical.map.jsonhelper.Doctors;
import com.example.medical.map.util.WebService;

public class SearchActivityDoctors extends ListActivity {

	Button searchButton;
	Button closeButton;
	Spinner spinner1;
	private boolean isSearch = false;
	EditText editText, editText2;
	SearchArrayAdapterDoctors adapter;
	private String poiType[];
	ArrayList<Doctors> tempName = new ArrayList<Doctors>();
	public MyOnItemSelectedListener itemSelectListener;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_activity_layout_actionbar_doctors);
		adapter = new SearchArrayAdapterDoctors(this, tempName);
		setListAdapter(adapter);
		
		poiType = new String[] { "", "Medic de familie", "Veterinar",
				"Psiholog", "Stomatolog", "Biolog", "Morfolog", "Cardiolog",
				"Ginecolog" };
		
		ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(
				SearchActivityDoctors.this,
				android.R.layout.simple_spinner_item, poiType);
		adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		itemSelectListener = new MyOnItemSelectedListener();
		spinner1 = (Spinner) findViewById(R.id.spinnerSpecialityDoctors);
		spinner1.setAdapter(adapter0);
		spinner1.setOnItemSelectedListener(itemSelectListener);
		
		WebService.setOnFinishAllMedics(new OnFinishAllMedics() {

			public void onFinshAllMedics(ArrayList<Doctors> medics) {

				if (medics != null) {
					if (medics.size() > 0) {
						tempName.clear();
						tempName.addAll(medics);
						adapter.notifyDataSetChanged();
					}

				}

			}
		});

		WebService
				.GetAllMedic("http://82.77.55.81:9090/MedicalMap/MedicalMap.svc/GetAllMedic");

		final ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(SearchActivityDoctors.this,
						DetailsDoctors.class);
				intent.putExtra("Value", adapter.getItem(position));
				startActivity(intent);

			}
		});

		editText = (EditText) findViewById(R.id.editNameTextDoctors);
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

			}

		});

		editText2 = (EditText) findViewById(R.id.editSurrnameTextDoctors);
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

			}

		});

	}
	
	public void handleClick_search(View v) {

		ImageView searchButton = (ImageView) findViewById(R.id.searchButton);
		searchButton.setVisibility(View.INVISIBLE);
		ImageView closeButton = (ImageView) findViewById(R.id.closeButton);
		closeButton.setVisibility(View.VISIBLE);
		LinearLayout layout = (LinearLayout) findViewById(R.id.searchFieldLayout);
		layout.setVisibility(View.VISIBLE);

	}

	public void handleClick_closeSearch(View v) {

		ImageView searchButton = (ImageView) findViewById(R.id.searchButton);
		searchButton.setVisibility(View.VISIBLE);
		ImageView closeButton = (ImageView) findViewById(R.id.closeButton);
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
		String surname = editText2.getText().toString();

		JSONObject object = new JSONObject();
		try {
			object.put("name", name.toUpperCase());
			object.put("surname", surname.toUpperCase());
			object.put("poiType",poiType[spinner1.getSelectedItemPosition()]);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		adapter.getFilter().filter(object.toString());
		adapter.notifyDataSetChanged();
	}

	public class MyOnItemSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			if (spinner1.getSelectedItem().equals("Medic de familie")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Veterinar")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Psiholog")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Stomatolog")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Biolog")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Morfolog")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Cardiolog")) {
				search();
			} else if (spinner1.getSelectedItem().equals("Ginecolog")) {
				search();
			} else {
				search();
			}

		}

		public void onNothingSelected(AdapterView<?> arg0) {
			spinner1.getSelectedItem().equals("");
			{

			}
		}
	}
}
