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
import com.example.medical.map.jsonhelper.FilterDoctors;
import com.example.medical.map.jsonhelper.JsonHelper;

public class SearchArrayAdapterDoctors extends ArrayAdapter<Doctors> {
	private final Context context;
	private final ArrayList<Doctors> values;
	private ArrayList<Doctors> filteredValues;
	private Filter filter;

	public SearchArrayAdapterDoctors(Context context,
			ArrayList<Doctors> tempName) {
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
	public Doctors getItem(int arg0) {
		return filteredValues.get(arg0);
	}

	public View getView(int position, View convertview, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View Rowview = inflater
				.inflate(R.layout.rowlayout_hospitals, parent, false);

		TextView textview = (TextView) Rowview.findViewById(R.id.nameLabel);

		/* search/filter stuff starts here again */

		Doctors item = filteredValues.get(position);
		textview.setText(item.getName());

		return Rowview;
	}

	public ArrayList<Doctors> getFilteredValues() {
		return filteredValues;
	}

	private class BetribesFilter extends Filter {


		@Override
		protected FilterResults performFiltering(CharSequence prefix) {

			FilterDoctors filterDoctors=JsonHelper.parseFilterdoctors(prefix.toString());


			FilterResults retval = new FilterResults();
			retval.values = values;
			retval.count = values.size();

			if(filterDoctors!=null &&(filterDoctors.getName().length()>0||filterDoctors.getSurname().length()>0||filterDoctors.getPoiType().length()>0))
			{
				ArrayList filt = new ArrayList();
				ArrayList<Doctors> tmpItems = new ArrayList<Doctors>();
				tmpItems.addAll(values);
				for (int i = 0; i < tmpItems.size(); i++) {
					Doctors sf = (Doctors) tmpItems.get(i);

					if(filterDoctors.getName().length()>0 &&filterDoctors.getSurname().length()>0&&filterDoctors.getPoiType().length()>0)
					{
						if (sf.Name.toUpperCase().contains(filterDoctors.getName().toUpperCase())	|| sf.Surname.toString().toUpperCase().contains(filterDoctors.getSurname().toUpperCase())
								|| sf.getSpeciality().toString().toUpperCase().contains(filterDoctors.getPoiType().toUpperCase()	
										)) {

							filt.add(sf);

						}
					}else			

						if(filterDoctors.getName().length()>0 &&filterDoctors.getSurname().length()>0)
						{
							if (sf.Name.toUpperCase().contains(filterDoctors.getName().toUpperCase())	|| sf.Surname.toString().toUpperCase().contains(filterDoctors.getSurname().toUpperCase())) {

								filt.add(sf);

							}
						}else if(filterDoctors.getName().length()>0 &&filterDoctors.getPoiType().length()>0)
						{
							if (sf.Name.toUpperCase().contains(filterDoctors.getName().toUpperCase()) &&sf.getSpeciality().toString().toUpperCase().contains(filterDoctors.getPoiType().toUpperCase())) {

								filt.add(sf);

							}
						}else if(filterDoctors.getName().length()>0)
						{
							if (sf.Name.toUpperCase().contains(filterDoctors.getName().toUpperCase())) {

								filt.add(sf);

							}
						}
						else if(filterDoctors.getSurname().length()>0)
						{
							if (sf.Surname.toUpperCase().contains(filterDoctors.getSurname().toUpperCase())) {

								filt.add(sf);

							}
						}else 	if(filterDoctors.getPoiType().length()>0)
						{
							String  specialities = sf.getSpeciality().toString().toUpperCase();
							String filterSpeciality = filterDoctors.getPoiType().toUpperCase();
							if ( sf.getSpeciality().toString().toUpperCase().contains(filterDoctors.getPoiType().toUpperCase()) || filterDoctors.getPoiType().toUpperCase() == "")
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
