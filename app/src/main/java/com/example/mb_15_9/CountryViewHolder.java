package com.example.mb_15_9;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private MyAdapter madapter;
    private Article currentArticle;

    public TextView tvTitle;
    public TextView tvContent;
    public TextView tvViews;
    public ImageView ivCover;

    public CountryViewHolder(View item, MyAdapter adapter) {
        super(item);
        this.madapter = adapter;
        this.tvTitle   = item.findViewById(R.id.tvTitle);
        this.tvContent = item.findViewById(R.id.tvContent);
        this.tvViews   = item.findViewById(R.id.tvViews);
        this.ivCover   = item.findViewById(R.id.ivCover);
        item.setOnClickListener(this);
    }

    /** Gắn article hiện tại để dùng khi click */
    public void bind(Article article) {
        this.currentArticle = article;
    }

    @Override
    public void onClick(View v) {
        if (currentArticle == null) return;

        // Tăng lượt xem
        currentArticle.increaseView();
        tvViews.setText("Views: " + currentArticle.getView());

        // Mở màn hình chi tiết, truyền article qua Intent
        Intent intent = new Intent(v.getContext(), DetailActivity.class);
        intent.putExtra("article", currentArticle);
        v.getContext().startActivity(intent);
    }
}
