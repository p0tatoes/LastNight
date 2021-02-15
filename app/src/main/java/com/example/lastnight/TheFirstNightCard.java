package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TheFirstNightCard extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_first_night_card);

        Button btnNext = findViewById(R.id.btnNext_FirstNightStory);
        btnNext.setOnClickListener(this);


    }

    @Override
    public void onClick (View v) {

        Intent next = new Intent(this, FirstNightStory.class);

        switch (v.getId()) {
            case R.id.btnNext_FirstNightStory:
                startActivity(next);
                break;
        }

    }
}