package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Food extends AppCompatActivity implements View.OnClickListener{

    TextView txtStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Button btnNext = findViewById(R.id.btnNext_Food);
        ConstraintLayout foodBG = findViewById(R.id.foodBG);
        GifImageView foodCan = findViewById(R.id.foodCan);
        btnNext.setOnClickListener(this);
        txtStory = findViewById(R.id.txt_Food);

        txtStory.setText("The man that you gave food to during 'Second Night' was able to save his daughter from starvation.");
        foodBG.setBackgroundColor(Color.parseColor("#000000"));
        txtStory.setTextColor(Color.parseColor("#FFFFFF"));
        foodCan.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick (View view) {

        Intent credits = new Intent(this, Credits.class);
        switch (view.getId()) {
            case R.id.btnNext_Food:
                startActivity(credits);
                break;
        }
    }
}