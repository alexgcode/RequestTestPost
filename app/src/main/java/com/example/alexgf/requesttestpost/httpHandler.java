package com.example.alexgf.requesttestpost;


import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class httpHandler {

    public static final MediaType JSON = MediaType.parse("application/json");

    public static String doPostOkHttp(String URL, String jsonObject) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, jsonObject);
        Request request = new Request.Builder()
                .url(URL)
                .post(body)
                .header("Content-type", "application/json")
                .build();
        /*try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                Log.d("Server response 200",response.body().string());
                return response.body().string();
            } else {
                Log.d("Server response Error","ERROR");
                return "Server response Error";
            }
        } catch (IOException e) {

        }
        */

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }
                final String responseData = response.body().string();

            }
        });

        return "Server response Error";
    }
}
