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

public class NotesAdapter extends RecyclerView.Adapter<MyNotesViewHolder>  {
    List notesList;

    public NotesAdapter(List notesList) {this.notesList = notesList;}
    @NonNull
    @Override
    public MyNotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.notes_row,viewGroup,false);
        return new MyNotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyNotesViewHolder myNotesViewHolder, int i) {
        NotesData data =(NotesData) notesList.get(i);
        myNotesViewHolder.image.setImageResource(data.image);
        myNotesViewHolder.subject_name.setText(data.subject_name);
        myNotesViewHolder.subject_code.setText(data.subject_code);
        myNotesViewHolder.dwnldBtn.setTag(data.dwnldURL);
        myNotesViewHolder.prvBtn.setTag(data.prvUrl);
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }
}


class MyNotesViewHolder extends RecyclerView.ViewHolder{
    TextView subject_name,subject_code;
    ImageView image;
    Button prvBtn;
    Button dwnldBtn;
    public MyNotesViewHolder(@NonNull View itemView) {
        super(itemView);
        subject_code = itemView.findViewById(R.id.subject_code);
        subject_name = itemView.findViewById(R.id.subject_name);
        image = itemView.findViewById(R.id.subject_image);
        dwnldBtn = itemView.findViewById(R.id.download);
        prvBtn = itemView.findViewById(R.id.preview);
    }
}

class  NotesData {
    String subject_name;
    String subject_code;
    int image;
    String dwnldURL;
    String prvUrl;
    public NotesData(String subject_name , String subject_code,int image,String dwnldURL,String prvUrl){
        this.image = image;
        this.subject_code = subject_code;
        this.subject_name = subject_name;
        this.dwnldURL = dwnldURL;
        this.prvUrl = prvUrl;
    }
}
