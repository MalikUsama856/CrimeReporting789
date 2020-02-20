package com.example.crimereporting.Moharrier;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crimereporting.Dashboard;
import com.example.crimereporting.MySubmission;
import com.example.crimereporting.Question;
import com.example.crimereporting.R;
import com.example.crimereporting.ReportNow;
import com.example.crimereporting.Sign;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    List<ModelClass>modelClassList;

    public RecyclerViewAdapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public  MyViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder  holder, int position) {

        int resource=modelClassList.get(position).getImageresourceid();
        String title=modelClassList.get(position).getTitle();
        String body=modelClassList.get(position).getBody();

        holder.setData(resource,title,body);


    }

    @Override
    public int getItemCount() {
        return modelClassList.size();

    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

     private ImageView imageView;
      private TextView title,Body;
        private final Context context;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            context = itemView.getContext();

            imageView=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.textView);
            Body=itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(this);

        }
        private void setData(int resource,String titletext,String body){
            imageView.setImageResource(resource);
            title.setText(titletext );
            Body.setText(body);

        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();

            if(position==0){

                Intent intent = new Intent(v.getContext(), MySubmission.class);
                v.getContext().startActivity(intent);
            }
          else if(position==1){

                Intent intent = new Intent(v.getContext(), Question.class);
                v.getContext().startActivity(intent);
            }
            else if(position==2){

                Intent intent = new Intent(v.getContext(), Officers.class);
                v.getContext().startActivity(intent);
            }


            else if(position==3){

                Intent intent = new Intent(v.getContext(), Sign.class);
                v.getContext().startActivity(intent);
            }


            else{

                Intent intent = new Intent(v.getContext(), Dashboard.class);
                v.getContext().startActivity(intent);
            }
        }
    }
}
