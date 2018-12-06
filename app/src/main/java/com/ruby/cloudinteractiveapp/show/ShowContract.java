package com.ruby.cloudinteractiveapp.show;

import com.ruby.cloudinteractiveapp.BasePresenter;
import com.ruby.cloudinteractiveapp.BaseView;
import com.ruby.cloudinteractiveapp.object.Photos;

import java.util.List;

public interface ShowContract {

    interface View extends BaseView<Presenter> {

        void showErrorMessage(String errorMessage);

        void showPhotos(List<Photos> photos);

    }

    interface Presenter extends BasePresenter {

        void getData();


    }
}
