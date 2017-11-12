package com.studios.javio.dahomeykid.urpanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    TextView mDisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        mDisplayText = findViewById(R.id.tv_display);

        Intent intentThatStartedActivity = getIntent();

        if (intentThatStartedActivity.hasExtra(Intent.EXTRA_TEXT)){
            String textEntered = intentThatStartedActivity.getStringExtra(Intent.EXTRA_TEXT);

            mDisplayText.setText(textEntered);
        }
    }
}
