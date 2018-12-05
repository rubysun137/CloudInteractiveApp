package com.ruby.cloudinteractiveapp.main;

import android.content.Context;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    public MainPresenter(MainContract.View view, Context context) {
        mView = checkNotNull(view);
        mView.setPresenter(this);

    }

    @Override
    public void start() {

    }

    @Override
    public void pressButton() {
        mView.showFragment();
    }
}
