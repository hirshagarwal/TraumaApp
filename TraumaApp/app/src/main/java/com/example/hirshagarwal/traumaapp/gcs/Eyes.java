package com.example.hirshagarwal.traumaapp.gcs;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.example.hirshagarwal.traumaapp.MainActivity;
import com.example.hirshagarwal.traumaapp.R;

public class Eyes extends Activity {

    private int currentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eyes);
    }

    public void spontaneousButton(View v){
        currentScore = 4;
        launchNext();
    }

    public void soundButton(View v){
        currentScore = 3;
        launchNext();
    }

    public void pressureButton(View v){
        currentScore = 2;
        launchNext();
    }

    public void noneButton(View v){
        currentScore = 1;
        launchNext();
    }

    private void launchNext(){
        Intent intent = new Intent(this, Verbal.class);
        intent.putExtra("score", currentScore);
        startActivity(intent);
    }

}
