package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ending extends AppCompatActivity implements View.OnClickListener{

    boolean breakDoor, greetGuard, giveFood, giveLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        breakDoor = getIntent().getBooleanExtra("BREAK_DOOR", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);
        giveLighter = getIntent().getBooleanExtra("GIVE_LIGHTER", true);

        Button btnNext = findViewById(R.id.btnNext_Ending);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick (View view) {

        Intent lighter = new Intent(this, Lighter.class);
        Intent guard = new Intent(this, Guard.class);
        Intent food = new Intent(this, Food.class);
        Intent credits = new Intent(this, Credits.class);

        switch (view.getId()) {
            case R.id.btnNext_Ending:
                 //if (greetGuard == true && breakDoor == true) {
                     //guard.putExtra("BREAK_DOOR", breakDoor);
                     //guard.putExtra("GIVE_FOOD", giveFood);
                     //guard.putExtra("GIVE_LIGHTER", giveLighter);
                     //startActivity(guard);
                 //}
                 //else if (giveFood == true) {
                     //food.putExtra("BREAK_DOOR", breakDoor);
                     //food.putExtra("GIVE_LIGHTER", giveLighter);
                     //startActivity(food);
                 //}
                 //else if (giveLighter == true && breakDoor == true) {
                     //startActivity(lighter);
                 //}

                 if (giveLighter == true && breakDoor == true) {
                     lighter.putExtra("BREAK_DOOR", breakDoor);
                     lighter.putExtra("GIVE_FOOD", giveFood);
                     lighter.putExtra("GREET_GUARD", greetGuard);
                     startActivity(lighter);
                 }
                 else if (greetGuard == true && breakDoor == true) {
                     guard.putExtra("GIVE_FOOD", giveFood);
                     startActivity(guard);
                 }
                 else if (giveFood == true) {
                     startActivity(food);
                 }
                 else {
                     startActivity(credits);
                 }
                break;
        }
    }
}