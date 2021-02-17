package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class FirstNightConclusion extends AppCompatActivity implements View.OnClickListener {

    boolean bringLighter, greetGuard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_night_conclusion);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);

        Button btnNext = findViewById(R.id.btnNext_FirstNightConclusion);
        ConstraintLayout fnConclBG = findViewById(R.id.fnConclBG);
        GifImageView campfireMove = findViewById(R.id.campfireMove);
        GifImageView campfireSmoke = findViewById(R.id.campfireSmoke);
        btnNext.setOnClickListener(this);

        Intent next = getIntent();
        int decision_FirstNight = next.getIntExtra("decision_FirstNight", 0);
        TextView txtStory = findViewById(R.id.txtStory_FirstNightConclusion);

        switch (decision_FirstNight) {
            case 1:
                txtStory.setText("You decided to go outside and gather wood. You managed to find wood nearby, enough to last for the night. As you head back, you feel a presence watching over you.");
                txtStory.setTextColor(Color.parseColor("#FFFFFF"));
                fnConclBG.setBackgroundColor(Color.parseColor("#161616"));
                campfireMove.setVisibility(View.VISIBLE);
                campfireSmoke.setVisibility(View.INVISIBLE);
                break;
            case 2:
                txtStory.setText("You decided to play safe and stay inside. You prayed that the fire would not go out until morning, though the fire went out. You felt cold for most of the night, but you managed to make it until morning.");
                txtStory.setTextColor(Color.parseColor("#FFFFFF"));
                fnConclBG.setBackgroundColor(Color.parseColor("#161616"));
                campfireMove.setVisibility(View.INVISIBLE);
                campfireSmoke.setVisibility(View.VISIBLE);

                break;
        }
    }
    @Override
    public void onClick (View v) {

        Intent next = new Intent(this, SecondNightCard.class);

        switch(v.getId()) {
            case R.id.btnNext_FirstNightConclusion:
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                next.putExtra("GREET_GUARD", greetGuard);
                startActivity(next);
                break;
        }

    }
}