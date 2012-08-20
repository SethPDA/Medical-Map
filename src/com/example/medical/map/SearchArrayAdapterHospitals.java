package com.example.medical.map;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.example.medical.map.jsonhelper.FilterHospital;
import com.example.medical.map.jsonhelper.Hospitals;
import com.example.medical.map.jsonhelper.JsonHelper;

public class SearchArrayAdapterHospitals extends ArrayAdapter<Hospitals> {
	private final Context context;
	private final ArrayList<Hospitals> values;
	private ArrayList<Hospitals> filteredValues;
	private Filter filter;

	public SearchArrayAdapterHospitals(Context context,
			ArrayList<Hospitals> tempName) {
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
	public Hospitals getItem(int arg0) {
		return filteredValues.get(arg0);
	}

	public View getView(int position, View convertview, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View Rowview = inflater
				.inflate(R.layout.rowlayout_hospitals, parent, false);

		TextView textview = (TextView) Rowview.findViewById(R.id.nameLabel);

		/* search/filter stuff starts here again */

		Hospitals item = filteredValues.get(position);
		textview.setText(item.getName());

		return Rowview;
	}

	public ArrayList<Hospitals> getFilteredValues() {
		return filteredValues;
	}

	private class BetribesFilter extends Filter {


		@Override
		protected FilterResults performFiltering(CharSequence prefix) {

			FilterHospital filterHospital=JsonHelper.parseFilterhospital(prefix.toString());


			FilterResults retval = new FilterResults();
			retval.values = values;
			retval.count = values.size();

			if(filterHospital!=null &&(filterHospital.getName().length()>0||filterHospital.getAddress().length()>0||filterHospital.getPoiType().length()>0))
			{
				ArrayList filt = new ArrayList();
				ArrayList<Hospitals> tmpItems = new ArrayList<Hospitals>();
				tmpItems.addAll(values);
				for (int i = 0; i < tmpItems.size(); i++) {
					Hospitals sf = (Hospitals) tmpItems.get(i);

					if(filterHospital.getName().length()>0 &&filterHospital.getAddress().length()>0&&filterHospital.getPoiType().length()>0)
					{
						if (sf.Name.toUpperCase().contains(filterHospital.getName().toUpperCase())	|| sf.Address.toString().toUpperCase().contains(filterHospital.getAddress().toUpperCase())
								|| sf.getSpecialities().toString().toUpperCase().contains(filterHospital.getPoiType().toUpperCase()	
										)) {

							filt.add(sf);

						}
					}else			

						if(filterHospital.getName().length()>0 &&filterHospital.getAddress().length()>0)
						{
							if (sf.Name.toUpperCase().contains(filterHospital.getName().toUpperCase())	|| sf.Address.toString().toUpperCase().contains(filterHospital.getAddress().toUpperCase())) {

								filt.add(sf);

							}
						}else if(filterHospital.getName().length()>0 &&filterHospital.getPoiType().length()>0)
						{
							if (sf.Name.toUpperCase().contains(filterHospital.getName().toUpperCase()) &&sf.getSpecialities().toString().toUpperCase().contains(filterHospital.getPoiType().toUpperCase())) {

								filt.add(sf);

							}
						}else if(filterHospital.getName().length()>0)
						{
							if (sf.Name.toUpperCase().contains(filterHospital.getName().toUpperCase())) {

								filt.add(sf);

							}
						}
						else if(filterHospital.getAddress().length()>0)
						{
							if (sf.Address.toString().toUpperCase().contains(filterHospital.getAddress().toUpperCase())) {

								filt.add(sf);

							}
						}else 	if(filterHospital.getPoiType().length()>0)
						{
							String  specialities = sf.getSpecialities().toString().toUpperCase();
							String filterSpeciality = filterHospital.getPoiType().toUpperCase();
							if ( sf.getSpecialities().toString().toUpperCase().contains(filterHospital.getPoiType().toUpperCase()))
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

			filteredValues = (ArrayList<Hospitals>) results.values;

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
