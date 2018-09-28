package com.ravi.mapexample.ui.base;

public class BasePresenter<V extends MvpView> implements Presenter<V> {
    private V mvpView;

    protected V getMvpView() {
        return mvpView;
    }

    protected boolean isViewAttached() {
        return mvpView != null;
    }

    @Override
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    public void checkIfViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    private static class MvpViewNotAttachedException extends RuntimeException {
        MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before requesting data to the Presenter");
        }
    }
}
