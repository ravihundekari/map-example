package com.ravi.mapexample.ui.main;

import android.os.Bundle;
import android.util.DisplayMetrics;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ravi.mapexample.R;
import com.ravi.mapexample.ui.base.BaseAcitivity;
import com.ravi.mapexample.util.DialogUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseAcitivity implements MainMvpView, OnMapReadyCallback {
    @Inject
    MainPresenter mainPresenter;
    private GoogleMap mMap;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        mainPresenter.attachView(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mainPresenter.callFarmDataApi();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    public void showLoading() {
        DialogUtil.showLoadingDialog(this, getString(R.string.all_please_wait));
    }

    @Override
    public void stopLoadingDialog() {
        DialogUtil.stopLoadingDialog();
    }

    @Override
    public void showErrorDialog(String message) {
        DialogUtil.showErrorDialog(this, message);
    }

    @Override
    public void createMarker(LatLng latLng, String title) {
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(title));
    }

    @Override
    public void animateCamera(LatLngBounds.Builder builder) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), dpToPx(80)));
    }

    @Override
    public void addPolygon(List<LatLng> latLngList) {
        mMap.addPolygon(mainPresenter.addPolygonOptions(latLngList));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
        mainPresenter.clearCompositeDisposable();
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
