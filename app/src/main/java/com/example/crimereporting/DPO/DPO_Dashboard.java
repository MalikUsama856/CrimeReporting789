package com.example.crimereporting.DPO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.crimereporting.R;

import java.util.ArrayList;
import java.util.List;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class DPO_Dashboard extends AppCompatActivity {
    private RecyclerView recylerr;
    FlipperLayout flipperLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpo__dashboard);

        flipperLayout=findViewById(R.id.flipper);

        int imagesDrwable[]={R.drawable.j,R.drawable.cd,R.drawable.e,R.drawable.mn,R.drawable.jl};

        for(int i=0;i<imagesDrwable.length;i++){
            FlipperView flipperView=new FlipperView(getBaseContext());
            flipperView.setImageDrawable(imagesDrwable[i]);
            flipperLayout.addFlipperView(flipperView);
        }

        recylerr=findViewById(R.id.recyler);

        List<DPO_Class> DpoClassList=new ArrayList<>();
        DpoClassList.add(new DPO_Class(R.drawable.survey,"Received Compalint"));
        DpoClassList.add(new DPO_Class(R.drawable.ma,"Register User"));

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recylerr.addItemDecoration(dividerItemDecoration);

        DPO_Adapter dpoAdapter=new DPO_Adapter(DpoClassList);
        recylerr.setAdapter(dpoAdapter);
        dpoAdapter.notifyDataSetChanged();



    }
}
