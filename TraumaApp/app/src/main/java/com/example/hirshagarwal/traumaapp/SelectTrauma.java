package com.example.hirshagarwal.traumaapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SelectTrauma extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_trauma);
        String list = "";
        //Open and execute network connection
        System.out.println("About to send POST request");

            WebClient poster = new WebClient("test", this.getApplicationContext());
            poster.execute("http://52.32.13.117/TraumaServer/currentTrauma.php");
        try {
            poster.get(1000, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            e.printStackTrace();
        }
        list = poster.getResponse();

        JSONArray tList = new JSONArray();
        JSONArray idList = new JSONArray();
        try {
            JSONObject traumas = new JSONObject(list);
            tList = traumas.getJSONArray("traumas");
            idList = traumas.getJSONArray("ids");

        } catch (JSONException e){
            e.printStackTrace();
        }

        ArrayList<String> values = new ArrayList<String>();
        ArrayList<Integer> ids = new ArrayList<>();
        final ArrayList<Pair<Integer, String>> traumaList = new ArrayList<>();
        for(int i=0; i<tList.length(); i++){
            try {
                Pair<Integer, String> current = new Pair<>(Integer.parseInt(idList.get(i).toString()), tList.get(i).toString());
                values.add(tList.get(i).toString());
                ids.add(Integer.parseInt(idList.get(i).toString()));
                traumaList.add(current);
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        //Generate string from values

        //Create the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        //Initialize Listview
        ListView selectTraumaList = (ListView) findViewById(R.id.selectTraumaList);
        selectTraumaList.setAdapter(adapter);

        selectTraumaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position + "------------------------------------------------------------");
                Pair<Integer, String> selectedTrauma = traumaList.get(position);
                System.out.println(selectedTrauma.toString());
                int currentId = selectedTrauma.first;
                Intent intent = new Intent(view.getContext(), newPatient.class);
                intent.putExtra("traumaId", currentId);
                startActivity(intent);
            }
        });

    }

}
