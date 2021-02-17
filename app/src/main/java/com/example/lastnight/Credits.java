package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Credits extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);


    }

    @Override
    public void onClick(View v) {
        Button btnNxt_TryAgain = findViewById(R.id.btnNxt_TryAgain);


        btnNxt_TryAgain.setOnClickListener(this);


        Intent i = new Intent(Credits.this, PrologueCard.class);


        switch (v.getId()) {
            case R.id.btnNxt_TryAgain:


                startActivity(i);


                break;
        }
    }
}