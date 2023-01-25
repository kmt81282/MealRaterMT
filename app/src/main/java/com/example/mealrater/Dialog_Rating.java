package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.fragment.app.DialogFragment;


public class Dialog_Rating extends DialogFragment {


    float rBarSelected;

    public interface SaveRatingBarListener {        //communicates back to mainActivity
        void didFinishRatingBar(float results);
    }

    public Dialog_Rating() {
        //empty constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  //inflater to the main window
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.star_rating, container);  //connect to dialog (layout) xml
        getDialog().setTitle("Rating");

        Button saveBttn = view.findViewById(R.id.saveButton);
        saveBttn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                RatingBar rb = view.findViewById(R.id.ratingBar);
                float rbValue = rb.getRating();
                saveItem(rbValue);         //Referring to the method before creation
            }
        });
        return view;
    }
        private void saveItem(float selectedRating) {
            SaveRatingBarListener activity = (SaveRatingBarListener) getActivity();  //Created method used above
            activity.didFinishRatingBar(selectedRating);
            getDialog().dismiss();
        }

}


