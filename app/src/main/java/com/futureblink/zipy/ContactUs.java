package com.futureblink.zipy;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment implements View.OnClickListener {
    TextView mZipyMail, mZipyCall;
    public ContactUs() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact_us, container, false);
        mZipyMail = (TextView) v.findViewById(R.id.zipyEmail);
        mZipyCall = (TextView) v.findViewById(R.id.zipyCall);
        mZipyCall.setOnClickListener(this);
        mZipyMail.setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.zipyCall)
        {
            String number = "tel:"+mZipyCall.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
            intent.putExtra(Intent.EXTRA_PHONE_NUMBER, number);
            Intent chosenIntent = Intent.createChooser(intent, "Call using...");
            chosenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(chosenIntent);
        }
        else if (v.getId() == R.id.zipyEmail)
        {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",mZipyMail.getText().toString(), null));
            emailIntent.putExtra(Intent.EXTRA_TEXT, "\n\n\nSent via Zipy Rides App");
            Intent chosenIntent = Intent.createChooser(emailIntent, "Send Email via...");
            chosenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(chosenIntent);
        }
    }
}
