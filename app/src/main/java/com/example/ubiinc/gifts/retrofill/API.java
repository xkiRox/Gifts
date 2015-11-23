package com.example.ubiinc.gifts.retrofill;

import com.example.ubiinc.gifts.response.User;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by ubiinc on 23/11/15.
 */
public interface API {

    @FormUrlEncoded
    @POST("/api/login")
    void login(@FieldMap Map<String, String> params, Callback<User> cb);
}
