package com.example.medical.map;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.medical.callbacks.OnFinishAllMedics;
import com.example.medical.map.jsonhelper.Doctors;
import com.example.medical.map.util.WebService;

public class Medici extends ListActivity {

	Button searchButton;
	Button closeButton;
	private boolean isSearch = false;
	JsonArrayAdapter adapter;
	EditText editText;
	ArrayList<Doctors> tempName = new ArrayList<Doctors>();

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.jsonlayout);

		adapter = new JsonArrayAdapter(this, tempName);
		setListAdapter(adapter);

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

				Intent intent = new Intent(Medici.this, DetailsDoctors.class);
				intent.putExtra("Value", adapter.getItem(position));
				startActivity(intent);

			}
		});

		editText = (EditText) findViewById(R.id.editText1);
		editText.addTextChangedListener(new TextWatcher() {

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				adapter.getFilter().filter(s); // Filter from my adapter
				adapter.notifyDataSetChanged(); // Update my view
			}

			public void afterTextChanged(Editable s) {

			}

		});

	}

	public void handleClick_search(View v) {

		ImageView searchButton = (ImageView) findViewById(R.id.searchButton);
		searchButton.setVisibility(View.INVISIBLE);
		LinearLayout layout = (LinearLayout) findViewById(R.id.searchFieldLayout);
		layout.setVisibility(View.VISIBLE);

	}

	public void handleClick_closeSearch(View v) {

		ImageView searchButton = (ImageView) findViewById(R.id.searchButton);
		searchButton.setVisibility(View.VISIBLE);
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

};
