package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LastNightStory extends AppCompatActivity implements View.OnClickListener{

    boolean breakDoor, greetGuard, giveFood, giveLighter;
    int page = 1;
    TextView txtStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_night_story);

        breakDoor = getIntent().getBooleanExtra("BREAK_DOOR", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);
        giveLighter = getIntent().getBooleanExtra("GIVE_LIGHTER", true);

        txtStory = findViewById(R.id.txt_LastNightStory);
        Button btnNext = findViewById(R.id.btnNext_LastNightStory);
        btnNext.setOnClickListener(this);

        txtStory.setText("You have arrived at your destination: 'Route 7'");
    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, Ending.class);
        switch (view.getId()) {
            case R.id.btnNext_LastNightStory:
            page++;
            if (page == 2) {
                txtStory.setText("Just after arriving, you immediately started the search for your sister.");
            }
            else if (page == 3) {
                txtStory.setText("You spent the entire day searching for her, but to no avail.");
            }
            else if (page == 4) {
                txtStory.setText("You grow tired.");
            }
            else if (page == 5) {
                txtStory.setText("You spend your last bit of energy to set up camp for the night.");
            }
            else if (breakDoor == true) {
                if (page == 6) {
                    txtStory.setText("As you lie down, you remembered your sister's note.");
                }
                else if (page == 7) {
                    txtStory.setText("You quickly take out the note and read it again.");
                }
                else if (page == 8) {
                    txtStory.setText("You went to the area that was stated in note");
                }
                else if (page == 9) {
                    txtStory.setText("Upon reaching the specified area, which was outside of Route 7, you looked around.");
                }
                else if (page == 10) {
                    txtStory.setText("You found some of her belongings.");
                }
                else if (page == 11) {
                    txtStory.setText("Hopeful, you continued searching the area.");
                }
                else if (page == 12) {
                    txtStory.setText("After a while, you found your sister.");
                }
                else if (page == 13) {
                    txtStory.setText("...");
                }
                else if (page == 14) {
                    txtStory.setText("...what's left of her, that is.");
                }
                else if (page == 15) {
                    txtStory.setText("You feel a sense of dread as you look at her corpse.");
                }
                else if (page == 15) {
                    txtStory.setText("Her corpse was burnt to the point where it was indistinguishable from charcoal.");
                }
                else if (page == 16) {
                    txtStory.setText("It was as if she was used as fuel for a camp fire.");
                }
                else if (page == 17) {
                    txtStory.setText("You felt immense sadness and anger.");
                }
                else if (page == 18) {
                    txtStory.setText("And with a heavy heart, you decided to return home.");
                }
                else if (page == 19) {
                    next.putExtra("BREAK_DOOR", breakDoor);
                    next.putExtra("GREET_GUARD", greetGuard);
                    next.putExtra("GIVE_FOOD", giveFood);
                    next.putExtra("GIVE_LIGHTER", giveLighter);
                    startActivity(next);
                }
            }

            else if (breakDoor == false) {
                if (page == 6) {
                    txtStory.setText("After you set up camp, you rested for the night.");
                }
                else if (page == 7) {
                    txtStory.setText("You spent the next couple of days searching.");
                }
                else if (page == 8) {
                    txtStory.setText("An entire week has passed and you still have not found your sister.");
                }
                else if (page == 9) {
                    txtStory.setText("You gave up...");
                }
                else if (page == 10) {
                    txtStory.setText("You say to yourself that she is probably already home.");
                }
                else if (page == 11) {
                    txtStory.setText("And you just missed her along the way by some chance.");
                }
                else if (page == 12) {
                    txtStory.setText("You decided to return home.");
                }
                else if (page == 13) {
                    txtStory.setText("You took a different route, hoping that you could get back faster.");
                }
                else if (page == 14) {
                    txtStory.setText("But you never made it back.");
                }
                else if (page == 15) {
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