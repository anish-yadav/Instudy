package com.example.instudy;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.instudy.ui.main.SectionsPagerAdapter;

public class Resource extends AppCompatActivity {

    private DownloadManager dm;
    private long downloadId=-1L;

    public void screenMainSelection(View view){
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,mainSelection.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 10);

        }
        dm = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);

    }
    public void DownloadFile(View view) {
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdir();


        downloadId = dm.enqueue(new DownloadManager.Request(Uri.parse((String) view.getTag()))
                .setAllowedOverRoaming(false)
                .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "demo.pdf")
                .setTitle("Downloading"));
        Toast.makeText(this, "Download Started", Toast.LENGTH_SHORT).show();


    }

    public void Preview(View view ){
        String url = (String) view.getTag();
        Intent i = new Intent(this,Preview.class);
        i.putExtra("url",url);
        startActivity(i);
        finish();
    }
}