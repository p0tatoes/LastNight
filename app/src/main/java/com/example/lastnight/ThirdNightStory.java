package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ThirdNightStory extends AppCompatActivity implements View.OnClickListener{

    TextView txtStory;
    int page = 1;
    boolean greetGuard, giveFood, giveLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_night_story);

        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);
        giveLighter = getIntent().getBooleanExtra("GIVE_LIGHTER", true);

        txtStory = findViewById(R.id.txt_ThirdNightStory);
        Button btnNext = findViewById(R.id.btnNext_ThirdNightStory);
        btnNext.setOnClickListener(this);

        txtStory.setText("As usual, you found an abandoned building.");
    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, ThirdNightDecision.class);
        switch (view.getId()) {
            case R.id.btnNext_ThirdNightStory:
                page++;
                if (page == 2) {
                    txtStory.setText("You start setting up camp and attempted to start a campfire");
                }
                else if (page == 3) {
                    txtStory.setText("After setting up, you sat there...");
                }
                else if (page == 4) {
                    txtStory.setText("...thinking about your sister.");
                }
                else if (page == 5) {
                    txtStory.setText("Troubled, you decided to search the building for something useful.");
                }
                else if (page == 6) {
                    txtStory.setText("While roaming around the other floors, you notice that there were tents set up here.");
                }
                else if (page == 7) {
                    txtStory.setText("You decided to search the area thoroughly.");
                }
                else if (page == 8) {
                    txtStory.setText("You hoped that there would be a clue that could lead you to your sister.");
                }
                else if (page == 9) {
                    txtStory.setText("After looking around the area, you find a locked door.");
                }

                else if (page == 10) {
                    next.putExtra("GREET_GUARD", greetGuard);
                    next.putExtra("GIVE_FOOD", giveFood);
                    next.putExtra("GIVE_LIGHTER", giveLighter);
                    startActivity(next);
                }
                break;
        }
    }
}