package com.ravi.mapexample.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ravi.mapexample.MapApplication;
import com.ravi.mapexample.di.component.ActivityComponent;
import com.ravi.mapexample.di.component.DaggerActivityComponent;
import com.ravi.mapexample.di.module.ActivityModule;

public class BaseAcitivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MapApplication.get(this).getApplicationComponent())
                    .build();
        }
        return activityComponent;
    }
}
