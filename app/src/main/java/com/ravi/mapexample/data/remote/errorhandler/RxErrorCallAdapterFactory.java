package com.ravi.mapexample.data.remote.errorhandler;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RxErrorCallAdapterFactory extends CallAdapter.Factory {
    private final RxJava2CallAdapterFactory rxJavaCallAdapterFactory;

    private RxErrorCallAdapterFactory() {
        rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    }

    public static CallAdapter.Factory create() {
        return new RxErrorCallAdapterFactory();
    }

    @SuppressWarnings("unchecked")
    @Override
    public CallAdapter<?, ?> get(@NonNull Type returnType, @NonNull Annotation[] annotations, @NonNull Retrofit retrofit) {
        return new RxCallAdapterWrapper(retrofit, rxJavaCallAdapterFactory.get(returnType, annotations, retrofit));
    }

    private static class RxCallAdapterWrapper<R> implements CallAdapter<R, Observable<?>> {
        private final Retrofit retrofit;
        private final CallAdapter<R, ?> callAdapter;

        RxCallAdapterWrapper(Retrofit retrofit, CallAdapter<R, ?> callAdapter) {
            this.retrofit = retrofit;
            this.callAdapter = callAdapter;
        }

        @Override
        public Type responseType() {
            return callAdapter.responseType();
        }

        @SuppressWarnings("unchecked")
        @Override
        public Observable<?> adapt(@NonNull Call<R> call) {
            return ((Observable) callAdapter.adapt(call)).onErrorResumeNext(new Function<Throwable, ObservableSource>() {
                @Override
                public ObservableSource apply(Throwable throwable) throws Exception {
                    return Observable.error(parseRetrofitException(throwable));
                }
            });
        }

        private RetrofitException parseRetrofitException(Throwable throwable) {
            if (throwable instanceof HttpException) {
                HttpException httpException = (HttpException) throwable;
                Response response = httpException.response();
                return RetrofitException.httpError(response.raw().request().url().toString(), response, retrofit);
            } else if (throwable instanceof IOException) {
                return RetrofitException.networkError((IOException) throwable);
            } else return RetrofitException.unexpectedError(throwable);
        }
    }
}