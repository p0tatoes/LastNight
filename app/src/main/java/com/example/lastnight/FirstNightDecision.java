package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstNightDecision extends AppCompatActivity implements View.OnClickListener {

    boolean bringLighter, greetGuard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_night_decision);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);

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
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                next.putExtra("GREET_GUARD", greetGuard);
                startActivity(next);
                break;
            case R.id.btnDecision2_FirstNight:
                decision_FirstNight = 2;
                next.putExtra("decision_FirstNight", decision_FirstNight);
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                next.putExtra("GREET_GUARD", greetGuard);
                startActivity(next);
                break;
        }
    }
}