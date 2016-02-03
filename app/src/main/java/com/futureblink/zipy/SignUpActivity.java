package com.futureblink.zipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText mPhone;
    String phoneNo;
    boolean proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mPhone = (EditText) findViewById(R.id.phoneNumber);
        proceed = false;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.previous_slide_in, R.anim.previous_slide_out);
    }
    public void onClick(View view)
    {
//        if(proceed) {
            Intent myIntent = new Intent(this, PasswordActivity.class);
            startActivity(myIntent);
            overridePendingTransition(R.anim.next_slide_in, R.anim.next_slide_out);
//        }
//        else
//        {
//            Toast.makeText(SignUpActivity.this, "Please check your phone number and OTP", Toast.LENGTH_SHORT).show();
//        }
    }
    public void checkLength(View view) {
        if(mPhone.getText().toString().length() == 10) {
            Toast.makeText(SignUpActivity.this, "Sending OTP...", Toast.LENGTH_SHORT).show();
            proceed = true;
        }
        else {
            Toast.makeText(SignUpActivity.this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
            proceed = false;
        }
    }
}
