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

public class BooksAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List bookList;


    public BooksAdapter(List bookList){
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.book_row,viewGroup,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        BookData data = (BookData) bookList.get(i);
        myViewHolder.author.setText(data.author);
        myViewHolder.book_name.setText(data.name);

        myViewHolder.book_image.setImageResource(data.image);

        myViewHolder.dwnldBtn.setTag(data.dwnldURL);
        myViewHolder.prvBtn.setTag(data.prvUrl);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


}


class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView book_image;
    TextView author;
    TextView book_name;
    Button prvBtn;
    Button dwnldBtn;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        book_image = itemView.findViewById(R.id.book_image);
        book_name = itemView.findViewById(R.id.book_name);
        author = itemView.findViewById(R.id.author);
        dwnldBtn = itemView.findViewById(R.id.download_book);
        prvBtn = itemView.findViewById(R.id.preview_book);
    }
}

class BookData {
    int image;
    String name;
    String author;
    String dwnldURL;
    String prvUrl;
    BookData(String name, String author,int image,String dwnldURL, String prvUrl){
        this.name = name;
        this.author = author;
        this.image = image;
        this.dwnldURL = dwnldURL;
        this.prvUrl = prvUrl;
    }
}
