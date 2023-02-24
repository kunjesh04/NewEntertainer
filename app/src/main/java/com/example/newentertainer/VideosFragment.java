package com.example.newentertainer;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;


public class VideosFragment extends android.app.Fragment {

    String[] vids_names = {"Stand Up", "Educational", "Vlogs", "Reviews", "Gaming","Stand Up",
            "Educational", "Vlogs", "Reviews", "Gaming" };

    Integer[] vids_posters = {R.drawable.standup, R.drawable.educational, R.drawable.vlogs, R.drawable.reviews,
    R.drawable.gaming,R.drawable.standup, R.drawable.educational, R.drawable.vlogs, R.drawable.reviews,
            R.drawable.gaming};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos, container, false);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView listView = getView().findViewById(R.id.vidslist);
        MyCustomAdapter myCustomAdapter=new MyCustomAdapter((Activity) getContext(), vids_names, vids_posters);
        listView.setAdapter(myCustomAdapter);
    }
}