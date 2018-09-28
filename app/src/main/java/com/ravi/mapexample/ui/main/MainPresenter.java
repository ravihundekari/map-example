package com.ravi.mapexample.ui.main;

import android.graphics.Color;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolygonOptions;
import com.ravi.mapexample.data.model.FarmData;
import com.ravi.mapexample.data.model.Farm_;
import com.ravi.mapexample.data.model.Field;
import com.ravi.mapexample.ui.base.BasePresenter;
import com.ravi.mapexample.util.RxHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

class MainPresenter extends BasePresenter<MainMvpView> {
    private RxHelper rxHelper;
    private static final String TAG = "MainPresenter";

    @Inject
    MainPresenter(RxHelper rxHelper) {
        this.rxHelper = rxHelper;
    }

    void callFarmDataApi() {
        getMvpView().showLoading();
        rxHelper.getFarmDetails(this::onFarmDetailsSuccess, this::onFarmDetailsError);
    }

    private void onFarmDetailsSuccess(List<FarmData> farmDataList) {
        if (isViewAttached()) {
            getMvpView().stopLoadingDialog();
            if (farmDataList != null && !farmDataList.isEmpty()) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                createAndDisplayMarker(new ArrayList<>(farmDataList.get(0).getFarms()), builder);

                createAndDisplayPolygon(new ArrayList<>(farmDataList.get(0).getFields()));

                getMvpView().animateCamera(builder);
            }
        }
    }

    private void createAndDisplayPolygon(List<Field> fieldList) {
        if (!fieldList.isEmpty()) {
            List<LatLng> latLngList = new ArrayList<>();
            for (Field field : fieldList) {
                List<List<List<Double>>> coordinatesList = field.getGeometry().getCoordinates();
                for (List<List<Double>> coordinates : coordinatesList) {
                    for (List<Double> latLngs : coordinates) {
                        LatLng latLng = new LatLng(latLngs.get(0), latLngs.get(1));
                        latLngList.add(latLng);
                    }
                    getMvpView().addPolygon(latLngList);
                    latLngList.clear();
                }
            }
        }
    }

    private void createAndDisplayMarker(List<Farm_> farmsList, LatLngBounds.Builder builder) {
        if (!farmsList.isEmpty()) {
            for (Farm_ farm_ : farmsList) {
                double lat = farm_.getGeometry().getCoordinates().get(0);
                double lng = farm_.getGeometry().getCoordinates().get(1);
                LatLng latLng = new LatLng(lat, lng);
                builder.include(latLng);
                getMvpView().createMarker(latLng, farm_.getProperties().getFarmName());
            }
        }
    }


    private void onFarmDetailsError(Throwable throwable) {
        if (isViewAttached()) {
            getMvpView().stopLoadingDialog();
            getMvpView().showErrorDialog(throwable.getMessage());
        }
    }

    PolygonOptions addPolygonOptions(List<LatLng> latLngList) {
        PolygonOptions polygonOptions = new PolygonOptions();
        for (LatLng latLng : latLngList) {
            polygonOptions.add(latLng)
                    .strokeWidth(1.5f)
                    .strokeColor(Color.RED)
                    .fillColor(Color.YELLOW);
        }
        return polygonOptions;
    }

    void clearCompositeDisposable() {
        rxHelper.dispose();
    }
}
