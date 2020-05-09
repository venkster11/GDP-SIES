package com.venkat.gdp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment,container,false);
        recyclerView = view.findViewById(R.id.home_recycler);

        List<VideoListModel> videoListModels = new ArrayList<>();

        videoListModels.add(new VideoListModel(R.drawable.thumbnail1,"Video title pewdiepie bad designs"));
        videoListModels.add(new VideoListModel(R.drawable.thubnail2,"Video title Wion gravitas"));
        videoListModels.add(new VideoListModel(R.drawable.thumnail11,"Video title 60 min Australia fatal flaes"));
        videoListModels.add(new VideoListModel(R.drawable.tumnail3,"saiman says snacks review"));
        videoListModels.add(new VideoListModel(R.drawable.thumnail4,"Video title MKBHD air pods"));

        HomeAdapter adapter = new HomeAdapter(videoListModels);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}
