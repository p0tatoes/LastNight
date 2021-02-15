package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrologueDecision2 extends AppCompatActivity implements View.OnClickListener{

    char p2Decision;
    boolean bringLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_decision2);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);

        Button btnDecision1 = findViewById(R.id.btnDecision1_Prologue2);
        Button btnDecision2 = findViewById(R.id.btnDecision2_Prologue2);
        btnDecision1.setOnClickListener(this);
        btnDecision2.setOnClickListener(this);

    }

    @Override
    public void onClick (View view) {

        Intent p2Outcome2 = new Intent(PrologueDecision2.this, PrologueConclusion.class);

        switch (view.getId()) {
            case R.id.btnDecision1_Prologue2:
                p2Decision = 'a';
                p2Outcome2.putExtra("p2_decision", p2Decision);
                p2Outcome2.putExtra("BROUGHT_LIGHTER", bringLighter);
                startActivity(p2Outcome2);
                break;
            case R.id.btnDecision2_Prologue2:
                p2Decision = 'b';
                p2Outcome2.putExtra("p2_decision", p2Decision);
                p2Outcome2.putExtra("BROUGHT_LIGHTER", bringLighter);
                startActivity(p2Outcome2);
                break;

        }

    }

}