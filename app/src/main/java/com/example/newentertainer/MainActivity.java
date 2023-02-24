package com.example.newentertainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bmv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(new MoviesFragment());

        bmv = findViewById(R.id.bottnav);
        bmv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.movies:
                        showFragment(new MoviesFragment());
                        break;
                    case R.id.playlists:
                        showFragment(new PlaylistsFragment());
                        break;
                    case R.id.videos:
                        showFragment(new VideosFragment());
                        break;
                    case R.id.shows:
                        showFragment(new WebshowsFragment());
                        break;
                }

                return true;
            }
        });
    }
    private void showFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.framelayout,fragment);
        ft.commit();

    }
}

