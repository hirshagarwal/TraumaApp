package com.example.hirshagarwal.traumaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class newTrauma extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trauma);
    }

    public void createTrauma(View v){
        //Get components
        TextView nameText = (TextView) this.findViewById(R.id.traumaName);
        TextView locationText = (TextView) this.findViewById(R.id.traumaLocation);
        TextView otherInfoText = (TextView) this.findViewById(R.id.otherInfo);
        //Set Fields
        String name = nameText.getText().toString();
        String location = locationText.getText().toString();
        String otherInfo = otherInfoText.getText().toString();

        //Generate JSON to send
        JSONObject sendObj = new JSONObject();
            //Try to build the JSON object
        try {
            sendObj.put("name", name);
            sendObj.put("location", location);
            sendObj.put("notes", otherInfo);
        } catch (JSONException e){
            e.printStackTrace();
        }
        String uploadObj = sendObj.toString();
        WebClient web = new WebClient(uploadObj, this.getApplicationContext());
        web.execute("http://52.32.13.117/TraumaServer/createTrauma.php");
        //Wait for execution
        try{
            web.get(1000, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            e.printStackTrace();
        }
        String resp = web.getResponse();
        //Try to encode as JSON
        try {
            JSONObject jsonData = new JSONObject(resp);
        } catch (Exception e){
            e.printStackTrace();
        }

        //Move to the new patient screen
        Intent i = new Intent(this, newPatient.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_trauma, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
