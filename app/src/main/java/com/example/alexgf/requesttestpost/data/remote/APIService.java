package com.example.alexgf.requesttestpost.data.remote;


import com.example.alexgf.requesttestpost.data.model.Expense;
import com.example.alexgf.requesttestpost.data.model.Post;
import com.example.alexgf.requesttestpost.data.model.Status;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/addexpense")
    @FormUrlEncoded
    Call<Post> savePost(@Field("description") String desc,
                        @Field("amount") Float amount);

    @POST("posts")
    Call<Post> createPost(@Body Post post);     //@Body is the body of the request

    @POST("addexpense")
    Call<Status> addExpense(@Body Expense expense);     //Status is the return part and body is the send part
}
