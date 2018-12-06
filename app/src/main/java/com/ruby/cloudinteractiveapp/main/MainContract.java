package com.ruby.cloudinteractiveapp.main;

import com.ruby.cloudinteractiveapp.BasePresenter;
import com.ruby.cloudinteractiveapp.BaseView;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void showFragment();

    }

    interface Presenter extends BasePresenter {

        void pressButton();

    }
}
