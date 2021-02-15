package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrologueCard extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_card);

        Button prologueNext = findViewById(R.id.btnNxt_PrologueCard);
        prologueNext.setOnClickListener(this);

    }

    @Override
    public void onClick (View v) {

        Intent next = new Intent(PrologueCard.this, PrologueStory.class);

        switch (v.getId()) {
            case R.id.btnNxt_PrologueCard:
                startActivity(next);
                break;
        }

    }

}