package com.ravi.mapexample;

import android.app.Application;
import android.content.Context;

import com.ravi.mapexample.di.component.ApplicationComponent;
import com.ravi.mapexample.di.component.DaggerApplicationComponent;
import com.ravi.mapexample.di.module.ApplicationModule;

public class MapApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    public static MapApplication get(Context context) {
        return (MapApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
            mApplicationComponent.inject(this);
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
