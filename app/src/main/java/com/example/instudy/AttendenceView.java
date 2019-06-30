package com.example.instudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AttendenceView extends AppCompatActivity {

    private List<AttendenceData> attendenceDataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AttendenceData data;

    public void screenMainSelection(View view){
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this,mainSelection.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_view);
        recyclerView  = (RecyclerView) findViewById(R.id.recycle_view_attendence);
        AttendenceAdapter adapter = new AttendenceAdapter(attendenceDataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        prepareData();
    }

    private void prepareData(){
        data = new AttendenceData("ICP",2,5,48);
        attendenceDataList.add(data);
        data = new AttendenceData("DSA",4,0,100);
        attendenceDataList.add(data);
        data = new AttendenceData("CTC",1,5,40);
        attendenceDataList.add(data);
        data = new AttendenceData("UPEM",7,8,75);
        attendenceDataList.add(data);
        data = new AttendenceData("IGT",1,8,85);
        attendenceDataList.add(data);
        data = new AttendenceData("DM",0,4,72);
        attendenceDataList.add(data);
    }
}
