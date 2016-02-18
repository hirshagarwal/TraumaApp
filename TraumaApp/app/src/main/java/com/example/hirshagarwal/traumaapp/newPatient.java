package com.example.hirshagarwal.traumaapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.example.hirshagarwal.traumaapp.gcs.Eyes;
import com.example.hirshagarwal.traumaapp.obj.Patient;

public class newPatient extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);
        Patient p = new Patient();
        Singleton data = Singleton.getInstance();
        data.addPatient(p);
    }

    //If the user wants to identify the patients GCS
    public void gcsScale(View v){
        Intent intent = new Intent(this, Eyes.class);
        startActivity(intent);
    }

    public void autoTriageButton(View v){
        //TODO Setup the auto triage system
    }

}
