package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondNightDecision extends AppCompatActivity implements View.OnClickListener{

    char decision_SecondNight = ' ';
    boolean bringLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_night_decision);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);

        Button btnDecision1 = findViewById(R.id.btnDecision1_SecondNightDecision);
        Button btnDecision2 = findViewById(R.id.btnDecision2_SecondNightDecision);
        btnDecision1.setOnClickListener(this);
        btnDecision2.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {

        Intent outcome_SecondNightDecision = new Intent(this, SecondNightOutcome.class);
        switch (v.getId()) {
            case R.id.btnDecision1_SecondNightDecision:
                decision_SecondNight = 'a';
                outcome_SecondNightDecision.putExtra("decision_secondnight", decision_SecondNight);
                outcome_SecondNightDecision.putExtra("BROUGHT_LIGHTER", bringLighter);
                startActivity(outcome_SecondNightDecision);
                break;
            case R.id.btnDecision2_SecondNightDecision:
                decision_SecondNight = 'b';
                outcome_SecondNightDecision.putExtra("decision_secondnight", decision_SecondNight);
                outcome_SecondNightDecision.putExtra("BROUGHT_LIGHTER", bringLighter);
                startActivity(outcome_SecondNightDecision);
                break;
        }
    }
}