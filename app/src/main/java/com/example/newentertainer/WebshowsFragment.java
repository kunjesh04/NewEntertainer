package com.example.newentertainer;

import android.app.Activity;
import android.app.Fragment;
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


public class WebshowsFragment extends Fragment {

    String[] shows_names = {"How I Met Your Mother", "One Piece", "Fire Force", "Breaking Bad", "Dark",
            "How I Met Your Mother", "One Piece", "Fire Force", "Breaking Bad", "Dark"};

    Integer[] shows_images = {R.drawable.himym, R.drawable.onepiece, R.drawable.fireforce, R.drawable.breakingbad,
    R.drawable.darknetflix, R.drawable.himym, R.drawable.onepiece, R.drawable.fireforce, R.drawable.breakingbad,
            R.drawable.darknetflix};

    String[] directors = {"Pamela Fryman", "Eichiro Oda", "Yuki Yase", "Vince Gilligan", "Baran Odar",
            "Pamela Fryman", "Eichiro Oda", "Yuki Yase", "Vince Gilligan", "Baran Odar"};

    String[] year = {"2005", "1999", "2019", "2008", "2017","2005", "1999", "2019", "2008", "2017"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_webshows, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView listView = getView().findViewById(R.id.showslist);
        MyCustomAdapter myCustomAdapter = new MyCustomAdapter((Activity) getContext(), shows_names, shows_images);
        listView.setAdapter(myCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailedActivity.class);
                intent.putExtra("name", shows_names[i]);
                intent.putExtra("poster", shows_images[i]);
                intent.putExtra("creator", directors[i]);
                intent.putExtra("year", year[i]);
                startActivity(intent);
            }
        });
    }
}