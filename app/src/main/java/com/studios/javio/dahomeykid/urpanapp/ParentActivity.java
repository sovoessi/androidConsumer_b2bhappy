package com.studios.javio.dahomeykid.urpanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ParentActivity extends AppCompatActivity {

    private EditText mNameEntry;
    private Button mDoSomethingCollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        mDoSomethingCollButton = findViewById(R.id.b_do_something);
        mNameEntry = findViewById(R.id.et_text_entry);

        mDoSomethingCollButton.setOnClickListener((v) -> {

            String enteredText = mNameEntry.getText().toString();

            Intent intent = new Intent(ParentActivity.this, ChildActivity.class);

            intent.putExtra(Intent.EXTRA_TEXT, enteredText);

            startActivity(intent);
        });
    }
}
