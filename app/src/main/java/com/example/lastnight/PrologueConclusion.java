package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrologueConclusion extends AppCompatActivity implements View.OnClickListener {

    boolean bringLighter;
    boolean greetGuard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_conclusion);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);

        Intent p2Outcome2 = getIntent();
        char prologue2Outcome = p2Outcome2.getCharExtra("p2_decision", ' ');
        TextView txtPrologue2Outcome = findViewById(R.id.txtPrologue2Outcome);

        Button btnPrologue2Nxt = findViewById(R.id.btnPrologue2Nxt);
        btnPrologue2Nxt.setOnClickListener(this);

        if (prologue2Outcome == 'a') {
            txtPrologue2Outcome.setText("As you approach the tunnel exit, you greet the guard and bid him farewell. The guard greets you back and wishes you good luck on your journey. As you reach the surface, you feel a surge of confidence and optimism.");
        } else {
            txtPrologue2Outcome.setText("You quickly rush through the tunnel exit. As you run past the tunnel exit, you briefly look back. You see the guard quietly staring at you as you head to the surface.");
        }

    }

    @Override
    public void onClick(View view) {

        Intent next = new Intent(this, TheFirstNightCard.class);

        switch (view.getId()) {
            case R.id.btnPrologue2Nxt:
                next.putExtra("BROUGHT_LIGHTER", bringLighter);
                next.putExtra("GREET_GUARD", greetGuard);
               startActivity(next);
                break;
        }

    }
}