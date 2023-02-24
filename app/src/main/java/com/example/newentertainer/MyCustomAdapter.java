package com.example.newentertainer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.newentertainer.R;

public class MyCustomAdapter extends ArrayAdapter {
    Activity context;
    String[] name;
    Integer[] images;

    public MyCustomAdapter(@NonNull Activity context,String[] name, Integer[] images) {
        super(context, R.layout.mycustomlayout, name);
        this.context = context;
        this.name = name;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mycustomlayout, null, true);

        TextView label = rowView.findViewById(R.id.textView);
        ImageView image = rowView.findViewById(R.id.imageView);

        label.setText(name[position]);
        image.setImageResource(images[position]);


        return rowView;
    }
}
