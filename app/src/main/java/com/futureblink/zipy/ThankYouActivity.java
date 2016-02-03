package com.futureblink.zipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThankYouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.previous_slide_in, R.anim.previous_slide_out);
    }
    public void goToHome(View view)
    {
        Intent myIntent = new Intent(this, NavDrawerActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.next_slide_in, R.anim.next_slide_out);
    }
}
