package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Food extends AppCompatActivity implements View.OnClickListener{

    TextView txtStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Button btnNext = findViewById(R.id.btnNext_Food);
        btnNext.setOnClickListener(this);
        txtStory = findViewById(R.id.txt_Food);

        txtStory.setText("The man that you gave food to during 'Second Night' was able to save his daughter from starvation.");
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