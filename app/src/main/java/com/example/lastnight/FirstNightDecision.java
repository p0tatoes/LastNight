package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstNightDecision extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_night_decision);

        Button btnDecision1 = findViewById(R.id.btnDecision1_FirstNight);
        Button btnDecision2 = findViewById(R.id.btnDecision2_FirstNight);
        btnDecision1.setOnClickListener(this);
        btnDecision2.setOnClickListener(this);

    }

    @Override
    public void onClick (View v) {

        Intent next = new Intent(this, FirstNightConclusion.class);
        int decision_FirstNight;
        switch (v.getId()) {
            case R.id.btnDecision1_FirstNight:
                decision_FirstNight = 1;
                next.putExtra("decision_FirstNight", decision_FirstNight);
                startActivity(next);
                break;
            case R.id.btnDecision2_FirstNight:
                decision_FirstNight = 2;
                next.putExtra("decision_FirstNight", decision_FirstNight);
                startActivity(next);
                break;
        }
    }
}