package com.example.instudy;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Cache {
    Context context;
    String username="",password="",name="";
    SharedPreferences sharedPreferences ;

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setUsername(String username) {
        sharedPreferences.edit().putString("username",username).commit();
    }
    public void setName(String name) {
        sharedPreferences.edit().putString("name",name).commit();
    }


    public void setPassword(String password) {
        sharedPreferences.edit().putString("password",password).commit();
    }

    public String getUsername() {
        return sharedPreferences.getString("username","");
    }

    public String getPassword() {
        return sharedPreferences.getString("password","");
    }

    public String getName() {
        if(sharedPreferences.getString("name","") == null) {
            return "Again";
        }
        return sharedPreferences.getString("name","");
    }

    public void clear(){
        sharedPreferences.edit().clear().commit();
    }
}
