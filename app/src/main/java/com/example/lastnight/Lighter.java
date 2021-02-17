package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Lighter extends AppCompatActivity implements View.OnClickListener{

    boolean breakDoor, giveFood, greetGuard;
    int page = 1;
    TextView txtStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lighter);

        breakDoor = getIntent().getBooleanExtra("BREAK_DOOR", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);

        txtStory = findViewById(R.id.txt_Lighter);
        Button btnNext = findViewById(R.id.btnNext_Lighter);
        GifImageView groupFire = findViewById(R.id.groupFire);
        btnNext.setOnClickListener(this);

        txtStory.setText("With the lighter, the group you encountered during 'Midnight' were able to start a campfire.");
        groupFire.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick (View view) {

        Intent guard = new Intent(this, Guard.class);
        Intent food = new Intent(this, Food.class);
        Intent credits = new Intent(this, Credits.class);
        switch (view.getId()) {
            case R.id.btnNext_Lighter:
                page++;
                if (page == 2) {
                    txtStory.setText("They were able to keep warm during the night.");
                }
                else if (page == 3) {
                    txtStory.setText("They greeted you when you passed by their campsite.");
                }
                else if (page == 4) {
                    if (breakDoor == true && greetGuard == true) {
                        guard.putExtra("GIVE_FOOD", giveFood);
                        startActivity(guard);
                    }
                    else if (giveFood == true) {
                        startActivity(food);
                    }
                    else {
                        startActivity(credits);
                    }
                }
                break;
        }
    }
}