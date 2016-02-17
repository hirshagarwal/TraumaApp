package com.example.hirshagarwal.traumaapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.example.hirshagarwal.traumaapp.gcs.Eyes;

public class newPatient extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);
    }

    //If the user wants to identify the patients GCS
    public void gcsScale(View v){
        Intent intent = new Intent(this, Eyes.class);
        startActivity(intent);
    }

}
