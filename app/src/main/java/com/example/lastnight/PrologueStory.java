package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrologueStory extends AppCompatActivity implements View.OnClickListener{

    int prologuePage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_story);

        Button btnNext = findViewById(R.id.btnNext_PrologueStory);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick (View view) {

        TextView prologueStory = findViewById(R.id.txt_PrologueStory);
        Intent next = new Intent(PrologueStory.this, PrologueDecision.class);

        switch (view.getId()) {
            case R.id.btnNext_PrologueStory:
                if (prologuePage == 1) {
                    prologueStory.setText("She was supposed to be gone for only 3 days.");
                    prologuePage++;
                }
                else if (prologuePage == 2) {
                    prologueStory.setText("But, she has been gone for over a week now and have not heard from her since.");
                    prologuePage++;
                }
                else if (prologuePage == 3) {
                    prologueStory.setText("Worried, you set out to find her yourself.");
                    prologuePage++;
                }
                else if (prologuePage == 4) {
                    prologueStory.setText("While preparing for the journey, you were deciding on whether or not to make space on your bag to bring an already used lighter.");
                    prologuePage++;
                }
                else if (prologuePage == 5 ) {
                    startActivity(next);
                }
                break;
        }

    }

}