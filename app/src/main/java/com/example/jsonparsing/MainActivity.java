package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            JSONObject obj=new JSONObject(jsonload());
            JSONArray marry=obj.getJSONArray("users");
            for (int i=0; i<marry.length();i++){
                JSONObject jinside=marry.getJSONObject(i);
                String id=jinside.getString("id");
                String name=jinside.getString("name");
                Toast.makeText(getApplicationContext(),""+id,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),""+name,Toast.LENGTH_SHORT).show();
            }

        }catch (JSONException e){
            e.printStackTrace();
        }


    }
    public String jsonload(){
        String json =null;
        try{
            InputStream is=getApplicationContext().getAssets().open("SAMPLE.json");
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            json=new String(buffer, "UTF-8");

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
