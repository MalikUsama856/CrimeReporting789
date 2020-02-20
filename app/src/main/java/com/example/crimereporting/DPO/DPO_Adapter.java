package com.example.crimereporting.DPO;

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

public class DPO_Adapter extends RecyclerView.Adapter<DPO_Adapter.viewHolder> {

    private List<DPO_Class> DpoClassList;

    public DPO_Adapter(List<DPO_Class> dpoClassList) {
        DpoClassList = dpoClassList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.colume_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        int resource=DpoClassList.get(position).getImageres();
        String txt=DpoClassList.get(position).getTit();

        holder.setData(resource,txt);
    }

    @Override
    public int getItemCount() {
        return DpoClassList.size();
    }

    public class  viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView image;
        private TextView text;
        private final Context context;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            image=itemView.findViewById(R.id.malikk);
            text=itemView.findViewById(R.id.usamaa);

            itemView.setOnClickListener(this);
        }
        private void setData(int resource,String txt){
            image.setImageResource(resource);
            text.setText(txt);

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
            else{

                Intent intent = new Intent(v.getContext(), Dashboard.class);
                v.getContext().startActivity(intent);
            }

        }
    }

}
