package com.example.instudy;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AttendenceAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List attendenceDataList;
    public AttendenceAdapter(List attendenceDataList){this.attendenceDataList = attendenceDataList;}

    public void colorTextView(TextView textView, String colorHexTop,String colorHexBottom){
        Shader textShader = new LinearGradient(0, 0, 0, textView.getTextSize(),
                new int[]{
                        Color.parseColor(colorHexTop),
                        Color.parseColor(colorHexBottom),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.attendence_row,viewGroup,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
     AttendenceData data;
     data = (AttendenceData) attendenceDataList.get(i);
     myViewHolder.name.setText(data.name);
     myViewHolder.absent.setText("0"+data.absent);
        colorTextView(myViewHolder.leaves_left,"#FF4F68","#FF8E8E");
     myViewHolder.percentage.setText(Integer.toString(data.percentage)+"%");
     if(data.percentage < 75) {
         colorTextView(myViewHolder.percentage,"#FF0000","#FF8E8E");
     } else {
         colorTextView(myViewHolder.percentage,"#006400","#008000");
     }
     myViewHolder.leaves_left.setText("0"+data.leaves_left);
    }

    @Override
    public int getItemCount() {
        return attendenceDataList.size();
    }
}


class MyViewHolder extends RecyclerView.ViewHolder {
    TextView absent,leaves_left,percentage,name;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.subject_name);
        absent = itemView.findViewById(R.id.absent);
        leaves_left = itemView.findViewById(R.id.leaves_left);
        percentage = itemView.findViewById(R.id.percentage);
    }
}