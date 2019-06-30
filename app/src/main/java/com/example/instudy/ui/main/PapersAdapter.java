package com.example.instudy.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instudy.R;

import java.util.List;

public class PapersAdapter extends RecyclerView.Adapter<MyPaperHolder> {
    List paperList;

    public PapersAdapter(List paperList){
        this.paperList = paperList;
    }

    @NonNull
    @Override
    public MyPaperHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.papers_row,viewGroup,false);

        return new MyPaperHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPaperHolder myPaperHolder, int i) {
        PaperData data = (PaperData) paperList.get(i);
        myPaperHolder.subject_code.setText(data.subject_code);
        myPaperHolder.year.setText(data.year);
        myPaperHolder.name.setText(data.name);
        myPaperHolder.image.setImageResource(data.image);
        myPaperHolder.dwnldBtn.setTag(data.dwnldURL);
        myPaperHolder.prvBtn.setTag(data.prvUrl);
    }


    @Override
    public int getItemCount() {
        return paperList.size();
    }
}


class MyPaperHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView year;
    TextView name;
    TextView subject_code;
    Button prvBtn;
    Button dwnldBtn;
    public MyPaperHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.subject_image);
        name = itemView.findViewById(R.id.subject_name);
        year = itemView.findViewById(R.id.year);
        subject_code = itemView.findViewById(R.id.subject_code);
        dwnldBtn = itemView.findViewById(R.id.download_paper);
        prvBtn = itemView.findViewById(R.id.preview_paper);
    }
}

class PaperData {
    int image;
    String name;
    String year;
    String subject_code;
    String dwnldURL;
    String prvUrl;
    PaperData(String name, String subject_code,String year, int image,String dwnldURL ,String prvUrl){
        this.name = name;
        this.year = year;
        this.image = image;
        this.subject_code = subject_code;
        this.dwnldURL = dwnldURL;
        this.prvUrl = prvUrl;
    }
}
