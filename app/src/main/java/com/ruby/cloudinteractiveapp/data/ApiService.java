package com.ruby.cloudinteractiveapp.data;

import com.ruby.cloudinteractiveapp.object.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("photos")
    Call<List<Photos>> getPhotos();

}
