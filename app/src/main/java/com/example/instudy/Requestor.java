package com.example.instudy;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Requestor {
    Context context;
    String username,password;
    RequestQueue requestQueue;
    String url = "http://136.233.14.3:8282/CampusPortalSOA/login/";
    boolean isAllowed = true;
    Requestor(Context context){this.context = context;}

   public void setData (String username,String password){
        this.username = username;
        this.password = password;
   }

    public boolean startRequest(final Intent i){
        Map<String,String> myData = new HashMap<>();
        myData.put("username",username);
        myData.put("password",password);
        myData.put("MemberType","S");
       JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(myData), new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
               Log.i("info", "response coming");
               try {
                   Log.i("result", response.getString("status"));
                   if(response.getString("status").equalsIgnoreCase("error") ){
                       Log.i("info" ,"error occurred");
                       Toast.makeText(context, "Enter a valid credential or skip", Toast.LENGTH_SHORT).show();
                   }else {
                       Cache cache = new Cache();
                       cache.setSharedPreferences(PreferenceManager.getDefaultSharedPreferences(context));
                       cache.setName(response.getString("name"));
                       context.startActivity(i);

                   }


               } catch (JSONException e) {
                   e.printStackTrace();
               }
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }
       });


        requestQueue = Volley.newRequestQueue(context);
      requestQueue.add(jsonObjectRequest);

      return isAllowed;
    }
}
