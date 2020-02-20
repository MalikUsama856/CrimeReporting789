package com.example.crimereporting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ReportNow extends AppCompatActivity {
    EditText name,crimetype,country,city,description,reason;
    Button btnsave;

    DatabaseReference upload;

    FirebaseAuth mAuth;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_now);

        name=findViewById(R.id.Name);
        crimetype=findViewById(R.id.crimetype);
        country=findViewById(R.id.Country);
        city=findViewById(R.id.city);
        description=findViewById(R.id.Desc);
        reason=findViewById(R.id.Reason);
        btnsave=findViewById(R.id.rep);

        mAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDataToFirebaseDatabase();
            }
        });


    }

    private void SaveDataToFirebaseDatabase() {

        String  ename,ecrimetype,ecountry,ecity,edecriptin,ereason;

        ename=name.getText().toString();
        ecrimetype=crimetype.getText().toString();
        ecountry=country.getText().toString();
        ecity=city.getText().toString();
        edecriptin=description.getText().toString();
        ereason=reason.getText().toString();

        if(TextUtils.isEmpty(ename)&& TextUtils.isEmpty(ecrimetype) && TextUtils.isEmpty(ecountry)
        && TextUtils.isEmpty(ecity)&& TextUtils.isEmpty(edecriptin)&&TextUtils.isEmpty(ereason)){


            name.setError("Please Input of your name");
            crimetype.setError("Please Input of your crime type");
            country.setError("Please Input of your country");
            city.setError("Please Input of your city");
            description.setError("Please Input of your Decription");
            reason.setError("Please Input of  your reason");
        }
        else if(TextUtils.isEmpty(ename)){
            name.setError("Please Input of your name  ");
        }
        else if(TextUtils.isEmpty(ecrimetype)){
            name.setError("Please Input of your Crimetype ");
        }
        else if(TextUtils.isEmpty(ecountry)){
            name.setError("Please Input of your country ");
        }
        else if(TextUtils.isEmpty(ecity)){
            name.setError("Please Input of your city  ");
        }
        else if(TextUtils.isEmpty(edecriptin)){
            name.setError("Please Input of your name description  ");
        }
        else if(TextUtils.isEmpty(ereason)){
            name.setError("Please Input of your reason crime");
        }
        else{
           //save from firebase
            String userUniqueId=mAuth.getCurrentUser().getUid();

           upload=FirebaseDatabase.getInstance().getReference().child("Users").child(userUniqueId);
         //send data from firebase

            HashMap data=new HashMap();
            data.put("User Name",ename);
            data.put("UserCrime Type",ecrimetype);
            data.put("User Country",ecountry);
            data.put("User City",ecity);
            data.put("User Decription",edecriptin);
            data.put("User Reason",ereason);

            progressDialog.setTitle("Saving Data");
            progressDialog.setMessage("Please Wait....");
            progressDialog.show();

            upload.updateChildren(data).addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    progressDialog.dismiss();

                    if (task.isSuccessful())
                    {

                        Toast.makeText(ReportNow.this, "Data Upload Successfully...", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(ReportNow.this,Complaint.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(ReportNow.this, "Data Upload Failed...", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(ReportNow.this,Dashboard.class);
                        startActivity(intent);
                    }

                }
            });



        }

        }

        }




