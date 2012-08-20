package com.example.medical.map;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.medical.map.mapviewballons.BalloonItemizedOverlay;
import com.example.medical.map.mapviewballons.BalloonOverlayView;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;


public class CustomItemizedOverlay<Item extends OverlayItem> extends BalloonItemizedOverlay<CustomOverlayItem> {

	private ArrayList<CustomOverlayItem> m_overlays = new ArrayList<CustomOverlayItem>();
	private Context c;
	
	
	protected static OnBalloonTapListener mOnBalloonTapListener;
	
	public void setOnBalloonTapListener(OnBalloonTapListener l) {
		this.mOnBalloonTapListener = l;
	}
	
	
	
	public CustomItemizedOverlay(Drawable defaultMarker, MapView mapView) {
		super(boundCenter(defaultMarker), mapView);
		c = mapView.getContext();
	}

	public void addOverlay(CustomOverlayItem overlay) {
	    m_overlays.add(overlay);
	    populate();
	}

	@Override
	protected CustomOverlayItem createItem(int i) {
		return m_overlays.get(i);
	}

	@Override
	public int size() {
		return m_overlays.size();
	}

	protected  boolean onBalloonTap(int index, CustomOverlayItem item) {
		
		
		if(mOnBalloonTapListener!=null)			
		{
			mOnBalloonTapListener.OnBalloonTap(index, item);
		}
		
		return true;
		
	}

	@Override
	protected BalloonOverlayView<CustomOverlayItem> createBalloonOverlayView() {
		return new CustomBalloonOverlayView<CustomOverlayItem>(getMapView().getContext(), getBalloonBottomOffset());
	}

}
