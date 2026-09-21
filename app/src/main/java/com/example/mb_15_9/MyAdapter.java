package com.example.mb_15_9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private List<Article> articleList;
    LayoutInflater mInflater;

    public MyAdapter(Context context, List<Article> list) {
        mInflater = LayoutInflater.from(context);
        this.articleList = list;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.country_layout, parent, false);
        return new CountryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.tvTitle.setText(article.getTitle());
        holder.tvContent.setText(article.getContent());
        holder.tvViews.setText("Views: " + article.getView());
        holder.ivCover.setImageResource(article.getImgCover());
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
