package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MidnightDecision extends AppCompatActivity implements View.OnClickListener{

    char decision_Midnight = ' ';
    boolean bringLighter, greetGuard, giveFood, giveLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midnight_decision);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);

        Button btnDecision1 = findViewById(R.id.btnDecision1_Midnight);
        Button btnDecision2 = findViewById(R.id.btnDecision2_Midnight);
        btnDecision1.setOnClickListener(this);
        btnDecision2.setOnClickListener(this);
    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, MidnightOutcome.class);
        switch (view.getId()) {
            case R.id.btnDecision1_Midnight:
                decision_Midnight = 'a';
                if (bringLighter == true) {
                    giveLighter = true;
                }
                next.putExtra("decision_midnight", decision_Midnight);
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                next.putExtra("GREET_GUARD", greetGuard);
                next.putExtra("GIVE_FOOD", giveFood);
                next.putExtra("GIVE_LIGHTER", giveLighter);
                startActivity(next);
                break;
            case R.id.btnDecision2_Midnight:
                decision_Midnight = 'b';
                next.putExtra("decision_midnight", decision_Midnight);
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                next.putExtra("GREET_GUARD", greetGuard);
                next.putExtra("GIVE_FOOD", giveFood);
                next.putExtra("GIVE_LIGHTER", giveLighter);
                startActivity(next);
                break;
        }
    }
}