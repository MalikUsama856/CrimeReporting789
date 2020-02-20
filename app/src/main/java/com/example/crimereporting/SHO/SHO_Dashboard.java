package com.example.crimereporting.SHO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.crimereporting.R;

import java.util.ArrayList;
import java.util.List;

public class SHO_Dashboard extends AppCompatActivity {

    private RecyclerView  recyler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sho__dashboard);

        recyler=findViewById(R.id.recylervie);

        List<SHO_Class> ShoClassList=new ArrayList<>();
        ShoClassList.add(new SHO_Class(R.drawable.survey,"Received Complaint","Complaint Submit"));
        ShoClassList.add(new SHO_Class(R.drawable.ma,"Register User","Register User"));
        ShoClassList.add(new SHO_Class(R.drawable.document,"Record Statistices","Record of Compalint"));

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyler.addItemDecoration(dividerItemDecoration);



        Adapter adapter=new Adapter(ShoClassList);
        recyler.setAdapter(adapter);



    }
}
