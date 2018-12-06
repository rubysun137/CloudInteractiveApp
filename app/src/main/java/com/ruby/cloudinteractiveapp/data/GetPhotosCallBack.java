package com.ruby.cloudinteractiveapp.data;

import com.ruby.cloudinteractiveapp.object.Photos;

import java.util.List;

public interface GetPhotosCallBack {
    void onCompleted(List<Photos> photos);
    void onError(String errorMessage);
}
