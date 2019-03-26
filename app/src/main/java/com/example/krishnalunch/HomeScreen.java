package com.example.krishnalunch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    TextView counter;
    Button BuyMore;
    FloatingActionButton redeem;
    int count = 0;

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.BuyMore:
                    addTicket();
                    break;
                case R.id.redeem:
                    redeemTicket();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //Toolbar toolbar = findViewById(R.id.toolbar2);
        //setSupportActionBar(toolbar);

        counter = findViewById(R.id.counter);
        initCount();
        BuyMore = findViewById(R.id.BuyMore);
        BuyMore.setOnClickListener(listener);

        FloatingActionButton fab = findViewById(R.id.redeem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redeemTicket();
            }
        });
    }

    private void initCount(){
        // Note: should pull ticket number from account/db here
        count = 0;
        counter.setText(String.valueOf(count));
    }

    private void addTicket(){
        count++;
        counter.setText(String.valueOf(count));
    }

    private void redeemTicket(){
        if (count > 0)
            count--;
        counter.setText(String.valueOf(count));
    }

}
