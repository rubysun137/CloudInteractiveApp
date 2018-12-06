package com.ruby.cloudinteractiveapp.show;

import android.content.Context;

import com.ruby.cloudinteractiveapp.data.GetApiTask;
import com.ruby.cloudinteractiveapp.data.GetPhotosCallBack;
import com.ruby.cloudinteractiveapp.object.Photos;

import java.util.List;

public class ShowPresenter implements ShowContract.Presenter {

    private ShowContract.View mView;

    public ShowPresenter(ShowContract.View view, Context context) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        getData();
    }

    @Override
    public void getData() {
        new GetApiTask(new GetPhotosCallBack() {
            @Override
            public void onCompleted(List<Photos> photos) {
                mView.showPhotos(photos);
            }

            @Override
            public void onError(String errorMessage) {
                mView.showErrorMessage(errorMessage);
            }
        });
    }

}
