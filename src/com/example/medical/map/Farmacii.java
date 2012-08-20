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

import com.example.medical.callbacks.OnFinishAllPharmacy;
import com.example.medical.map.jsonhelper.Pharmacy;
import com.example.medical.map.util.WebService;

public class Farmacii extends ListActivity {

	Button searchButton;
	Button closeButton;
	private boolean isSearch = false;
	JsonArrayAdapterPharmacy adapter;
	EditText editText;
	ArrayList<Pharmacy> tempName = new ArrayList<Pharmacy>();

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.jsonlayouthospitals);

		adapter = new JsonArrayAdapterPharmacy(this, tempName);
		setListAdapter(adapter);

		WebService.setOnFinishAllPharmacy(new OnFinishAllPharmacy() {

			public void onFinishAllPharmacy(ArrayList<Pharmacy> list) {

				if (list != null) {
					if (list.size() > 0) {
						tempName.clear();
						tempName.addAll(list);
						adapter.notifyDataSetChanged();
					}

				}

			}

		});

		WebService
				.GetPOIByTypePharmacy("http://82.77.55.81:9090/MedicalMap/MedicalMap.svc/Getpoibytype/pharmacy");

		final ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(Farmacii.this, DetailsPharmacy.class);
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