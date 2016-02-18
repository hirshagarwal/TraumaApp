package com.example.hirshagarwal.traumaapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.hirshagarwal.traumaapp.obj.Patient;

public class PatientDashboard extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        //Get the patient data
        Singleton data = Singleton.getInstance();
        Patient p = data.getPatient();

        //Setup interface objects
        TextView gcsView = (TextView) findViewById(R.id.gcsView);
        TextView priorityView = (TextView) findViewById(R.id.priorityView);
        Switch genderSwitch = (Switch) findViewById(R.id.genderSwitch);
        EditText nameView = (EditText) findViewById(R.id.nameText);

        nameView.setText(p.getName());
        if(p.getGCS()==-1){
            gcsView.setText("GCS: Untested");
        } else {
            gcsView.setText("GCS: " + p.getGCS());
        }
        //Set priority text
        int priority = p.getPriority();
        String pText = setPriorityText(p);
        priorityView.setText("Priority: " + pText);
        if(p.getGender()==0){
            genderSwitch.setChecked(false);
            genderSwitch.setText("Male: ");
        } else {
            genderSwitch.setChecked(true);
            genderSwitch.setText("Female: ");
        }
    }

    //Get the text to write depeding on patient priority
    private String setPriorityText(Patient p){
        int priority = p.getPriority();
        String pText = "";
        if(priority==-1){
            pText = "Not Set";
        } else if(priority==0){
            pText = "0 - Unresponsive";
        } else if(priority==1){
            pText = "1 - Immediate";
        } else if(priority ==2){
            pText = "2 - Urgent";
        } else {
            pText = "3 - Delayed";
        }
        return pText;
    }

    public void setPriority(View v){
        Intent i = new Intent(this, com.example.hirshagarwal.traumaapp.autoTriage.Walking.class);
        startActivity(i);
    }

    public void setGCS(View v){
        Intent i = new Intent(this, com.example.hirshagarwal.traumaapp.gcs.Eyes.class);
        startActivity(i);
    }


}
