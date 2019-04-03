package com.example.krishnalunch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class WeeklyMenu extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekly_menu);

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Spinner spinner =findViewById(R.id.spinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(
                this,
                R.array.weekday,
                R.layout.spinner_item
        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
