package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PrologueStory2 extends AppCompatActivity implements View.OnClickListener{

    int prologue2Page = 1;
    boolean bringLighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_story_2);

        bringLighter = getIntent().getBooleanExtra("BROUGHT_LIGHTER", true);

        Button prologue2Next = findViewById(R.id.btnNxt_PrologueStory2);
        prologue2Next.setOnClickListener(this);


    }

    @Override
    public void onClick (View view) {

        TextView prologue2Txt = findViewById(R.id.txt_PrologueStory2);
        Intent next = new Intent(PrologueStory2.this, PrologueDecision2.class);

        switch (view.getId()) {
            case R.id.btnNxt_PrologueStory2:
                if (prologue2Page == 1 ) {
                    prologue2Txt.setText("Nearing the exit, you approach the tunnel guard.");
                    prologue2Page++;
                }
                else if (prologue2Page == 2) {
                    next.putExtra("BROUGHT_LIGHTER", bringLighter);
                    startActivity(next);
                }
                break;
        }

    }

}