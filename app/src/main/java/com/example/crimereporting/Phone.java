package com.example.crimereporting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Phone extends AppCompatActivity {

    EditText f;
    Button g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        f=findViewById(R.id.txtnumber);
        g=findViewById(R.id.btn_call);

    g.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            String number=f.getText().toString();

            if(number.trim().isEmpty()){

                Toast.makeText(Phone.this,"Enter your number",Toast.LENGTH_SHORT).show();

            }

            else{

                intent.setData(Uri.parse("tel:"+number));


            }
            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

                Toast.makeText(Phone.this,"Permsiion  Granted",Toast.LENGTH_SHORT).show();
                requestPermison();
            }

            else {

                startActivity(intent);
            }

        }
    });


    }

    private void requestPermison(){
        ActivityCompat.requestPermissions(Phone.this,new String[]{Manifest.permission.CALL_PHONE},1);

    }
}
