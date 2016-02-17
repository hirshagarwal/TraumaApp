package com.example.hirshagarwal.traumaapp.gcs;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.hirshagarwal.traumaapp.R;

import org.w3c.dom.Text;

public class Motor extends Activity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor);

        Intent i = getIntent();
        score = i.getIntExtra("score", 1);

        //Set score view
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(score + "");
    }

    public void noneButton(View v){
        score+=1;
        launchNext();
    }

    public void extensionButton(View v){
        score+=2;
        launchNext();
    }

    public void aFlexionButton(View v){
        score+=3;
        launchNext();
    }

    public void nFlexionButton(View v){
        score+=4;
        launchNext();
    }

    public void localisingButton(View v){
        score+=5;
        launchNext();
    }

    public void commandsButton(View v){
        score+=6;
        launchNext();
    }

    public void launchNext(){
        Intent intent = new Intent(this, Score.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }



}
