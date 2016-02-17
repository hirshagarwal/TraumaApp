package com.example.hirshagarwal.traumaapp.gcs;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.hirshagarwal.traumaapp.R;

public class Verbal extends Activity {

    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal);

        Intent i = getIntent();
        score = i.getIntExtra("score", 1);

        //Set score
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(score + "");

    }

    public void orientedButton(View v){
        score+=5;
        launchNext();
    }

    public void confusedButton(View v){
        score+=4;
        launchNext();
    }

    public void wordsButton(View v){
        score+=3;
        launchNext();
    }

    public void soundsButton(View v){
        score+=2;
        launchNext();
    }

    public void noneButton(View v){
        score+=1;
        launchNext();
    }

    public void launchNext(){
        Intent intent = new Intent(this, Motor.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }

}
