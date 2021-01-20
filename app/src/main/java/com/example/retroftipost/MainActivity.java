package com.example.retroftipost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.retroftipost.Interface.apis;
import com.example.retroftipost.Modal.PostModal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btnPost;
    EditText edtText2;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);
        btnPost = findViewById(R.id.btnPost);
        edtText2 = findViewById(R.id.edtText2);


        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRetrofitPost();
            }
        });

    }

    private void callRetrofitPost() {
        String postBody = edtText2.getText().toString();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apis postModalApis = retrofit.create(apis.class);
        //Mock Data to test
        PostModal postModal = new PostModal("Fawad Post Data",postBody);
        Call<PostModal> call = postModalApis.loadDataInServer(postModal);
        call.enqueue(new Callback<PostModal>() {
            @Override
            public void onResponse(Call<PostModal> call, Response<PostModal> response) {
                //Display Data
                txtView.setText(response.body().getJson().getData());
            }

            @Override
            public void onFailure(Call<PostModal> call, Throwable t) {

            }
        });

    }
}