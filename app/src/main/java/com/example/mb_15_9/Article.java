package com.example.mb_15_9;

import java.io.Serializable;

/**
 * Lớp đại diện cho một bài viết.
 * Implements Serializable để đóng gói qua Intent.
 */
public class Article implements Serializable {
    private String title;   // Tiêu đề bài viết
    private String content; // Nội dung bài viết
    private int imgCover;   // Resource ID ảnh bìa cục bộ (drawable)
    private int view;       // Số lượt xem (ban đầu = 0)

    public Article(String title, String content, int imgCover) {
        this.title = title;
        this.content = content;
        this.imgCover = imgCover;
        this.view = 0; // luôn khởi tạo = 0
    }

    public String getTitle()   { return title; }
    public String getContent() { return content; }
    public int getImgCover()   { return imgCover; }
    public int getView()       { return view; }

    public void setView(int view) { this.view = view; }

    /** Tăng lượt xem lên 1 */
    public void increaseView() { this.view++; }
}
