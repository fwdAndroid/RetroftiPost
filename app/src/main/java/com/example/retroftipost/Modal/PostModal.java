package com.example.retroftipost.Modal;

import com.google.gson.annotations.SerializedName;

public class PostModal {
    String title;

    @SerializedName("data")
    public String bodyPost;



    json json;

    public String getTitle() {
        return title;
    }

    public String getBodyPost() {
        return bodyPost;
    }

    public com.example.retroftipost.Modal.json getJson() {
        return json;
    }

    public PostModal(String title, String bodyPost) {
        this.title = title;
        this.bodyPost = bodyPost;
    }


}