package com.example.krishnalunch;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.NumberPicker;
import java.util.Calendar;

public class HomeScreen extends AppCompatActivity {

    Context context = this;
    TextView counter;
    Button BuyMore;
    Button Menu;
    Button WaitTimes;
    ImageButton account;
    FloatingActionButton redeem;
    int count = 0;

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.BuyMore:
                    AlertDialog.Builder addBuilder = new AlertDialog.Builder(context);
                    final NumberPicker numberPicker = new NumberPicker(context);
                    numberPicker.setMinValue(1);
                    numberPicker.setMaxValue(20);
                    addBuilder.setCancelable(true);
                    addBuilder.setView(numberPicker);
                    addBuilder.setTitle("Buy More Tickets");
                    addBuilder.setMessage("Are you sure you'd like to buy a ticket?");
                    addBuilder.setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    addTicket(numberPicker.getValue());
                                }
                            });
                    addBuilder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    AlertDialog addDialog = addBuilder.create();
                    addDialog.show();
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
        Menu = findViewById(R.id.Menu);
        account = findViewById(R.id.account);
        WaitTimes = findViewById(R.id.WaitTimes);
        BuyMore.setOnClickListener(listener);

        redeem = findViewById(R.id.redeem);
        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder redeemBuilder = new AlertDialog.Builder(context);
                redeemBuilder.setCancelable(true);
                redeemBuilder.setTitle("Redeem Ticket");
                redeemBuilder.setMessage("Are you sure you want to redeem a ticket? This action can't be undone.");
                redeemBuilder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                redeemTicket();
                            }
                        });
                redeemBuilder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog redeemDialog = redeemBuilder.create();
                redeemDialog.show();
            }
        });
        Menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeeklyMenu.class);
                startActivity(intent);
            }
        });
        WaitTimes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LineLength.class);
                startActivity(intent);
            }
        });
        account.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Account.class);
                startActivity(intent);
            }
        });
    }

    private void initCount(){
        // Note: should pull ticket number from account/db here
        count = 0;
        counter.setText(String.valueOf(count));
    }

    private void addTicket(int quantity){
        count += quantity;
        counter.setText(String.valueOf(count));
    }

    private void redeemTicket(){
        if (count > 0) {
            count--;
            AlertDialog.Builder redeemBuilder = new AlertDialog.Builder(context);
            redeemBuilder.setCancelable(true);
            redeemBuilder.setTitle("Ticket Redeemed on: " + Calendar.getInstance().getTime());
            redeemBuilder.setMessage("Show this screen to an attendant to get your plate!");
            redeemBuilder.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

            AlertDialog redeemDialog = redeemBuilder.create();
            redeemDialog.show();
        }
        else {
            AlertDialog.Builder redeemBuilder = new AlertDialog.Builder(context);
            redeemBuilder.setCancelable(true);
            redeemBuilder.setTitle("No tickets available");
            redeemBuilder.setMessage("You do not have any tickets to redeem. :( You can buy more by clicking the button on the home screen!");
            redeemBuilder.setPositiveButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

            AlertDialog redeemDialog = redeemBuilder.create();
            redeemDialog.show();
        }
        counter.setText(String.valueOf(count));
    }
}