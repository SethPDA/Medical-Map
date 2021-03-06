package com.example.medical.map;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medical.map.jsonhelper.Hospitals;
import com.example.medical.map.util.DbManager;
import com.example.medical.map.util.ImageDownloader;
import com.example.medical.map.util.WebService;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class DetailsHospitals extends Activity {

	String rating;
	Hospitals hospitals;
	final DbManager db = new DbManager(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detailslayout_actionbar);

		WebService
				.GetPOIByType("http://82.77.55.81:9090/MedicalMap/MedicalMap.svc/Getpoibytype/hospital");

		Bundle extras = getIntent().getExtras();

		TextView textView = (TextView) findViewById(R.id.label);
		TextView textViewTwo = (TextView) findViewById(R.id.descDetailsPhone);
		TextView textViewThree = (TextView) findViewById(R.id.descDetailsSpecialities);
		TextView textViewFive = (TextView) findViewById(R.id.descDetailsAddressCity);
		TextView textViewFour = (TextView) findViewById(R.id.descDetailsAddressNumber);
		TextView textViewSix = (TextView) findViewById(R.id.descDetailsAddressStreet);
		TextView textViewSeven = (TextView) findViewById(R.id.descDetailsSchedule);
		TextView textViewEight = (TextView) findViewById(R.id.descDetailsRemark);
		TextView textViewNine = (TextView) findViewById(R.id.descDetailsType);
		TextView textViewTen = (TextView) findViewById(R.id.descDetailsIsSpecial);
		TextView textViewEleven = (TextView) findViewById(R.id.ratingText);
		TextView textViewTwelve = (TextView) findViewById(R.id.descDetailsSpecialities2);
		TextView textViewThirteen = (TextView) findViewById(R.id.descDetailsSpecialities3);
		TextView textViewFourteen = (TextView) findViewById(R.id.descDetailsSpecialities4);
		TextView textViewFifteen = (TextView) findViewById(R.id.descDetailsSpecialities5);
		TextView textViewSixteen = (TextView) findViewById(R.id.descDetailsSpecialities6);
		TextView textViewSeventeen = (TextView) findViewById(R.id.descDetailsSpecialities7);
		TextView textViewEighteen = (TextView) findViewById(R.id.descDetailsSpecialities8);
		TextView textViewNineteen = (TextView) findViewById(R.id.descDetailsSpecialities9);
		TextView textViewTwenty = (TextView) findViewById(R.id.descDetailsSpecialities10);
		ImageView imageView = (ImageView) findViewById(R.id.contactImage1);

		ImageDownloader imageDownloader = new ImageDownloader();

		if (extras != null) {
			hospitals = (Hospitals) extras.getSerializable("Value");

			textView.setText(hospitals.getName());
			textViewTwo.setText(hospitals.getPhone());

			if (!TextUtils.isEmpty(hospitals.getLogo())) {
				imageDownloader.download(getString(R.string.url_base)
						+ hospitals.getLogo(), imageView);
			}

			textViewFive.setText(hospitals.getAddress().getCity());
			textViewFour.setText(Integer.toString(hospitals.getAddress()
					.getNumber()));
			textViewSix.setText(hospitals.getAddress().getStreet());
			textViewSeven.setText(hospitals.getSchedule().getName());
			textViewEight.setText(hospitals.getRemark());
			textViewNine.setText(hospitals.getType());
			textViewTen.setText(Boolean.toString(hospitals.getIsSpecial()));
			textViewEleven.setText(Integer.toString(hospitals.getRating()));
			if (!canRate(Integer.toString(hospitals.ID), hospitals.Type)) {
				ImageView rate_icon = (ImageView) findViewById(R.id.rate_icon);
				rate_icon.setImageResource(R.drawable.rate_icon_pressed);
			}

			if (hospitals.getSpecialities() != null) {
				if (hospitals.getSpecialities().size() > 0) {
					textViewThree.setText(hospitals.getSpecialities().get(0)
							.getName());
					if (hospitals.getSpecialities().size() > 1) {
						textViewTwelve.setText(hospitals.getSpecialities()
								.get(1).getName());
					}
					if (hospitals.getSpecialities().size() > 2) {
						textViewThirteen.setText(hospitals.getSpecialities()
								.get(2).getName());
					}
					if (hospitals.getSpecialities().size() > 3) {
						textViewFourteen.setText(hospitals.getSpecialities()
								.get(3).getName());
					}
					if (hospitals.getSpecialities().size() > 4) {
						textViewFifteen.setText(hospitals.getSpecialities()
								.get(4).getName());
					}
					if (hospitals.getSpecialities().size() > 5) {
						textViewSixteen.setText(hospitals.getSpecialities()
								.get(5).getName());
					}
					if (hospitals.getSpecialities().size() > 6) {
						textViewSeventeen.setText(hospitals.getSpecialities()
								.get(6).getName());
					}
					if (hospitals.getSpecialities().size() > 7) {
						textViewEighteen.setText(hospitals.getSpecialities()
								.get(7).getName());
					}
					if (hospitals.getSpecialities().size() > 8) {
						textViewNineteen.setText(hospitals.getSpecialities()
								.get(8).getName());
					}
					if (hospitals.getSpecialities().size() > 9) {
						textViewTwenty.setText(hospitals.getSpecialities()
								.get(9).getName());
					}

				} else {
				}
			}
		}

	}

	public void insert() {

		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime()
				.getTime());
		String time = currentTimestamp.toString();
		db.open();
		db.insert(Integer.toString(hospitals.getId()), hospitals.getType(),
				currentTimestamp.toString());

		ArrayList<String[]> entries = db.getAll();
		for (String[] entry : entries)
			Log.d("Rating", entry[0].toString());

		db.close();

	}

	public void update(String ID, String type) {

		db.open();
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime()
				.getTime());
		db.update(ID, type, currentTimestamp.toString());
		db.close();

	}

	public boolean canRate(String ID, String type) {
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime()
				.getTime());

		String[] result;
		db.open();
		result = db.getByIdAndType(ID, type);
		if (result[2] != null) {
			Timestamp oldTimestamp = Timestamp.valueOf(result[2]);

			long diffSeconds = (currentTimestamp.getTime() / 1000)
					- (oldTimestamp.getTime() / 1000);

			if (diffSeconds < 604800)
				return false;
			else
				return true;
		} else {
			return true;
		}
	}

	public void clickRateIcon(View v) {

		if (canRate(Integer.toString(hospitals.ID), hospitals.Type)) {

			insert();

			AsyncHttpClient client = new AsyncHttpClient();
			String url = "http://82.77.55.81:9090/MedicalMap/MedicalMap.svc/rating/?id="
					+ Integer.toString(hospitals.ID)
					+ "&type="
					+ hospitals.Type;
			client.get(url, new AsyncHttpResponseHandler() {

				public void onSuccess(String response) {
					String[] components = response.split("\\:");
					String rating = components[1].substring(0,
							components[1].length() - 1);
					hospitals.setRating(Integer.parseInt(rating));
					TextView ratingText = (TextView) findViewById(R.id.ratingText);
					ratingText.setText(rating);
					ImageView rate_icon = (ImageView) findViewById(R.id.rate_icon);
					rate_icon.setImageResource(R.drawable.rate_icon_pressed);
					Toast.makeText(getApplicationContext(),
							"Thank you for rating!", Toast.LENGTH_SHORT).show();

				}

			});

		} else {

			Toast.makeText(getApplicationContext(), "Not able to rate yet",
					Toast.LENGTH_SHORT).show();

		}

	}

	public void clickShowMapButton(View v) {

		Intent intent = new Intent(this, SimpleMapActivity.class);
		intent.putExtra("Value", hospitals);
		startActivity(intent);
	}

}
