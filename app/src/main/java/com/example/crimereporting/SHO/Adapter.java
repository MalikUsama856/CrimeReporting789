package com.example.crimereporting.SHO;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crimereporting.Dashboard;
import com.example.crimereporting.MySubmission;
import com.example.crimereporting.R;
import com.example.crimereporting.Sign;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private List<SHO_Class> ShoClassList;

    public Adapter(List<SHO_Class> shoClassList) {
        ShoClassList = shoClassList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        int resource=ShoClassList.get(position).getImageresourc();
        String titlet=ShoClassList.get(position).getTitl();
        String bodt=ShoClassList.get(position).getBod();

        holder.setData(resource,titlet,bodt);


    }

    @Override
    public int getItemCount() {
        return ShoClassList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

       private ImageView img;
       private TextView txt,bod;
        private final Context context;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            img=itemView.findViewById(R.id.imageView2);
            txt=itemView.findViewById(R.id.titl);
            bod=itemView.findViewById(R.id.textView4);

            itemView.setOnClickListener(this);
        }
        private  void setData(int resources,String titl,String bodyt){

            img.setImageResource(resources);
            txt.setText(titl);
            bod.setText(bodyt);



        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();

            if(position==0){

                Intent intent = new Intent(v.getContext(), MySubmission.class);
                v.getContext().startActivity(intent);
            }
            else if(position==1){

                Intent intent = new Intent(v.getContext(), Sign.class);
                v.getContext().startActivity(intent);
            }
            else if(position==2){

                Intent intent = new Intent(v.getContext(), Record.class);
                v.getContext().startActivity(intent);
            }
            else{

                Intent intent = new Intent(v.getContext(), Dashboard.class);
                v.getContext().startActivity(intent);
            }


        }
    }
}
