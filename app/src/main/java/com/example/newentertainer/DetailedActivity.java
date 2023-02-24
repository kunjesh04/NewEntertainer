package com.example.newentertainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {

    ImageView dposter;
    TextView dname, dcreator, relyear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        dposter = findViewById(R.id.dposter);
        dname = findViewById(R.id.dname);
        dcreator = findViewById(R.id.dcreator);
        relyear = findViewById(R.id.relyear);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Integer image = intent.getIntExtra("poster", R.drawable.afterhours);
        String director = intent.getStringExtra("creator");
        String year = intent.getStringExtra("year");

        dposter.setImageResource(image);
        dname.setText(name);
        dcreator.setText(director);
        relyear.setText(year);

    }
}