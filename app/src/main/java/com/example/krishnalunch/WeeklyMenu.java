package com.example.krishnalunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;

import java.util.Calendar;


public class WeeklyMenu extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    String[] items = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    public String monday = "Rice\n" +
            "Chickpeas & Potatoes in Tomato Masala\n" +
            "Salad + Almond Dressing\n" +
            "Apple Cinnamon Halava (Dessert)\n" +
            "Tea";
    public String tuesday = "Rice\n" +
            "Eggplant with Kofta (Veggie) Balls\n" +
            "Salad + Almond Dressing\n" +
            "Banana cream Halava (Dessert)\n" +
            "Tea";
    public String wednesday = "Penne Pasta with Chunky Tomato Sauce\n" +
            "Corn Chips\n" +
            "Salad + Almond Dressing\n" +
            "Pumpkin Spice Halava (Dessert)\n" +
            "Tea";
    public String thursday = "Rice\n" +
            "Mung (Lentil) Soup\n" +
            "Thai Coconut Curry\n" +
            "Salad + Almond Dressing\n" +
            "Pineapple Coconut Halava (Dessert)\n" +
            "Tea";
    public String friday = "Rice\n" +
            "Chili\n" +
            "Gauranga Potatoes (Creamy Potatoes)\n" +
            "Salad + Almond Dressing\n" +
            "Carob Halava (Dessert)\n" +
            "Tea";

    TextView menuText;
    Spinner dropdown;

    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekly_menu);

        menuText=(TextView)findViewById(R.id.textViewMenu);
        dropdown =(Spinner) findViewById(R.id.spinner);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        //set spinner based on day
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.MONDAY:
                // Current day is Monday
                dropdown.setSelection(adapter.getPosition("Monday"));
                break;
            case Calendar.TUESDAY:
                dropdown.setSelection(adapter.getPosition("Tuesday"));

                break;
            case Calendar.WEDNESDAY:
                dropdown.setSelection(adapter.getPosition("Wednesday"));

                break;
            case Calendar.THURSDAY:
                dropdown.setSelection(adapter.getPosition("Thursday"));

                break;
            case Calendar.FRIDAY:
                dropdown.setSelection(adapter.getPosition("Friday"));
                break;
        }

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String text = dropdown.getSelectedItem().toString();


                switch (text) {
                    case "Monday":
                        // Current day is Monday
                        menuText.setText(monday);
                        break;
                    case "Tuesday":
                        menuText.setText(tuesday);
                        break;
                    case "Wednesday":
                        menuText.setText(wednesday);
                        break;
                    case "Thursday":
                        menuText.setText(thursday);
                        break;
                    case "Friday":
                        menuText.setText(friday);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {


            }
        });

    }//onCreate

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}
