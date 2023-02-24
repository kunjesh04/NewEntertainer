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


public class MoviesFragment extends android.app.Fragment {


    String[] movie_names = {"Captain America", "Guardians of the Galaxy", "Avengers : Infinity War"
            , "Spiderman : Far From Home", "Thor Ragnarok", "Captain America", "Guardians of the Galaxy",
            "Avengers : Infinity War", "Spiderman : Far From Home", "Thor Ragnarok"};

    Integer[] movie_posters = {R.drawable.capame,R.drawable.gotg, R.drawable.infinitywar,
            R.drawable.spiderman, R.drawable.thor, R.drawable.capame,R.drawable.gotg, R.drawable.infinitywar,
            R.drawable.spiderman, R.drawable.thor};

    String[] directors = {"Joe Johnston", "James Gunn", "Anthony Russo", "Jon Watts", "Taika Waititi",
            "Joe Johnston", "James Gunn", "Anthony Russo", "Jon Watts", "Taika Waititi"};

    String[] year = {"2011", "2014", "2018", "2019", "2017","2011", "2014", "2018", "2019", "2017"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView listView = getView().findViewById(R.id.movieslist);
        MyCustomAdapter myCustomAdapter= new MyCustomAdapter((Activity) getContext(), movie_names, movie_posters);

        listView.setAdapter(myCustomAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailedActivity.class);
                intent.putExtra("name", movie_names[i]);
                intent.putExtra("poster", movie_posters[i]);
                intent.putExtra("creator", directors[i]);
                intent.putExtra("year", year[i]);
                startActivity(intent);
            }
        });
    }
}

















