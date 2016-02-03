package com.futureblink.zipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.previous_slide_in, R.anim.previous_slide_out);
    }
    public void goToSignIn(View view)
    {
        Intent myIntent = new Intent(RegisterActivity.this, SignInActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.next_slide_in, R.anim.next_slide_out);
    }
}
