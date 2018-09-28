package com.ravi.mapexample.di.component;

import com.ravi.mapexample.di.module.ActivityModule;
import com.ravi.mapexample.di.scope.PerAcitivty;
import com.ravi.mapexample.ui.main.MainActivity;

import dagger.Component;

@PerAcitivty
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
