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

public class Guard extends AppCompatActivity implements View.OnClickListener{

    boolean giveFood;
    int page = 1;
    TextView txtStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guard);

        giveFood = getIntent().getBooleanExtra("GIVE_FOOD", true);

        Button btnNext = findViewById(R.id.btnNext_Guard);
        ConstraintLayout guardBG = findViewById(R.id.guardBG);
        GifImageView guardFriend = findViewById(R.id.guardFriend);
        btnNext.setOnClickListener(this);
        txtStory = findViewById(R.id.txt_Guard);

        txtStory.setText("When you arrived home, the guard greeted you.");
        guardBG.setBackgroundColor(Color.parseColor("#000000"));
        guardFriend.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick (View view) {

        Intent food = new Intent(this, Food.class);
        Intent credits = new Intent(this, Credits.class);

        switch (view.getId()) {
            case R.id.btnNext_Guard:

                page++;
                if (page == 2) {
                    txtStory.setText("He notices the sadness in your face.");
                }
                else if (page == 3) {
                    txtStory.setText("He consoles you and attempts to cheer you up.");
                }
                else if (page == 4) {
                    txtStory.setText("You felt somewhat better.");
                }
                else if (page == 5) {
                    if (giveFood == true) {
                        startActivity(food);
                    }
                    else {
                        startActivity(credits);
                    }
                }
                break;
        }
    }
}