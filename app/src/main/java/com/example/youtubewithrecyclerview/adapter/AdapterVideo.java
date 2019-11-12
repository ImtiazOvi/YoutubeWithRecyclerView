package com.example.youtubewithrecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubewithrecyclerview.R;
import com.example.youtubewithrecyclerview.activities.Activity_Another;
import com.example.youtubewithrecyclerview.model.Model;

import java.util.ArrayList;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.VideoViewHolder> {
    ArrayList<Model> modelArrayList;
    Context context;

    public AdapterVideo(ArrayList<Model> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_view_design,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        final Model currentModel = modelArrayList.get(position);
        holder.webView.loadUrl(currentModel.getLink());
        holder.buttonFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Activity_Another.class);
                intent.putExtra("link",currentModel.getLink());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        WebView webView;
        Button buttonFullScreen;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            webView = itemView.findViewById(R.id.webView);
            buttonFullScreen = itemView.findViewById(R.id.btnFullScreen);
            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }
}
