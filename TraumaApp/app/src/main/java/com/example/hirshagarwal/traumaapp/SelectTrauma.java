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

        String[] values = {"T1", "T2"};
        //Create the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        //Initialize Listview
        ListView selectTraumaList = (ListView) findViewById(R.id.selectTraumaList);
        selectTraumaList.setAdapter(adapter);

        selectTraumaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(newPatient.class);

            }
        });

    }

}
