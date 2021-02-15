package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrologueDecision extends AppCompatActivity implements View.OnClickListener{

    boolean bringLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_decision);

        Button btnYes = findViewById(R.id.btnDecision1_Prologue);
        Button btnNo = findViewById(R.id.btnDecision2_Prologue);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

    }

    @Override
    public void onClick (View view) {

        Intent next = new Intent(PrologueDecision.this, PrologueOutcome.class);

        switch (view.getId()) {
            case R.id.btnDecision1_Prologue:
                bringLighter = true;
                next.putExtra("broughtLighter", bringLighter);
                startActivity(next);
                break;
            case R.id.btnDecision2_Prologue:
                bringLighter = false;
                next.putExtra("broughtLighter", bringLighter);
                startActivity(next);
                break;
        }

    }

}