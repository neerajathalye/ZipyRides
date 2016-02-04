package com.futureblink.zipy;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class DetailsActivity extends AppCompatActivity {
    TextView mDate, mTime;
    String date, time;
    Switch mHomeSwitch;
    EditText mAddressBox;
    static int dayCheck;
    static boolean timeCheck;// if timeCheck is false -> don't go to next screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        mHomeSwitch = (Switch) findViewById(R.id.homeSwitch);
        mAddressBox = (EditText) findViewById(R.id.addressBox);
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        dayCheck = day;
        timeCheck = false;
        if(day < 10 && (month+1) > 10)
            date = "0"+day+"/"+(month+1)+"/"+year;
        else if(day > 10 && (month+1) < 10)
            date = day+"/0"+(month+1)+"/"+year;
        else if(day < 10 && (month+1) < 10)
            date = "0"+day+"/0"+(month+1)+"/"+year;
        else
            date = day+"/"+(month+1)+"/"+year;
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        if(minute < 10 && hour > 10)
            time = hour+":0"+minute;
        else if(minute > 10 && hour < 10)
            time = "0"+hour+":"+minute;
        else if(minute < 10 && hour < 10)
            time = "0"+hour+":0"+minute;
        else
            time = hour+":"+minute;
        mDate = (TextView) findViewById(R.id.date);
        mTime = (TextView) findViewById(R.id.time);
        mTime.setText(time);
        mDate.setText(date);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.hours, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        mAddressBox.setText("Home Address");
        mAddressBox.setEnabled(false);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.previous_slide_in, R.anim.previous_slide_out);
    }
    public void pickTime(View view) {
        DialogFragment newFragment1 = new TimePickerFragment();
        newFragment1.show(getSupportFragmentManager(), "timePicker");
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public void pickDate(View view) {
        DialogFragment newFragment1 = new TimePickerFragment();
        newFragment1.show(getSupportFragmentManager(), "timePicker");
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void homeAddressSwitch(View view)
    {
        if (mHomeSwitch.isChecked())
        {
            mAddressBox.setText("Home Address");
            mAddressBox.setEnabled(false);
        }
        else
        {
            mAddressBox.setEnabled(true);
            mAddressBox.clearComposingText();
        }
    }

    public void goToConfirmation(View view) {
        String message = "Ride time needs to be at least 10 minutes from now";
        if(!timeCheck)
            Toast.makeText(this, message , Toast.LENGTH_SHORT).show();
        else {
            Intent myIntent = new Intent(this, ThankYouActivity.class);
            startActivity(myIntent);
            overridePendingTransition(R.anim.next_slide_in, R.anim.next_slide_out);
        }
    }
    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        public String time;
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            final Calendar c = Calendar.getInstance();
            int currentHour = c.get(Calendar.HOUR_OF_DAY);
            int currentMinute = c.get(Calendar.MINUTE);
            int currentDay = c.get(Calendar.DAY_OF_MONTH);
            int currentTime = (currentHour*60)+currentMinute;
            int time1 = (hourOfDay*60)+minute;
            String message = "Ride time needs to be at least 10 minutes from now";
            if(currentDay == dayCheck) {
                if ((time1 - 10) <= currentTime) {
                    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                    timeCheck = false;
                } else {
                    timeCheck = true;
                }
            }
            else {
                timeCheck = true;
            }
//            Toast.makeText(getActivity(), "tC: "+timeCheck, Toast.LENGTH_SHORT).show();
            TextView mTime = (TextView) getActivity().findViewById(R.id.time);
            if(minute < 10 && hourOfDay > 10)
                time = hourOfDay+":0"+minute;
            else if(minute > 10 && hourOfDay < 10)
                time = "0"+hourOfDay+":"+minute;
            else if(minute < 10 && hourOfDay < 10)
                time = "0"+hourOfDay+":0"+minute;
            else
                time = hourOfDay+":"+minute;
            mTime.setText(time);
        }
    }
    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            Calendar weekBackDate=Calendar.getInstance();
            weekBackDate.add(Calendar.DAY_OF_MONTH,10);
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            datePickerDialog.getDatePicker().setMaxDate(weekBackDate.getTimeInMillis());

            // Create a new instance of DatePickerDialog and return it
            return datePickerDialog;
        }
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            dayCheck = day;
            TextView mDate = (TextView) getActivity().findViewById(R.id.date);
            String date;
            if(day < 10 && (month+1) > 10)
                date = "0"+day+"/"+(month+1)+"/"+year;
            else if(day > 10 && (month+1) < 10)
                date = day+"/0"+(month+1)+"/"+year;
            else if(day < 10 && (month+1) < 10)
                date = "0"+day+"/0"+(month+1)+"/"+year;
            else
                date = day+"/"+(month+1)+"/"+year;
            mDate.setText(date);
        }
    }
}
