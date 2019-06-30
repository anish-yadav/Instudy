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

public class Papers extends Fragment {



    private RecyclerView recyclerView;
    private PaperData data;
    private List<PaperData> paperDataList = new ArrayList<>();
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.papers_view, container, false);
        recyclerView = root.findViewById(R.id.papers_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(layoutManager);
        final SkeletonScreen skeletonScreen = Skeleton.bind(recyclerView)
                .adapter(new PapersAdapter(paperDataList))
                .load(R.layout.layout_default_item_skeleton)
                .show();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Papers");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                Log.i("Size" , Integer.toString(objects.size()));
                skeletonScreen.hide();
                if(objects.size()>0){
                    paperDataList.clear();
                    for (ParseObject object : objects){
                        data = new PaperData(object.getString("subject_name"),object.getString("subject_code"),object.getString("year"),new ResourceCollector().getImageResourceFromSubjectCode(object.getString("subject_code")),object.getString("download_url"),object.getString("preview_url"));
                        paperDataList.add(data);
                    }
                    PapersAdapter papersAdapter = new PapersAdapter(paperDataList);

                    recyclerView.setAdapter(papersAdapter);
                } else {
                    Log.i("info","No data");
                }
            }
        });
        return root;
    }

}
