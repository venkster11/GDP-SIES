package com.venkat.gdp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {


    private List<VideoListModel> videoListModels;

    public HomeAdapter(List<VideoListModel>videoListModels){
        this.videoListModels = videoListModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.thumbnail.setImageResource(videoListModels.get(position).getThumbnail());
        holder.title.setText(videoListModels.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return videoListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView thumbnail;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnail_img);
            title = itemView.findViewById(R.id.title_home);
        }
    }

}
