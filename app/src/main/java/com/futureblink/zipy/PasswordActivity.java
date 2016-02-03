package com.futureblink.zipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {
    String pw, cpw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.previous_slide_in, R.anim.previous_slide_out);
    }

    public void passwordConfirm(View view)
    {
        EditText mPassword, mConfirmPassword;
        mPassword = (EditText) findViewById(R.id.password);
        mConfirmPassword = (EditText) findViewById(R.id.confirm_password);
        pw = mPassword.getText().toString();
        cpw = mConfirmPassword.getText().toString();
        if (pw.equals("")) {
            Toast.makeText(PasswordActivity.this, "Please Enter A Password", Toast.LENGTH_SHORT).show();
        } else {
            if (pw.equals(cpw)) {
                Intent myIntent = new Intent(this, RegisterActivity.class);
                startActivity(myIntent);
                overridePendingTransition(R.anim.next_slide_in, R.anim.next_slide_out);
            } else {
                Toast.makeText(PasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                mPassword.setText("");
                mConfirmPassword.setText("");
            }
        }
    }
}
