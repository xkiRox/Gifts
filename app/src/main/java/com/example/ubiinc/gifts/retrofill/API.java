package com.example.ubiinc.gifts.retrofill;

import com.example.ubiinc.gifts.response.Product;
import com.example.ubiinc.gifts.response.User;

import java.util.ArrayList;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by ubiinc on 23/11/15.
 */
public interface API {

    @FormUrlEncoded
    @POST("/api/login")
    void login(@FieldMap Map<String, String> params, Callback<User> cb);

    @GET("/api/product")
    void productList(@FieldMap Callback<ArrayList<Product>> cb);
}
