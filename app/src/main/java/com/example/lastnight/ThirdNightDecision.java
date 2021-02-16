package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdNightDecision extends AppCompatActivity implements View.OnClickListener{

    boolean breakDoor = true;
    boolean greetGuard, giveFood, giveLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_night_decision);

        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);
        giveLighter = getIntent().getBooleanExtra("GIVE_LIGHTER", true);

        Button btnDecision1 = findViewById(R.id.btnDecision1_ThirdNightDecision);
        Button btnDecision2 = findViewById(R.id.btnDecision2_ThirdNightDecision);
        btnDecision1.setOnClickListener(this);
        btnDecision2.setOnClickListener(this);
    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, ThirdNightOutcome.class);
        switch (view.getId()) {
            case R.id.btnDecision1_ThirdNightDecision:
                breakDoor = false;
                next.putExtra("BREAK_DOOR", breakDoor);
                next.putExtra("GREET_GUARD", greetGuard);
                next.putExtra("GIVE_FOOD", giveFood);
                next.putExtra("GIVE_LIGHTER", giveLighter);
                startActivity(next);
                break;
            case R.id.btnDecision2_ThirdNightDecision:
                breakDoor = true;
                next.putExtra("BREAK_DOOR", breakDoor);
                next.putExtra("GREET_GUARD", greetGuard);
                next.putExtra("GIVE_FOOD", giveFood);
                next.putExtra("GIVE_LIGHTER", giveLighter);
                startActivity(next);
                break;

        }
    }
}