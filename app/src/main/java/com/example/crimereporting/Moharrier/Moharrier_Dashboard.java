package com.example.crimereporting.Moharrier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.example.crimereporting.R;

import java.util.ArrayList;
import java.util.List;

public class Moharrier_Dashboard extends AppCompatActivity {

    private RecyclerView recyclerView;

    RecyclerViewAdapter recyclerViewAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moharrier__dashboard);



        recyclerView=findViewById(R.id.recylerview);

        List<ModelClass> modelClasses=new ArrayList<>();
        modelClasses.add(new ModelClass(R.drawable.survey,"Recived Compalint","Complain Submit"));
        modelClasses.add(new ModelClass(R.drawable.team,"Asked Question","Ask Question"));
        modelClasses.add(new ModelClass(R.drawable.hammer,"Officers","Officers"));
        modelClasses.add(new ModelClass(R.drawable.ma,"Register user","Register user"));

        RecyclerViewAdapter adapter=new RecyclerViewAdapter(modelClasses);

        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapter.notifyDataSetChanged();








    }
}
