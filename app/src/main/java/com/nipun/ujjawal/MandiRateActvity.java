package com.nipun.ujjawal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nipun.ujjawal.mandiRecycler.MyListAdapter;
import com.nipun.ujjawal.mandiRecycler.MyListData;

import de.hdodenhof.circleimageview.CircleImageView;

public class MandiRateActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandi_rate);

        TextView textView ;
        ImageView image;
        image = findViewById(R.id.img);
        textView = findViewById(R.id.cropName);
        if(getIntent()!=null){
            String cropName = getIntent().getStringExtra("string");
            String cropNameim = getIntent().getStringExtra("img");
            textView.setText(cropName);
            Glide.with(image).load(cropNameim).into(image);
            Log.d("get",cropNameim+"");
        }

        MyListData[] myListData = new MyListData[] {
                new MyListData(R.string.fm1,R.string.d1,R.string.r1,R.string.m1,R.string.k1),
                new MyListData(R.string.fm2,R.string.d2,R.string.r2,R.string.m2,R.string.k2),
                new MyListData(R.string.fm3,R.string.d3,R.string.r3,R.string.m3,R.string.k3),
                new MyListData(R.string.fm4,R.string.d4,R.string.r4,R.string.m4,R.string.k4),
                new MyListData(R.string.fm5,R.string.d5,R.string.r5,R.string.m5,R.string.k5),
                new MyListData(R.string.fm6,R.string.d6,R.string.r6,R.string.m6,R.string.k6),
                new MyListData(R.string.fm7,R.string.d7,R.string.r7,R.string.m7,R.string.k7),
                new MyListData(R.string.fm8,R.string.d8,R.string.r8,R.string.m8,R.string.k8),


        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}