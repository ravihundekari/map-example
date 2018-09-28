package com.ravi.mapexample.di.component;

import android.app.Application;
import android.content.Context;

import com.ravi.mapexample.MapApplication;
import com.ravi.mapexample.data.DataManager;
import com.ravi.mapexample.di.module.ApplicationModule;
import com.ravi.mapexample.di.scope.ApplicationContext;
import com.ravi.mapexample.util.RxHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MapApplication mapApplication);

    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    RxHelper rxHelperBus();
}
