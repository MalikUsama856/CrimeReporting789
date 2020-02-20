package com.example.crimereporting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Complaint extends AppCompatActivity {


  TextView c,d,e,f,o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        c=findViewById(R.id.messagen);
        d=findViewById(R.id.Call);
        e=findViewById(R.id.reportcrime);
        f=findViewById(R.id.checknow);
        o=findViewById(R.id.questions);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Complaint.this,SMSA.class);
                startActivity(intent);
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Complaint.this,Phone.class);
                startActivity( intent);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Complaint.this,ReportNow.class);
                startActivity(intent);
            }
        });


        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Complaint.this,MySubmission.class);
                startActivity(intent);
            }
        });


       o.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Complaint.this,Question.class);
               startActivity(intent);
           }
       });








    }
}
