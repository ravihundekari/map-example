package com.ravi.mapexample.data;

import android.content.Context;

import com.ravi.mapexample.data.model.FarmData;
import com.ravi.mapexample.data.remote.MapApiService;
import com.ravi.mapexample.di.scope.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataManager {
    private MapApiService mapApiService;

    @Inject
    DataManager(@ApplicationContext Context context, MapApiService mapApiService) {
        this.mapApiService = mapApiService;
    }

    public Observable<List<FarmData>> getFarmDetails() {
        return mapApiService.getFarmDetailsApi();
    }
}
