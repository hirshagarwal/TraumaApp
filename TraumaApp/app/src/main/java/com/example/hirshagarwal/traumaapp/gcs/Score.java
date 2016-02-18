package com.example.hirshagarwal.traumaapp.gcs;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.hirshagarwal.traumaapp.R;
import com.example.hirshagarwal.traumaapp.Singleton;
import com.example.hirshagarwal.traumaapp.obj.Patient;

import org.w3c.dom.Text;

public class Score extends Activity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent i = getIntent();
        score = i.getIntExtra("score", 0);

        //Set label
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText("GCS: " + score);
    }

    public void confirmButton(View v){
        Intent intent = new Intent(this, com.example.hirshagarwal.traumaapp.PatientDashboard.class);
        Singleton data = Singleton.getInstance();
        Patient p = data.getPatient();
        p.setGCS(score);
        startActivity(intent);

    }

    public void cancelButton(View v){
        Intent intent = new Intent(this, com.example.hirshagarwal.traumaapp.newPatient.class);
        startActivity(intent);
    }

}
