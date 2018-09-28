package com.ravi.mapexample.ui.base;

interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
