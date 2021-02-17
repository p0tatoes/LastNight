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


public class PrologueOutcome extends AppCompatActivity implements View.OnClickListener{

    boolean bringLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_outcome);

        Button prologueOutcomeNext = findViewById(R.id.btnNxt_PrologueOutcome);
        ConstraintLayout pOutcomeBG = findViewById(R.id.pOutcomeBG);
        prologueOutcomeNext.setOnClickListener(this);
        GifImageView lighterGif = findViewById(R.id.lighterGif);

        TextView prologueOutcome = findViewById(R.id.prologueOutcomeTxt);
        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true); //next.getBooleanExtra("BROUGHT_LIGHTER", true);

        if (bringLighter == true) {
            prologueOutcome.setText("You chose to bring the lighter.");
            prologueOutcome.setTextColor(Color.parseColor("#FFFFFF"));
            pOutcomeBG.setBackgroundColor(Color.parseColor("#000000"));
            lighterGif.setVisibility(View.VISIBLE);

        }
        else {
            prologueOutcome.setText("You chose to not bring the lighter.");
            prologueOutcome.setTextColor(Color.parseColor("#FFFFFF"));
            pOutcomeBG.setBackgroundColor(Color.parseColor("#000000"));
            lighterGif.setVisibility(View.INVISIBLE);

        }

    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(PrologueOutcome.this, PrologueStory2.class);
        switch (view.getId()) {
            case R.id.btnNxt_PrologueOutcome:
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                startActivity(next);
                break;
        }

    }

}