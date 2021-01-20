package com.example.retroftipost.Interface;

import com.example.retroftipost.Modal.PostModal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface apis {
    @POST("post")
    Call<PostModal> loadDataInServer(@Body PostModal postModal);
}
