package com.studios.javio.dahomeykid.urpanapp;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.studios.javio.dahomeykid.urpanapp.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText mCompanySearchEditBox;

    TextView mUrlDisplayTextView;

    TextView searchResultsTextView;

    TextView mErrorMessageDisplay;

    ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mCompanySearchEditBox = findViewById(R.id.company_search_box);

        mUrlDisplayTextView = findViewById(R.id.company_search_results);

        searchResultsTextView = findViewById(R.id.search_results_json);

        mErrorMessageDisplay = findViewById(R.id.company_error_message_display);
        mLoadingIndicator = findViewById(R.id.pb_loading_indicator);

    }

    private void makeCompanySearchQuery(){
        String companyQuery = mCompanySearchEditBox.getText().toString();
        URL companySearchUrl = NetworkUtils.buildUrl(companyQuery);

        mUrlDisplayTextView.setText(companySearchUrl.toString());

        new CompanySearchTask().execute(companySearchUrl);

    }


    private void showJSONDataView(){
        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        searchResultsTextView.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage(){
        searchResultsTextView.setVisibility(View.INVISIBLE);
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
    }


    public class CompanySearchTask extends AsyncTask<URL, Void, String > {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String companySearchResults = null;
            try{
                companySearchResults  = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            }catch (IOException e){
                e.printStackTrace();
            }
            return companySearchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            if(s != null && !s.equals("")){
                showJSONDataView();
                searchResultsTextView.setText(s);
            }else{
                showErrorMessage();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemThatWasSelected = item.getItemId();
        if(menuItemThatWasSelected == R.id.action_search){
          /*  Context context = MainActivity.this;
            String message = "Search clicked";
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
           */
          makeCompanySearchQuery();
          return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
