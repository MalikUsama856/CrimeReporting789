package com.example.crimereporting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.example.crimereporting.DPO.DPO_Dashboard;
import com.example.crimereporting.Moharrier.Moharrier_Dashboard;
import com.example.crimereporting.SHO.SHO_Dashboard;

public class Dashboard extends AppCompatActivity {
    TextView t1,t2,t3,t4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        t1=findViewById(R.id.comp);
        t2=findViewById(R.id.moha);
        t3=findViewById(R.id.shoo);
        t4=findViewById(R.id.dpoo);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Complaint.class);
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       Intent intent=new Intent(Dashboard.this, Moharrier_Dashboard.class);
       startActivity(intent);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this, SHO_Dashboard.class);
                startActivity(intent);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this, DPO_Dashboard.class);
                startActivity(intent);
            }
        });

    }



}
