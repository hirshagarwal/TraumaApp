package com.example.hirshagarwal.traumaapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.hirshagarwal.traumaapp.obj.Patient;

import org.w3c.dom.Text;

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
        gcsView.setText("GCS: " + p.getGCS());
        priorityView.setText("Priority: " + p.getPriority());
        if(p.getGender()==0){
            genderSwitch.setChecked(false);
            genderSwitch.setText("Male: ");
        } else {
            genderSwitch.setChecked(true);
            genderSwitch.setText("Female: ");
        }
    }

    public void setPriority(View v){
        //TODO Link to the priority automator

    }


}
