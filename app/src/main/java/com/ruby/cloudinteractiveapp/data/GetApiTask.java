package com.ruby.cloudinteractiveapp.data;

import android.util.Log;

import com.ruby.cloudinteractiveapp.object.Photos;
import com.ruby.cloudinteractiveapp.show.ShowContract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetApiTask {

    private GetPhotosCallBack mCallBack;

    public GetApiTask(GetPhotosCallBack callBack) {

        mCallBack = callBack;

        Call<List<Photos>> call = RetrofitManager.getInstance().getApi().getPhotos();
        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                List<Photos> photos = new ArrayList<>(response.body());
                Log.d("TAG", "onResponse: " + photos.toString());
                mCallBack.onCompleted(photos);
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {
                mCallBack.onError(t.getMessage());
            }
        });
    }

}
