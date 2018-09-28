package com.ravi.mapexample.ui.main;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.ravi.mapexample.ui.base.MvpView;

import java.util.List;

interface MainMvpView extends MvpView {

    void showLoading();

    void stopLoadingDialog();

    void showErrorDialog(String message);

    void createMarker(LatLng latLng, String title);

    void animateCamera(LatLngBounds.Builder builder);

    void addPolygon(List<LatLng> latLngList);
}
