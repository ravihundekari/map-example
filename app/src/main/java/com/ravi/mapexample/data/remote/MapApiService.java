package com.ravi.mapexample.data.remote;

import com.ravi.mapexample.data.model.FarmData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MapApiService {

    @GET("interview-question-data/farm/farms.json")
    Observable<List<FarmData>> getFarmDetailsApi();
}
