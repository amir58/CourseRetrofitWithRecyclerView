package com.amirmohammed.servicebroadcastreceiver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amirmohammed.servicebroadcastreceiver.newsmodel.Article;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter
        <NewsAdapter.NewsViewHolder> {

    List<Article> articles;

    public NewsAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        Article currentArticle = articles.get(position);

        holder.textView.setText(currentArticle.getTitle());

        Picasso.get().load(currentArticle.getUrlToImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        MaterialCardView materialCardView;
        ImageView imageView;
        TextView textView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            materialCardView = itemView.findViewById(R.id.item_card);
            imageView = itemView.findViewById(R.id.item_iv);
            textView = itemView.findViewById(R.id.item_title);
        }
    }

}
