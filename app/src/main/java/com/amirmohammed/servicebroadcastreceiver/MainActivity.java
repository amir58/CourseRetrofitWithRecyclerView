package com.amirmohammed.servicebroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.amirmohammed.servicebroadcastreceiver.newsmodel.NewsResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.news_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getNews();


    }

    private void getNews() {
        NewsApi call = RetrofitClient.getService();
        call.getNews().enqueue(new Callback<NewsResponce>() {
            @Override
            public void onResponse(Call<NewsResponce> call, Response<NewsResponce> response) {
                adapter = new NewsAdapter(response.body().getArticles());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsResponce> call, Throwable t) {

            }
        });

    }

}
