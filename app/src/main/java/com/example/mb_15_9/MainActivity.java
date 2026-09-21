package com.example.mb_15_9;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Article> articleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Thêm bài viết mẫu
        articleList.add(new Article(
                "Khám phá Hà Nội",
                "Hà Nội – thủ đô ngàn năm văn hiến với những con phố cổ, hồ Hoàn Kiếm lung linh và ẩm thực đường phố phong phú không nơi nào sánh được.",
                R.drawable.img_cover1
        ));
        articleList.add(new Article(
                "Du lịch Đà Nẵng",
                "Đà Nẵng sở hữu những bãi biển xanh mướt, cầu Rồng nổi tiếng và núi Bà Nà Hills huyền ảo trong mây – điểm đến lý tưởng cho mọi du khách.",
                R.drawable.img_cover2
        ));
        articleList.add(new Article(
                "Sài Gòn không ngủ",
                "TP.HCM – thành phố năng động nhất Việt Nam, nơi nhịp sống sôi động 24/7, ẩm thực đa dạng và những tòa nhà hiện đại vươn cao giữa trời.",
                R.drawable.img_cover3
        ));

        // Hiển thị RecyclerView ngay khi mở app
        recyclerView = findViewById(R.id.recyclerView);
        MyAdapter myAdapter = new MyAdapter(this, articleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}