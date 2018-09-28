package com.ravi.mapexample.util;

import com.ravi.mapexample.data.DataManager;
import com.ravi.mapexample.data.model.FarmData;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RxHelper {
    private DataManager dataManager;
    private CompositeDisposable compositeDisposable;

    @Inject
    public RxHelper(DataManager dataManager) {
        this.dataManager = dataManager;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void getFarmDetails(RxApiCallback<List<FarmData>> onFarmDetailsSuccess, RxApiCallback<Throwable> onFarmDetailsError) {
        compositeDisposable.add(dataManager.getFarmDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onFarmDetailsSuccess::onProcess, onFarmDetailsError::onProcess));
    }

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }

    public interface RxApiCallback<R> {
        void onProcess(R result);
    }
}
