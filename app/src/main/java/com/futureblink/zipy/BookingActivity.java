package com.futureblink.zipy;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BookingActivity extends Fragment implements View.OnClickListener{
    int scooterCount,bikeCount;
    Button mMinusButtonScooter, mMinusButtonBike, mPlusButtonScooter, mPlusButtonBike, mNext;
    TextView mScooterCounter, mBikeCounter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           View v =  inflater.inflate(R.layout.activity_booking, container, false);
        scooterCount = 0;
        bikeCount = 0;
        mNext = (Button) v.findViewById(R.id.nextButton);
        mMinusButtonScooter = (Button) v.findViewById(R.id.minusButtonScooter);
        mPlusButtonScooter = (Button) v.findViewById(R.id.plusButtonScooter);
        mScooterCounter = (TextView) v.findViewById(R.id.scooterCounter);
        mMinusButtonBike = (Button) v.findViewById(R.id.minusButtonBike);
        mPlusButtonBike = (Button) v.findViewById(R.id.plusButtonBike);
        mBikeCounter = (TextView) v.findViewById(R.id.bikeCounter);
        mMinusButtonScooter.setOnClickListener(this);
        mPlusButtonBike.setOnClickListener(this);
        mMinusButtonBike.setOnClickListener(this);
        mPlusButtonScooter.setOnClickListener(this);
        mNext.setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View v) {
        mMinusButtonScooter.setEnabled(true);
        mMinusButtonBike.setEnabled(true);
        switch (v.getId())
        {
            case R.id.minusButtonScooter:
                if (scooterCount < 1) {
                    mMinusButtonScooter.setEnabled(false);
                }
                else if (scooterCount >= 1)
                {
                    mMinusButtonScooter.setEnabled(true);
                    scooterCount--;
                }
                break;
            case R.id.plusButtonScooter:
                scooterCount++;
                break;
            case R.id.minusButtonBike:
                if (bikeCount < 1) {
                    mMinusButtonBike.setEnabled(false);
                }
                else if (bikeCount >= 1)
                {
                    mMinusButtonBike.setEnabled(true);
                    bikeCount--;
                }
                break;
            case R.id.plusButtonBike:
                bikeCount++;
                break;
            case R.id.nextButton:
                Intent myIntent = new Intent(getContext(), DetailsActivity.class);
                startActivity(myIntent);

        }
        mBikeCounter.setText(String.format("%d", bikeCount));
        mScooterCounter.setText(String.format("%d", scooterCount));
    }
}
