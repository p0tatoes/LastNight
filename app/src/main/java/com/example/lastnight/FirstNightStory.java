package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstNightStory extends AppCompatActivity implements View.OnClickListener {

    int page = 1;
    boolean bringLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_night_story);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);

        Button btnNext = findViewById(R.id.btnNext_FirstNightStory);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick (View v) {

        TextView txtStory = findViewById(R.id.txtStory_FirstNight);
        Intent next = new Intent(FirstNightStory.this, FirstNightDecision.class);

        switch (v.getId()) {
            case R.id.btnNext_FirstNightStory:
                if (page == 1) {
                    txtStory.setText("You attempt to start a campfire to keep you warm");
                    page++;
                }
                else if (page == 2) {
                    txtStory.setText("but there is not enough fuel to make the fire last for the night.");
                    page++;
                }
                else if (page == 3) {
                    next.putExtra("BROUGHT_LIGHTER", bringLighter);
                    startActivity(next);
                }
                break;
        }
    }
}