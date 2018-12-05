package com.ruby.cloudinteractiveapp.show;

import android.content.Context;

public class ShowPresenter implements ShowContract.Presenter {

    private ShowContract.View mView;

    public ShowPresenter(ShowContract.View view, Context context) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
