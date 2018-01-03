package com.example.cdoherty.teamworkspike.api;

import com.example.cdoherty.teamworkspike.Model.Project;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cdoherty on 27/12/2017.
 */

public class ApiClient {

    public static final String API_URL = "https://yat.teamwork.com/";
    public static final String AUTH_TOKEN = "eWF0QHRyaXBsZXNwaW4uY29tOnlhdHlhdHlhdDI3";


    public static TeamWork getAuthApi() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request authed = chain.request()
                                .newBuilder()
                                .header("Authorization", "Basic " + AUTH_TOKEN)
                                .build();
                        return chain.proceed(authed);
                    }
                }).build();

        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TeamWork.class);
    }
}
