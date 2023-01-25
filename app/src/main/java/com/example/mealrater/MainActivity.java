package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements Dialog_Rating.SaveRatingBarListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRateMealButton();



    }

    @Override
    public void didFinishRatingBar(float selectedRating) {
        TextView rating = findViewById(R.id.rating);
        rating.setText(String.valueOf(selectedRating));

    }

    private void initRateMealButton() {
        Button rateButton = findViewById(R.id.rateMeal);
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                Dialog_Rating ratingDialog = new Dialog_Rating();
                ratingDialog.show(fm, "RatingPick");
            }
        });

    }


}
