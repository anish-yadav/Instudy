package com.example.instudy.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class Notes extends Fragment {

    private RecyclerView recyclerView;
    private List<NotesData> notesDataList = new ArrayList<>();
    private  NotesData data;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.notes_view, container, false);
        recyclerView = root.findViewById(R.id.notes_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(layoutManager);
        final SkeletonScreen skeletonScreen = Skeleton.bind(recyclerView)
                .adapter(new NotesAdapter(notesDataList))
                .load(R.layout.layout_default_item_skeleton)
                .show();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Notes");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                skeletonScreen.hide();
                if(objects.size()>0){
                    notesDataList.clear();
                    for (ParseObject object : objects){
                        data = new NotesData(object.getString("subject_name"),object.getString("subject_code"),new ResourceCollector().getImageResourceFromSubjectCode(object.getString("subject_code")),object.getString("download_url"),object.getString("preview_url"));
                        notesDataList.add(data);
                    }
                    NotesAdapter notesAdapter = new NotesAdapter(notesDataList);

                    recyclerView.setAdapter(notesAdapter);
                } else {
                    Log.i("info","No data");
                }
            }
        });

        return root;
    }



}
