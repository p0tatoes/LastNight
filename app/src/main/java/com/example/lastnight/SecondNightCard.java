package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondNightCard extends AppCompatActivity implements View.OnClickListener{

    boolean bringLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_night_card);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);

        Button btnNext = findViewById(R.id.btnNext_SecondNightCard);
        btnNext.setOnClickListener(this);
    }
    @Override
    public void onClick (View v) {

        Intent next = new Intent(this, SecondNightStory.class);
        switch (v.getId()) {
            case R.id.btnNext_SecondNightCard:
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                startActivity(next);
                break;
        }
    }
}