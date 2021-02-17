package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MidnightStory extends AppCompatActivity implements View.OnClickListener{

    TextView txtStory;
    int page = 1;
    boolean bringLighter, greetGuard, giveFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midnight_story);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);

        Button btnNext = findViewById(R.id.btnNext_MidnightStory);
        btnNext.setOnClickListener(this);
        txtStory = findViewById(R.id.txtStory_MidnightStory);

        txtStory.setText("You check your bag one more time and realized that you don't have enough food and supplies.");
    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, MidnightDecision.class);
        switch (view.getId()) {
            case R.id.btnNext_MidnightStory:
                page++;
                if (page == 2) {
                    txtStory.setText("You grab your map. You spot that there is an abandoned supermarket where you could potentially find food.");
                }
                else if (page == 3) {
                    txtStory.setText("You set out to head to the supermarket");
                }
                else if (page == 4) {
                    txtStory.setText("Along the way, you come across a small campsite and see that there are people there.");
                }
                else {
                    next.putExtra("BROUGHT_LIGHTER", bringLighter);
                    next.putExtra("GREET_GUARD", greetGuard);
                    next.putExtra("GIVE_FOOD", giveFood);
                    startActivity(next);
                }


                break;
        }
    }
}