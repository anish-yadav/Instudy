package com.example.instudy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;

public class mainSelection extends AppCompatActivity {
    private TextView name;
    private Cache cache;
    private  SharedPreferences sharedPreferences;
    public void attendenceView(View view){
        Intent i = new Intent(this,AttendenceView.class);
        startActivity(i);
        finish();
    }

    public void resourceView(View view){
        Intent i  =  new Intent(this,Resource.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        finish();
    }
    public void Logout(View view ){

        cache.clear();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.parse_application_id))
                .clientKey(getString(R.string.parse_client_key))
                .server(getString(R.string.parse_server_url))
                .build());
           sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            cache = new Cache();
            cache.setSharedPreferences(sharedPreferences);
           name =  (TextView) findViewById(R.id.welcome_name);
           name.setText("Hello "+cache.getName().split(" ")[0].toLowerCase());
    }
}
