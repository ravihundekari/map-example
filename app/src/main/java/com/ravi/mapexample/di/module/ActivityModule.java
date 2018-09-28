package com.ravi.mapexample.di.module;

import android.app.Activity;
import android.content.Context;

import com.ravi.mapexample.di.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity acitivty;

    public ActivityModule(Activity acitivty) {
        this.acitivty = acitivty;
    }

    @Provides
    Activity provideActivity() {
        return acitivty;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return acitivty;
    }

}
