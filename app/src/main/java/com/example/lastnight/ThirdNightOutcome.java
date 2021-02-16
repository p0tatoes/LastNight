package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdNightOutcome extends AppCompatActivity implements View.OnClickListener{

    TextView txtStory;
    boolean breakDoor, greetGuard, giveFood, giveLighter;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_night_outcome);

        txtStory = findViewById(R.id.txt_ThirdNightOutcome);
        Button btnNext = findViewById(R.id.btnNext_ThirdNightOutcome);
        btnNext.setOnClickListener(this);

        breakDoor = getIntent().getBooleanExtra("BREAK_DOOR", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);
        giveLighter = getIntent().getBooleanExtra("GIVE_LIGHTER", true);

        if (breakDoor == true) {
            txtStory.setText("You decided to break the door down by ramming it.");
        }
        else {
            txtStory.setText("You decided to leave and not break break the door open.");
        }

    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, LastNight.class);
        switch (view.getId()) {
            case R.id.btnNext_ThirdNightOutcome:
                page++;
                if (breakDoor == true) {
                    if (page == 2) {
                        txtStory.setText("You find a bracelet and a note inside the room");
                    }
                    else if (page == 3) {
                        txtStory.setText("Upon closer inspection, you realize that the bracelet belongs to your sister.");
                    }
                    else if (page == 4) {
                        txtStory.setText("You read the note.");
                    }
                    else if (page == 5) {
                        txtStory.setText("It says that she was heading to 'Route 7' to investigate a specific area.");
                    }
                    else if (page == 6) {
                        txtStory.setText("She said that there was something 'off' about that area");
                    }
                    else if (page == 7) {
                        next.putExtra("BREAK_DOOR", breakDoor);
                        next.putExtra("GREET_GUARD", greetGuard);
                        next.putExtra("GIVE_FOOD", giveFood);
                        next.putExtra("GIVE_LIGHTER", giveLighter);
                        startActivity(next);
                    }
                }
                else {
                    if (page == 2) {
                        txtStory.setText("You did not want to risk getting injured by ramming down the door.");
                    }
                    else if (page == 3) {
                        txtStory.setText("You also did not want to risk triggering any traps.");
                    }
                    else if (page == 4) {
                        next.putExtra("BREAK_DOOR", breakDoor);
                        next.putExtra("GREET_GUARD", greetGuard);
                        next.putExtra("GIVE_FOOD", giveFood);
                        next.putExtra("GIVE_LIGHTER", giveLighter);
                        startActivity(next);
                    }
                }
                break;
        }
    }
}