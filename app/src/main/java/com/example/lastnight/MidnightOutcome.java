package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MidnightOutcome extends AppCompatActivity implements View.OnClickListener{

    boolean bringLighter;
    char decision_Midnight;
    int page = 1;
    TextView txtOutcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midnight_outcome);

        Button btnNext = findViewById(R.id.btnNext_MidnightOutcome);
        btnNext.setOnClickListener(this);
        txtOutcome = findViewById(R.id.txt_MidnightOutcome);

        Intent next = getIntent();
        Intent lighter_Prologue = getIntent();

        decision_Midnight = next.getCharExtra("decision_midnight", ' ');
        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);

        if (decision_Midnight == 'a') {
            txtOutcome.setText("You approach the campsite.");
        }
        else if (decision_Midnight == 'b') {
            txtOutcome.setText("You decided to continue to the supermarket.");
        }

    }

    @Override
    public void onClick (View view) {

        Intent third_Night = new Intent(this, ThirdNight.class);
        switch (view.getId()) {
            case R.id.btnNext_MidnightOutcome:
                txtOutcome.setText(" ");
                page++;
                if (decision_Midnight == 'a' && page == 2) {
                    txtOutcome.setText("As you approach the campsite, they shout at you and tell you to stop.");
                }
                else if (decision_Midnight == 'a' && page == 3) {
                    txtOutcome.setText("You tell them that you are in need of supplies.");
                }
                else if (decision_Midnight == 'a' && page == 4) {
                    txtOutcome.setText("They say that they can give you some of their extra supplies.");
                }
                else if (decision_Midnight == 'a' && page == 4) {
                    txtOutcome.setText("But, under the condition that you also give them something valuable in exchange.");
                }
                else if (decision_Midnight == 'a' && page == 5) {
                    txtOutcome.setText(" ");
                    if (bringLighter == false) {
                        txtOutcome.setText("You check your bag, but did not find anything of value to offer.");
                    }
                    else if (bringLighter == true) {
                        txtOutcome.setText("You check your bag and decided to offer your lighter.");
                    }

                }

                break;
        }
    }
}