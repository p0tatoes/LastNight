package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LastNight extends AppCompatActivity implements View.OnClickListener{

    boolean breakDoor, greetGuard, giveFood, giveLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_night);

        breakDoor = getIntent().getBooleanExtra("BREAK_DOOR", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);
        giveLighter = getIntent().getBooleanExtra("GIVE_LIGHTER", true);

        Button btnNext = findViewById(R.id.btnNext_LastNightCard);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, LastNightStory.class);
        switch (view.getId()) {
            case R.id.btnNext_LastNightCard:
                next.putExtra("BREAK_DOOR", breakDoor);
                next.putExtra("GREET_GUARD", greetGuard);
                next.putExtra("GIVE_FOOD", giveFood);
                next.putExtra("GIVE_LIGHTER", giveLighter);
                startActivity(next);
                break;
        }
    }
}