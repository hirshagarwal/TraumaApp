package com.example.hirshagarwal.traumaapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectTrauma extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_trauma);
        String list = "";
        //Open and execute network connection
        System.out.println("About to send POST request");

            WebClient poster = new WebClient("test", this.getApplicationContext());
            poster.execute("http://52.32.13.117/TraumaServer/postTest.php");
        list = poster.getResponse();
        //Generate string from values
        String[] values = {list, "T2"};
        //Create the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        //Initialize Listview
        ListView selectTraumaList = (ListView) findViewById(R.id.selectTraumaList);
        selectTraumaList.setAdapter(adapter);

        selectTraumaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), newPatient.class);
                startActivity(intent);
            }
        });

    }

}
