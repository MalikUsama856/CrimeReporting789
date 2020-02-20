package com.example.crimereporting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Question extends AppCompatActivity {
    Button b;
    EditText c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        b=findViewById(R.id.button9);
        c=findViewById(R.id.ed);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setText("");

            }
        });
    }
}
