package com.example.krishnalunch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class LineLength extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_length);

        GraphView bar_Graph = (GraphView) findViewById(R.id.bar_graph);

        BarGraphSeries<DataPoint> barGraph_Data = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(11, 1),
                new DataPoint("11:30", 5),
                new DataPoint(12, 3),
                new DataPoint(12:30, 2),
                new DataPoint(1, 6),
                new DataPoint(1:30, 6)
        });
        bar_Graph.addSeries(barGraph_Data);
    }
}
