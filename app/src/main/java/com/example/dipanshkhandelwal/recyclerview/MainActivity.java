package com.example.dipanshkhandelwal.recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String data = ReadFromfile("MyData.json",MainActivity.this);
        ArrayList<MyData> list = extractData(data);

        ListView listView = (ListView) findViewById(R.id.list);
        MyDataAdapter adapter = null;
        adapter = new MyDataAdapter(this ,R.layout.mydata_layout ,list);
        listView.setAdapter(adapter);
    }


    public ArrayList<MyData> extractData(String s){

        ArrayList<MyData> mylist = new ArrayList<>();

        try {
            JSONObject main = new JSONObject(s);
            JSONObject contacts = main.getJSONObject("myContacts");
            JSONArray list = contacts.getJSONArray("allList");

            for(int i=0;i<list.length();i++){
                JSONObject obj = list.getJSONObject(i);

                String name = obj.getString("Name");
                String address = obj.getString("Address");
                String phone = obj.getString("PhoneNumber");

                MyData md = new MyData(name , address , phone);
                mylist.add(md);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mylist;
    }


    public String ReadFromfile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }
}
