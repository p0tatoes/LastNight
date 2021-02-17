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

public class SecondNightOutcome extends AppCompatActivity implements View.OnClickListener {

    boolean bringLighter, greetGuard, giveFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_night_outcome);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);

        TextView txtOutcome = findViewById(R.id.txtOutcome_SecondNightOutcome);
        Button btnNext = findViewById(R.id.btnNext_SecondNightOutcome);
        btnNext.setOnClickListener(this);
        ConstraintLayout snOutcoBG = findViewById(R.id.snOutcoBG);
        GifImageView gibFood = findViewById(R.id.gibFood);

        char decision_SecondNight;
        Intent outcome_SecondNightDecision = getIntent();
        decision_SecondNight = outcome_SecondNightDecision.getCharExtra("decision_secondnight", ' ');

        if (decision_SecondNight == 'a') {
            txtOutcome.setText("You tell the man that you can't give him food and left quickly. You look back and see the man following you. You pick up your pace and eventually lose him. You realized that you have taken a detour and wasted time going back to the correct path ");
            txtOutcome.setTextColor(Color.parseColor("#FFFFFF"));
            snOutcoBG.setBackgroundColor(Color.parseColor("#000000"));
            gibFood.setVisibility(View.INVISIBLE);
        }
        else {
            txtOutcome.setText("You decided to give some food to the man. He then quickly leaves. You hear him say something, but you couldn't make out what he was saying. Your food can now only last you one more day.");
            txtOutcome.setTextColor(Color.parseColor("#FFFFFF"));
            snOutcoBG.setBackgroundColor(Color.parseColor("#000000"));
            gibFood.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, Midnight.class);
        switch (view.getId()) {
            case R.id.btnNext_SecondNightOutcome:
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                next.putExtra("GREET_GUARD", greetGuard);
                next.putExtra("GIVE_FOOD", giveFood);
                startActivity(next);
                break;
        }
    }
}