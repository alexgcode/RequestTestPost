package com.example.alexgf.requesttestpost.data.remote;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://3.93.246.120:5000/";     //"https://jsonplaceholder.typicode.com/"

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
