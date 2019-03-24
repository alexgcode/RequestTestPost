package com.example.alexgf.requesttestpost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alexgf.requesttestpost.data.model.Expense;
import com.example.alexgf.requesttestpost.data.model.Post;
import com.example.alexgf.requesttestpost.data.model.Status;
import com.example.alexgf.requesttestpost.data.remote.APIService;
import com.example.alexgf.requesttestpost.data.remote.ApiUtils;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private TextView mResponseTv;

    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResponseTv = findViewById(R.id.txt_view);

        apiService = ApiUtils.getAPIService();

        //createPost();
        addExpense();
    }



    private void addExpense(){
        Expense expense = new Expense("test33", 133.6);

        Call<Status> call = apiService.addExpense(expense);

        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (!response.isSuccessful()){
                    mResponseTv.setText("code: " + response.code());
                    return;                                             //avoid the app stop in the main thread
                }

                Status statusResponse = response.body();

                mResponseTv.setText(statusResponse.getStatus());
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                mResponseTv.setText(t.getMessage());
            }
        });
    }
}

