package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.fragment.app.DialogFragment;

public class RatingSelection extends DialogFragment {

    RatingBar selectedRating;

    public interface SaveRatingListener {
        void didSaveRatingDialog(RatingBar starsSelected);
    }

    public RatingSelection() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.star_rating, container);
        selectedRating.getRating();
        final RatingBar rb = view.findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                selectedRating.setRating(v);
            }
        });

        Button saveButton = view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveItem(selectedRating);
            }
        });
        return view;
    }

    private void saveItem(RatingBar starsSelected) {
        SaveRatingListener activity = (SaveRatingListener) getActivity();
        activity.didSaveRatingDialog(starsSelected);
        getDialog().dismiss();
    }


}
