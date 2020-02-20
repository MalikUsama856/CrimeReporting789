package com.example.crimereporting.SHO;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.crimereporting.R;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class Record extends AppCompatActivity {
    FlipperLayout flipperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        flipperLayout=findViewById(R.id.flippe);

        int imagesDrwable[]={R.drawable.j,R.drawable.cd,R.drawable.e,R.drawable.mn,R.drawable.jl};

        for(int i=0;i<imagesDrwable.length;i++){
            FlipperView flipperView=new FlipperView(getBaseContext());
            flipperView.setImageDrawable(imagesDrwable[i]);
            flipperLayout.addFlipperView(flipperView);
        }

    }
}
