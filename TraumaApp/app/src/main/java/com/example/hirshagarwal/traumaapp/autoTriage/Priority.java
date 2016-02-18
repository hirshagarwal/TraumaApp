package com.example.hirshagarwal.traumaapp.autoTriage;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import com.example.hirshagarwal.traumaapp.R;

public class Priority extends Activity {

    private int priority = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority);
        Intent i = getIntent();
        priority = i.getIntExtra("priority", 0);

        //Get the score view
        TextView scoreView = (TextView) findViewById(R.id.scoreView);
        String scoreText = "";
        if(priority==0){
            scoreText = "0 - Patient Dead";
        } else if (priority==1) {
            scoreText = "1 - Immediate";
        } else if (priority==2){
            scoreText = "2 - Urgent";
        } else {
            scoreText = "3 - Delayed";
        }
        scoreView.setText("Priority: " + scoreText);
    }

}
