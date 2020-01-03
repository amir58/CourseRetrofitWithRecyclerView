package com.amirmohammed.servicebroadcastreceiver;

import com.amirmohammed.servicebroadcastreceiver.newsmodel.NewsResponce;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {

    @GET("v2/top-headlines?country=eg&category=sport&apiKey=c4652d58322344a783a6cea9e37e0707")
    Call<NewsResponce> getNews();

}
