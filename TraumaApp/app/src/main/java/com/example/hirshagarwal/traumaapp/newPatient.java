package com.example.hirshagarwal.traumaapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.hirshagarwal.traumaapp.gcs.Eyes;
import com.example.hirshagarwal.traumaapp.obj.Patient;
import com.example.hirshagarwal.traumaapp.obj.Trauma;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class newPatient extends Activity {

    public int traumaId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);
        Intent i = getIntent();
        traumaId = i.getIntExtra("traumaId", 0);
        Trauma currentTrauma;

        //Download all of the current trauma information
        currentTrauma = getTrauma();

        //Get interface objects
        TextView traumaNameView = (TextView) findViewById(R.id.traumaNameView);
        TextView hospitalNameView = (TextView) findViewById(R.id.hospitalNameView);

        //Set new text
        traumaNameView.setText("Trauma: " + currentTrauma.getName());
        hospitalNameView.setText("Servicing Hospital: Mass General");

        //Set the singleton trauma
        Singleton s = Singleton.getInstance();
        s.setTrauma(currentTrauma);

        Patient p = new Patient();
        Singleton data = Singleton.getInstance();
        data.addPatient(p);
    }

    //If the user wants to identify the patients GCS
    public void gcsScale(View v){
        Intent intent = new Intent(this, Eyes.class);
        startActivity(intent);
    }

    public Trauma getTrauma(){
        //Build JSON request
        JSONObject sendObj = new JSONObject();
        try{
            sendObj.put("id", traumaId);
        } catch (JSONException e){
            e.printStackTrace();
        }
        String uploadObj = sendObj.toString();
        WebClient web = new WebClient(uploadObj, this.getApplicationContext());
        web.execute("http://52.32.13.117/TraumaServer/getTrauma.php");
        //Wait for execution
        try{
            web.get(1000, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            e.printStackTrace();
        }
        String resp = web.getResponse();
        //Encode response as JSON
        JSONObject jsonData = null;
        try {
            jsonData = new JSONObject(resp);
            System.out.println("JSON DATA ENCODED: " + resp.toString());

        } catch (JSONException e){
            e.printStackTrace();
        }

        //Create Trauma Object
        String name = "";
        int organizationId = 0;
        String location = "";
        String notes = "";
        //Try to set the values
        try{
            name = jsonData.getString("name");
            organizationId = jsonData.getInt("organizationId");
            location = jsonData.getString("location");
            notes = jsonData.getString("notes");
        } catch (Exception e){
            e.printStackTrace();
        }
        Trauma t = new Trauma(traumaId, name, organizationId, location, notes);
        return t;
    }

    public void autoTriageButton(View v){
        //TODO Setup the auto triage system
        Intent intent = new Intent(this, com.example.hirshagarwal.traumaapp.autoTriage.Walking.class);
        startActivity(intent);
    }

}
