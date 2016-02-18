package com.example.hirshagarwal.traumaapp.autoTriage;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.example.hirshagarwal.traumaapp.R;

public class Walking extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);
    }

    public void trueButton(View v){

    }

    public void falseButton(View v){
        Intent intent = new Intent(this, com.example.hirshagarwal.traumaapp.autoTriage.Breathing.class);
        startActivity(intent);
    }

}
