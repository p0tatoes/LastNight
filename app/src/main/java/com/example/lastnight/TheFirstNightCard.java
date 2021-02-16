package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TheFirstNightCard extends AppCompatActivity implements View.OnClickListener{

    boolean bringLighter, greetGuard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_first_night_card);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);

        Button btnNext = findViewById(R.id.btnNext_FirstNightStory);
        btnNext.setOnClickListener(this);


    }

    @Override
    public void onClick (View v) {

        Intent next = new Intent(this, FirstNightStory.class);

        switch (v.getId()) {
            case R.id.btnNext_FirstNightStory:
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                next.putExtra("GREET_GUARD", greetGuard);
                startActivity(next);
                break;
        }

    }
}