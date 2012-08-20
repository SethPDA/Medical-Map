package com.example.medical.map;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.example.medical.map.jsonhelper.Doctors;
import com.example.medical.map.jsonhelper.Hospitals;

public class JsonArrayAdapter extends ArrayAdapter<Doctors> {
	private final Context context;
	private final ArrayList<Doctors> values;
	private ArrayList<Doctors> filteredValues;
	private ArrayList<Hospitals> filteredValuesHospitals;
	private Filter filter;

	
	
	public JsonArrayAdapter(Context context, ArrayList<Doctors> tempName) {
		//super (context,R.id.label, values);
		super(context, R.id.nameLabel);
		this.context = context;
		this.values = tempName;
		this.filteredValues = tempName;

	}
	
	
	
	@Override
	public int getCount() {
		return filteredValues.size();
	}

	@Override
	public Doctors getItem(int arg0) {
		return filteredValues.get(arg0);
	}


	
	public View getView(int position, View convertview, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View Rowview = inflater.inflate(R.layout.rowlayout_three, parent, false);
	
		TextView textview = (TextView) Rowview.findViewById(R.id.nameLabel);
		TextView textview2 = (TextView) Rowview.findViewById(R.id.surrnameLabel);
	
		/* search/filter stuff starts here again */
		
		Doctors item=filteredValues.get(position);
	textview.setText(item.getName());
	textview2.setText(item.getSurname());


		
	
		return Rowview;
	}


	public ArrayList<Doctors> getFilteredValues() {
		return filteredValues;
	}
	
	public ArrayList<Hospitals> getFilteredValuesHospitals() {
		return filteredValuesHospitals;
	}
	
	
	
	private class BetribesFilter extends Filter {

		@SuppressWarnings("unchecked")
		@Override
		protected FilterResults performFiltering(CharSequence prefix) {
			FilterResults retval = new FilterResults();
			retval.values = values;
			retval.count = values.size();

			if (prefix != null && prefix.toString().length() > 0) {
				prefix = prefix.toString().toUpperCase();
				@SuppressWarnings("rawtypes")
				ArrayList filt = new ArrayList();
				ArrayList<Doctors> tmpItems = new ArrayList<Doctors>();
				tmpItems.addAll(values);
				for (int i = 0; i < tmpItems.size(); i++) {
					Doctors sf = (Doctors) tmpItems.get(i);
					if (sf.Name.toUpperCase().contains(prefix)
							|| sf.Speciality.toUpperCase().contains(prefix)
							|| sf.Surname.toUpperCase().contains(prefix)) {
						// if(sf.Name.toUpperCase().contains(prefix)||sf.Artist.toUpperCase().contains(prefix)||sf.Genre.toUpperCase().contains(prefix)
						// || sf.Venue.toUpperCase().contains(prefix)) {
						filt.add(sf);
					}
				}
				retval.count = filt.size();
				retval.values = filt;
			}
			return retval;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {

			filteredValues = (ArrayList<Doctors>) results.values;

			if (results.count > 0) {
				notifyDataSetChanged();
			} else {
				notifyDataSetInvalidated();
			}
		}
	}

	public Filter getFilter() {
		if (filter == null) {
			filter = new BetribesFilter();
		}
		return filter;
	}
	
	
}
