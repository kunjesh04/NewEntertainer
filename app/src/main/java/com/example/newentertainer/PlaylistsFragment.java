package com.example.newentertainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;


public class PlaylistsFragment extends android.app.Fragment {

    String[] playlist_names = {"After hours", "Dawn FM", "Four", "Recovery", "The Eminem Show",
            "After hours", "Dawn FM", "Four", "Recovery", "The Eminem Show"};

    Integer[] playlist_images = {R.drawable.afterhours, R.drawable.dawnfm, R.drawable.four, R.drawable.recovery,
    R.drawable.theeminemshow, R.drawable.afterhours, R.drawable.dawnfm, R.drawable.four, R.drawable.recovery,
            R.drawable.theeminemshow, };

    String[] artists = {"The Weeknd","The Weeknd", "One Direction", "Eminem", "Eminem",
            "The Weeknd","The Weeknd", "One Direction", "Eminem", "Eminem"};

    String[] year = {"2020", "2022", "2014", "2010", "2002","2020", "2022", "2014", "2010", "2002" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlists, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView listView = getView().findViewById(R.id.playlistslist);
        MyCustomAdapter myCustomAdapter = new MyCustomAdapter((Activity) getContext(), playlist_names, playlist_images);
        listView.setAdapter(myCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailedActivity.class);
                intent.putExtra("name", playlist_names[i]);
                intent.putExtra("poster", playlist_images[i]);
                intent.putExtra("creator", artists[i]);
                intent.putExtra("year", year[i]);
                startActivity(intent);
            }
        });
    }
}