package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondNightOutcome extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_night_outcome);

        TextView txtOutcome = findViewById(R.id.txtOutcome_SecondNightOutcome);
        Button btnNext = findViewById(R.id.btnNext_SecondNightOutcome);
        btnNext.setOnClickListener(this);

        char decision_SecondNight;
        Intent outcome_SecondNightDecision = getIntent();
        decision_SecondNight = outcome_SecondNightDecision.getCharExtra("decision_secondnight", ' ');

        if (decision_SecondNight == 'a') {
            txtOutcome.setText("You tell the man that you can't give him food and left quickly. You look back and see the man following you. You pick up your pace and eventually lose him. You realized that you have taken a detour and wasted time going back to the correct path ");
        }
        else {
            txtOutcome.setText("You decided to give some food to the man. He then quickly leaves. You hear him say something, but you couldn't make out what he was saying. Your food can now only last you one more day.");
        }
    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, Midnight.class);
        switch (view.getId()) {
            case R.id.btnNext_SecondNightOutcome:
                startActivity(next);
                break;
        }
    }
}