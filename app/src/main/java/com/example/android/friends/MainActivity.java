package com.example.android.friends;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<String> friendsName = new ArrayList<>();
        friendsName.add("Shubhankar Amitabh");
        friendsName.add("Snigdh Sinha");
        friendsName.add("Sunny Singh");
        friendsName.add("Shubham Pathak");
        friendsName.add("Anubhav Jangra");
        friendsName.add("Sharique Nomani");
        friendsName.add("Shubham Choukshy");
        friendsName.add("Deepanjan Datta");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvfriends);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, friendsName);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + (position+1), Toast.LENGTH_SHORT).show();
    }
}