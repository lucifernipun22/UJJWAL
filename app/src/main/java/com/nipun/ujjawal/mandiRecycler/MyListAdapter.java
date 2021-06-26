package com.nipun.ujjawal.mandiRecycler;


import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.ImageView;  
import android.widget.RelativeLayout;  
import android.widget.TextView;  
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.nipun.ujjawal.R;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private MyListData[] listdata;  
  
   // RecyclerView recyclerView;  
    public MyListAdapter(MyListData[] listdata) {  
        this.listdata = listdata;  
    }  
    @Override  
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {  
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());  
        View listItem= layoutInflater.inflate(R.layout.item_mandi, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);  
        return viewHolder;  
    }  
  
    @Override  
    public void onBindViewHolder(ViewHolder holder, int position) {  
        final MyListData myListData = listdata[position];  
        holder.textView1.setText(listdata[position].getName());
        holder.textView2.setText(listdata[position].getRate());
        holder.textView3.setText(listdata[position].getPrice());
        holder.textView4.setText(listdata[position].getMin());
        holder.textView5.setText(listdata[position].getKm());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View view) {  

            }  
        });  
    }  
  
  
    @Override  
    public int getItemCount() {  
        return listdata.length;  
    }  
  
    public static class ViewHolder extends RecyclerView.ViewHolder {  

        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public TextView textView4;
        public TextView textView5;
        public RelativeLayout relativeLayout;  
        public ViewHolder(View itemView) {  
            super(itemView);  

            this.textView1 = (TextView) itemView.findViewById(R.id.textView);
            this.textView2 = (TextView) itemView.findViewById(R.id.rate);
            this.textView3 = (TextView) itemView.findViewById(R.id.price);
            this.textView4 = (TextView) itemView.findViewById(R.id.maxmin);
            this.textView5 = (TextView) itemView.findViewById(R.id.km);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);  
        }  
    }  
}  