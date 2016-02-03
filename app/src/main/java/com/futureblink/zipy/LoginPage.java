package com.futureblink.zipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginPage extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }
    public void onClick(View v) {
        if(v.getId() == R.id.signUpButton)
        {
            Intent myIntent = new Intent(LoginPage.this, SignUpActivity.class);
            startActivity(myIntent);
            overridePendingTransition(R.anim.next_slide_in, R.anim.next_slide_out);
        }
        else if(v.getId() == R.id.signInButton)
        {
            Intent myIntent = new Intent(LoginPage.this, SignInActivity.class);
            startActivity(myIntent);
            overridePendingTransition(R.anim.next_slide_in, R.anim.next_slide_out);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.previous_slide_in, R.anim.previous_slide_out);
    }
}
