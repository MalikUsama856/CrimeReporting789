package com.example.crimereporting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign extends AppCompatActivity {

    EditText m,n,c;

    Button r;

    ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);


        m=findViewById(R.id.email);
        n=findViewById(R.id.pass);
        c=findViewById(R.id.cnfpass);

        r=findViewById(R.id.refister);

        progressBar=findViewById(R.id.progrebar);

        firebaseAuth=FirebaseAuth.getInstance();


        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=m.getText().toString().trim();
                String password=n.getText().toString().trim();
                String confirmPassord=c.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Sign.this,"Plz Enter Email",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Sign.this,"Plz Enter Confirm password",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(confirmPassord)){
                    Toast.makeText(Sign.this,"Plz Enter Confirm password",Toast.LENGTH_SHORT).show();

                }

                if(password.length()<6){
                    Toast.makeText(Sign.this,"Password are to short",Toast.LENGTH_SHORT).show();

                }

                progressBar.setVisibility(View.VISIBLE);

                if(password.equals(confirmPassord)){


                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Sign.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information

                                 startActivity(new Intent(Sign.this,MainActivity.class));
                                 Toast.makeText(Sign.this,"Registration succeful",Toast.LENGTH_SHORT).show();

                                    }

                                    else {

                                        Toast.makeText(Sign.this,"Registration succeful",Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });



                }




            }
        });






    }
}
