package com.example.instudy;


import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
  SharedPreferences sharedPreferences;
  private EditText username;
  private EditText password;
  boolean isAllowed = false;
  Cache cache ;

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        finish();
    }

    public void isValid(final String username, final String password){

         Requestor requestor = new Requestor(this);
         requestor.setData(username,password);
         this.isAllowed = requestor.startRequest(new Intent(this,mainSelection.class));

  }

public void skip(View view){
        Intent i = new Intent(this, mainSelection.class);
        startActivity(i);
        finish();
}


  public void login(View view) {


      String registration_no = username.getText().toString().trim();
      String pswrd =  password.getText().toString().trim();
      if (registration_no.length() > 0 && pswrd.length() > 0 ){
          cache.setUsername(registration_no);
          cache.setPassword(pswrd);
          isValid( registration_no,pswrd);

          Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
          if (Build.VERSION.SDK_INT >= 26) {
              vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
          }else {
              vibrator.vibrate(200);
          }

      }



  }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //assign the layout to variables
         this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
         username = (EditText) findViewById(R.id.registration_no);
         password = (EditText) findViewById(R.id.password);

          sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
         //Checking if there is a user who hasnt logged out
            cache = new Cache();
            cache.setSharedPreferences(sharedPreferences);
           if(cache.getUsername().length()>0   && cache.getPassword().length()>0) {

             Log.i("info","data was storesd");
              username.setText(cache.getUsername());
              password.setText(cache.getPassword());
            isValid(cache.getUsername(),cache.getPassword());
      }
    }
}
