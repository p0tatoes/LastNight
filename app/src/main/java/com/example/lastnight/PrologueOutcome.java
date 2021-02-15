package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PrologueOutcome extends AppCompatActivity implements View.OnClickListener{

    boolean bringLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_outcome);

        Button prologueOutcomeNext = findViewById(R.id.btnNxt_PrologueOutcome);
        prologueOutcomeNext.setOnClickListener(this);

        TextView prologueOutcome = findViewById(R.id.prologueOutcomeTxt);
        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true); //next.getBooleanExtra("BROUGHT_LIGHTER", true);

        if (bringLighter == true) {
            prologueOutcome.setText("You chose to bring the lighter.");
        }
        else {
            prologueOutcome.setText("You chose to not bring the lighter.");
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