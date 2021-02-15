package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Midnight extends AppCompatActivity implements View.OnClickListener{

    boolean bringLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midnight);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);

        Button btnNext = findViewById(R.id.btnNext_MidnightCard);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(this, MidnightStory.class);
        switch (view.getId()) {
            case R.id.btnNext_MidnightCard:
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                startActivity(next);
                break;
        }
    }
}