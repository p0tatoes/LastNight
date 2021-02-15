package com.example.lastnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondNightStory extends AppCompatActivity implements View.OnClickListener{

    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_night_story);

        Button btnNext = findViewById(R.id.btnNext_SecondNightStory);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {

        Intent next = new Intent(this, SecondNightDecision.class);
        TextView txtStory = findViewById(R.id.txtStory_SecondNigtStory);

        switch (v.getId()) {
            case R.id.btnNext_SecondNightStory:
                if (page == 1) {
                    txtStory.setText("Along the way, you encountered a man.");
                    page++;
                }
                else if (page == 2) {
                    txtStory.setText("The man approaches you.");
                    page++;
                }
                else if (page == 3) {
                    txtStory.setText("He says that he means you no harm and asks for food.");
                    page++;
                }
                else if (page == 4) {
                    txtStory.setText("You look inside your bag to see that there is not enough food left.");
                    page++;
                }
                else {
                    startActivity(next);
                }
                break;
        }
    }
}