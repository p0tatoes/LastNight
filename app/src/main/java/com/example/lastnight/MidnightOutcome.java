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
                else if (decision_Midnight == 'a' && page == 5) {
                    txtOutcome.setText("But, under the condition that you also give them something valuable in exchange.");
                }
                else if (decision_Midnight == 'a') {
                    if (!bringLighter && page == 6) {
                        txtOutcome.setText("You check your bag, but did not find anything of value to offer.");
                    }
                    else if (bringLighter && page == 6) {
                        txtOutcome.setText("You check your bag and decided to offer your lighter.");
                    }
                    else if (!bringLighter && page == 7) {
                        txtOutcome.setText("The group tells you to leave and never approach them if you don't have anything of value to offer.");
                    }
                    else if (bringLighter && page == 7) {
                        txtOutcome.setText("They accepted the offer.");
                    }
                    else if (!bringLighter && page == 8) {
                        txtOutcome.setText("Disappointed, you continued with your journey.");
                    }
                    else if (bringLighter && page == 8) {
                        txtOutcome.setText("They expressed their gratitude...");
                    }
                    else if (!bringLighter && page == 9) {
                        startActivity(third_Night);
                    }
                    else if (bringLighter && page == 9) {
                        txtOutcome.setText("and told you that they were having trouble starting a fire.");
                    }
                    else if (bringLighter && page == 10) {
                        txtOutcome.setText("They welcomed you into the camp and gave you enough supplies to last through the remaining journey.");
                    }
                    else if (bringLighter && page == 11) {
                        txtOutcome.setText("After gathering and preparing your supplies, you continued your journey");
                    }
                    else if (bringLighter && page == 12) {
                        startActivity(third_Night);
                    }
                }



                break;
        }
    }
}