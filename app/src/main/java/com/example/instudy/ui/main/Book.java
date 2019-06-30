package com.example.instudy.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.example.instudy.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Book extends Fragment {


    private RecyclerView recyclerView;
    private List<BookData> bookData = new ArrayList<>();
    private BookData data;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.book_view, container, false);
        recyclerView = root.findViewById(R.id.book_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        BooksAdapter booksAdapter = new BooksAdapter(bookData);
        recyclerView.setLayoutManager(layoutManager);
        final SkeletonScreen skeletonScreen = Skeleton.bind(recyclerView)
                .adapter(new BooksAdapter(bookData))
                .load(R.layout.layout_default_item_skeleton)
                .show();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Books");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(objects.size()>0){
                    bookData.clear();
                    for(ParseObject object : objects) {
                        data = new BookData(object.getString("book_name"),object.getString("author"),new ResourceCollector().getBookResourceFromSubjectCode(object.getString("subject_code")),object.getString("download_url"),object.getString("preview_url"));
                        bookData.add(data);
                    }
                    BooksAdapter adapter = new BooksAdapter(bookData);


                    recyclerView.setAdapter(adapter);
                }
            }
        });
        return root;
    }

}
