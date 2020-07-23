package com.example.dicodingsubmissionandroidpemula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tv_title = findViewById(R.id.tv_title);
        TextView tv_detail = findViewById(R.id.tv_detail);
        ImageView iv_detail = findViewById(R.id.iv_detail);

        Intent intent = getIntent();

        tv_title.setText(intent.getStringExtra("title"));
        tv_detail.setText(intent.getStringExtra("description"));
        iv_detail.setImageResource(intent.getIntExtra("photo", 0));
    }
}