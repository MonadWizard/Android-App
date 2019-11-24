package com.example.recycleviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);

        List<MOdelClass> mOdelClassList = new ArrayList<>();
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user One","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 2","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 3","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 4","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 5","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 6","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 7","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 8","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 9","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 10","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 11","Hellow this is body one"));
        mOdelClassList.add(new MOdelClass(R.drawable.ic_launcher_background,"user 12","Hellow this is body one"));



        Adapter adapter = new Adapter(mOdelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}

