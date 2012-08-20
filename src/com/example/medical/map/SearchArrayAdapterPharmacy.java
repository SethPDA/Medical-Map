package com.example.medical.map;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.example.medical.map.jsonhelper.FilterPharmacy;
import com.example.medical.map.jsonhelper.JsonHelper;
import com.example.medical.map.jsonhelper.Pharmacy;

public class SearchArrayAdapterPharmacy extends ArrayAdapter<Pharmacy> {
	private final Context context;
	private final ArrayList<Pharmacy> values;
	private ArrayList<Pharmacy> filteredValues;
	private Filter filter;

	public SearchArrayAdapterPharmacy(Context context,
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


		@Override
		protected FilterResults performFiltering(CharSequence prefix) {

			FilterPharmacy filterPharmacy=JsonHelper.parseFilterpharmacy(prefix.toString());


			FilterResults retval = new FilterResults();
			retval.values = values;
			retval.count = values.size();

			if(filterPharmacy!=null &&(filterPharmacy.getName().length()>0||filterPharmacy.getAddress().length()>0||filterPharmacy.getPoiType().length()>0))
			{
				ArrayList filt = new ArrayList();
				ArrayList<Pharmacy> tmpItems = new ArrayList<Pharmacy>();
				tmpItems.addAll(values);
				for (int i = 0; i < tmpItems.size(); i++) {
					Pharmacy sf = (Pharmacy) tmpItems.get(i);

					if(filterPharmacy.getName().length()>0 &&filterPharmacy.getAddress().length()>0&&filterPharmacy.getPoiType().length()>0)
					{
						if (sf.Name.toUpperCase().contains(filterPharmacy.getName().toUpperCase())	|| sf.Address.toString().toUpperCase().contains(filterPharmacy.getAddress().toUpperCase())
								|| sf.getSpecialities().toString().toUpperCase().contains(filterPharmacy.getPoiType().toUpperCase()	
										)) {

							filt.add(sf);

						}
					}else			

						if(filterPharmacy.getName().length()>0 &&filterPharmacy.getAddress().length()>0)
						{
							if (sf.Name.toUpperCase().contains(filterPharmacy.getName().toUpperCase())	|| sf.Address.toString().toUpperCase().contains(filterPharmacy.getAddress().toUpperCase())) {

								filt.add(sf);

							}
						}else if(filterPharmacy.getName().length()>0 &&filterPharmacy.getPoiType().length()>0)
						{
							if (sf.Name.toUpperCase().contains(filterPharmacy.getName().toUpperCase()) &&sf.getSpecialities().toString().toUpperCase().contains(filterPharmacy.getPoiType().toUpperCase())) {

								filt.add(sf);

							}
						}else if(filterPharmacy.getName().length()>0)
						{
							if (sf.Name.toUpperCase().contains(filterPharmacy.getName().toUpperCase())) {

								filt.add(sf);

							}
						}
						else if(filterPharmacy.getAddress().length()>0)
						{
							if (sf.Address.toString().toUpperCase().contains(filterPharmacy.getAddress().toUpperCase())) {

								filt.add(sf);

							}
						}else 	if(filterPharmacy.getPoiType().length()>0)
						{
							String  specialities = sf.getSpecialities().toString().toUpperCase();
							String filterSpeciality = filterPharmacy.getPoiType().toUpperCase();
							if ( sf.getSpecialities().toString().toUpperCase().contains(filterPharmacy.getPoiType().toUpperCase()))
							{

								filt.add(sf);

							}
						}
					retval.count = filt.size();
					retval.values = filt;



				}
			}
			return retval;
		}






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
