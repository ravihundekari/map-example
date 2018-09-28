package com.ravi.mapexample.data.remote;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.mapexample.BuildConfig;
import com.ravi.mapexample.data.remote.errorhandler.RxErrorCallAdapterFactory;
import com.ravi.mapexample.util.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitFactory {

    public static OkHttpClient getOkHttpClient(Cache cache) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .cache(cache)
                .addInterceptor(logging);
        return builder.build();
    }

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @NonNull
    public static Retrofit getRetrofit(OkHttpClient okHttpClient, ObjectMapper objectMapper) {
        return new Retrofit.Builder()
                .baseUrl(Constants.MAP_SERVER_ENDPOINT)
                .client(okHttpClient)
                .addCallAdapterFactory(RxErrorCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
    }
}
