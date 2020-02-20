package com.example.crimereporting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSA extends AppCompatActivity {

    EditText a,b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        a=findViewById(R.id.txt_mobileno);
        b=findViewById(R.id.txt_sms);


    }


    private void MyMessage() {

        String phonenumber = a.getText().toString().trim();
        String Message = b.getText().toString().trim();

        if (!a.getText().toString().equals(" ") || ! b.getText().toString().equals("")) {

            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(phonenumber, null, Message, null, null);

            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();

        }

        else{

            Toast.makeText(this,"Message or Phone Number Enter",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode){

            case 0:
     if(grantResults.length >=0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

      MyMessage();

     }


     else{

         Toast.makeText(this,"Plz you do not permision",Toast.LENGTH_SHORT).show();

            }

                break;
        }


    }

    public void btn_send(View view) {


        int permisioncheck= ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if(permisioncheck== PackageManager.PERMISSION_GRANTED){

            MyMessage();
        }
        else{

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0 );

        }

    }
}
