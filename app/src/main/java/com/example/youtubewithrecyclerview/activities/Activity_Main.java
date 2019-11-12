package com.example.youtubewithrecyclerview.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Adapter;

import com.example.youtubewithrecyclerview.R;
import com.example.youtubewithrecyclerview.adapter.AdapterVideo;
import com.example.youtubewithrecyclerview.model.Model;
import com.example.youtubewithrecyclerview.utlis.AllUrl;

import java.util.ArrayList;

public class Activity_Main extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model> modelArrayList;
    AdapterVideo adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        AllUrl allUrl = new AllUrl();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        modelArrayList = new ArrayList<>();

        Model model = new Model();
        model.setLink(allUrl.ANDROID_DEV_SUMMIT);
        model.setLink(allUrl.ANDROID_Q_BETA);
        model.setLink(allUrl.CLOUD_FUNCTION);
        model.setLink(allUrl.GOOGLE_PAY_PAYPAL);
        model.setLink(allUrl.HOWLCODE);
        model.setLink(allUrl.KOTLIN_EVERYWHERE);
        model.setLink(allUrl.LOCAL_HOME_SDK);

        modelArrayList.add(model);

        adapter = new AdapterVideo(modelArrayList,Activity_Main.this);
        recyclerView.setAdapter(adapter);
    }
}
