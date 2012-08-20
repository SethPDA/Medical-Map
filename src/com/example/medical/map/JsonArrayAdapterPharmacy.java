package com.example.medical.map;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.example.medical.map.jsonhelper.Pharmacy;

public class JsonArrayAdapterPharmacy extends ArrayAdapter<Pharmacy> {
	private final Context context;
	private final ArrayList<Pharmacy> values;
	private ArrayList<Pharmacy> filteredValues;
	private Filter filter;

	public JsonArrayAdapterPharmacy(Context context,
			ArrayList<Pharmacy> tempName) {
		// super (context,R.id.label, values);
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
	public Pharmacy getItem(int arg0) {
		return filteredValues.get(arg0);
	}

	public View getView(int position, View convertview, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View Rowview = inflater
				.inflate(R.layout.rowlayout_hospitals, parent, false);

		TextView textview = (TextView) Rowview.findViewById(R.id.nameLabel);

		/* search/filter stuff starts here again */

		Pharmacy item = filteredValues.get(position);
		textview.setText(item.getName());

		return Rowview;
	}

	public ArrayList<Pharmacy> getFilteredValues() {
		return filteredValues;
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
				ArrayList<Pharmacy> tmpItems = new ArrayList<Pharmacy>();
				tmpItems.addAll(values);
				for (int i = 0; i < tmpItems.size(); i++) {
					Pharmacy sf = (Pharmacy) tmpItems.get(i);
					if (sf.Name.toUpperCase().contains(prefix)
							|| sf.Address.toString().contains(prefix)) {

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

			filteredValues = (ArrayList<Pharmacy>) results.values;

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
