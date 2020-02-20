package com.example.crimereporting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MySubmission extends AppCompatActivity {

    TextView z,x,c,v,b,n;

    DatabaseReference getDataReference;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_submission);

        z=findViewById(R.id.a);
        x=findViewById(R.id.b);
        c=findViewById(R.id.c);
        v=findViewById(R.id.d);
        b=findViewById(R.id.e);
        n=findViewById(R.id.f);

        getData();


    }

    private void getData() {

        auth=FirebaseAuth.getInstance();
        String userId=auth.getCurrentUser().getUid();

        getDataReference= FirebaseDatabase.getInstance().getReference().child("Users").child("9GM2tXnn7VcIJso9DpZf6T7uUyL2");

        getDataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    String namee=dataSnapshot.child("User City").getValue().toString();
                    String crimetypee=dataSnapshot.child("UserCrime Type").getValue().toString();
                    String countrye=dataSnapshot.child("User Country").getValue().toString();
                    String citye=dataSnapshot.child("User City").getValue().toString();
                    String descriptione=dataSnapshot.child("User Decription").getValue().toString();
                    String reasone=dataSnapshot.child("User Reason").getValue().toString();

                    z.setText(namee);
                    x.setText(crimetypee);
                    c.setText(countrye);
                    v.setText(citye);
                    b.setText(descriptione);
                    n.setText(reasone);
                }
                else
                {
                    Toast.makeText(MySubmission.this, "Data not Exist....", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
