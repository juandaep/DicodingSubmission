package com.example.dicodingsubmissionandroidpemula;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;
    List<String> title_list = new ArrayList<>();
    List<String> desc_list = new ArrayList<>();
    ArrayList<Integer> photo = new ArrayList<>();
    AdapterItem adapterItem;

    private String title = "News App";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvList = findViewById(R.id.list_rv);
        title_list = Arrays.asList(getResources().getStringArray(R.array.title));
        desc_list = Arrays.asList(getResources().getStringArray(R.array.description));
        TypedArray typedArray = getResources().obtainTypedArray(R.array.photo);

        for (int i = 0; i < typedArray.length(); i++) {
            photo.add(i, typedArray.getResourceId(i, 0));
        }

        adapterItem = new AdapterItem(MainActivity.this, title_list, desc_list, photo);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.VERTICAL,
                false
        );

        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(adapterItem);

    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}