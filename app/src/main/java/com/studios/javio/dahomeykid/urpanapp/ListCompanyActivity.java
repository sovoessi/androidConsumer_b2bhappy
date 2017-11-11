package com.studios.javio.dahomeykid.urpanapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.studios.javio.dahomeykid.urpanapp.utilities.CompanyAdapter;

public class ListCompanyActivity extends AppCompatActivity {

    private static final int NUM_LIST_ITEMS = 100;

    private CompanyAdapter mAdapter;
    private RecyclerView mNumbersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_company);

        mNumbersList = (RecyclerView) findViewById(R.id.rv_companies);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);

         /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        mNumbersList.setHasFixedSize(true);

        /*
         * The CompanyAdapter is responsible for displaying each item in the list.
         */
        mAdapter = new CompanyAdapter(NUM_LIST_ITEMS);
        mNumbersList.setAdapter(mAdapter);

    }
}
