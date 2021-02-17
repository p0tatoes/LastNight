package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class MidnightOutcome extends AppCompatActivity implements View.OnClickListener{

    boolean bringLighter, greetGuard, giveFood, giveLighter;
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
        ConstraintLayout midOutcoBG = findViewById(R.id.midOutcoBG);
        GifImageView groupnotMove = findViewById(R.id.groupnotMove);
        GifImageView groupMove = findViewById(R.id.groupMove);

        Intent next = getIntent();

        decision_Midnight = next.getCharExtra("decision_midnight", ' ');
        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);
        greetGuard = getIntent().getBooleanExtra("GREET_GUARD", true);
        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);
        giveLighter = getIntent().getBooleanExtra("GIVE_LIGHTER", true);

        if (decision_Midnight == 'a') {
            txtOutcome.setText("You approach the campsite.");
            groupMove.setVisibility(View.INVISIBLE);
            groupnotMove.setVisibility(View.VISIBLE);
        }
        else if (decision_Midnight == 'b') {
            txtOutcome.setText("You passed by the campsite and decided to continue to the supermarket.");
            groupMove.setVisibility(View.INVISIBLE);
            groupnotMove.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick (View view) {
        GifImageView groupMove = findViewById(R.id.groupMove);


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
                        groupMove.setVisibility(View.VISIBLE);

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
                        third_Night.putExtra("GREET_GUARD", greetGuard);
                        third_Night.putExtra("GIVE_FOOD", giveFood);
                        third_Night.putExtra("GIVE_LIGHTER", giveLighter);
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
                        third_Night.putExtra("GREET_GUARD", greetGuard);
                        third_Night.putExtra("GIVE_FOOD", giveFood);
                        third_Night.putExtra("GIVE_LIGHTER", giveLighter);
                        startActivity(third_Night);
                    }
                }

                else if (decision_Midnight == 'b' && page == 2) {
                    txtOutcome.setText("After a while, you reached the market and started scavenging.");
                }
                else if (decision_Midnight == 'b' && page == 3) {
                    txtOutcome.setText("While scavenging, you notice that there is also someone else inside the market");
                }
                else if (decision_Midnight == 'b' && page == 4) {
                    txtOutcome.setText("It was the man from the previous night who asked for food.");
                }
                else if (decision_Midnight == 'b' && page == 5) {
                    txtOutcome.setText("You only managed to get little food from scavenging.");
                }
                else if (decision_Midnight == 'b' && page == 6) {
                    third_Night.putExtra("GREET_GUARD", greetGuard);
                    third_Night.putExtra("GIVE_FOOD", giveFood);
                    third_Night.putExtra("GIVE_LIGHTER", giveLighter);
                    startActivity(third_Night);
                }



                break;
        }
    }
}