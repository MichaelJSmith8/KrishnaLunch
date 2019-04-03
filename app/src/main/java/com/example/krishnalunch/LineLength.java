package com.example.krishnalunch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class LineLength extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_length);

        GraphView bar_Graph = (GraphView) findViewById(R.id.bar_graph);

        BarGraphSeries<DataPoint> barGraph_Data = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(1, 1),
                new DataPoint(2, 5),
                new DataPoint(3, 3),
                new DataPoint(4, 2),
                new DataPoint(5, 6),
                new DataPoint(6, 6)
        });
        bar_Graph.addSeries(barGraph_Data);



        //set scale
        bar_Graph.getViewport().setMinX(0);
        bar_Graph.getViewport().setMaxX(7);
        bar_Graph.getViewport().setMinY(0);

        bar_Graph.getViewport().setYAxisBoundsManual(true);
        bar_Graph.getViewport().setXAxisBoundsManual(true);

        GridLabelRenderer gridLabel = bar_Graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("Time");
        gridLabel.setVerticalAxisTitle("Ticket Redemptions");

        gridLabel.setPadding(50);

        //space bars
        barGraph_Data.setSpacing(20);

        // GraphView 4.x
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(bar_Graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"","11", "11:30","12", "12:30", "1", "1:30",""});
//        staticLabelsFormatter.setVerticalLabels(new String[] {"low", "middle", "high"});
        bar_Graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

    }
}
