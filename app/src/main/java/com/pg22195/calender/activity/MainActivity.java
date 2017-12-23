package com.pg22195.calender.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.pg22195.calender.interfaces.ExtremePositionListener;
import com.pg22195.calender.module_cell.Cell;
import com.pg22195.calender.R;
import com.pg22195.calender.adapter.CalenderAdapter;
import com.pg22195.calender.util.DateTimeParser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private List<Cell> cellsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CalenderAdapter mAdapter;
    private LinearLayout container;
    private Handler handler = new Handler();
    Runnable runnable;
    Integer containerWidth;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (LinearLayout)findViewById(R.id.container);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new CalenderAdapter(cellsList);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        runnable = new Runnable() {
            @Override
            public void run() {
                Log.e("width ", container.getWidth() + "");
                containerWidth = container.getWidth();
            }
        };
        container.post(runnable);
        prepareMovieData();
        setAdapterListener();
    }



    void prepareMovieData () {
        Calendar mycal = new GregorianCalendar();
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
//        for(int  i =0 ;i< 10; i++) {
//            Calendar cal = Calendar.getInstance();
//            cal.setTime ( new Date() ); // convert your date to Calendar object
//            int daysToIncrement = i;
//            cal.add(Calendar.DATE, daysToIncrement);
//            Cell cell = new Cell(cal.getTime(), cal.getTime());
//            cell.setText(DateTimeParser.calenderFormat(cell.getStartTime()));
//            cellsList.add(cell);
//        }
//        Cell cell = new Cell(new Date(), new Date());
//        cell.setText(DateTimeParser.calenderFormat(cell.getStartTime()));
//        cellsList.add(0,cell);

        for(int  i =1 ;i< 10; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime ( new Date() ); // convert your date to Calendar object
            int daysToDecrement = -i;
            cal.add(Calendar.DATE, daysToDecrement);
            Cell cell = new Cell(cal.getTime(), cal.getTime());
            cell.setText(DateTimeParser.calenderFormat(cell.getStartTime()));
            cellsList.add(0,cell);
        }
        mAdapter.notifyDataSetChanged();
    }


    public void setAdapterListener() {
        mAdapter.setAdapterListener(new ExtremePositionListener() {
            @Override
            public void onReachingTop() {
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        for(int  i =1 ;i < 10; i++) {
                            Calendar cal = Calendar.getInstance();
                            cal.setTime ( new Date() ); // convert your date to Calendar object
                            int daysToDecrement = -i;
                            cal.add(Calendar.DATE, daysToDecrement);
                            Cell cell = new Cell(cal.getTime(), cal.getTime());
                            cell.setText(DateTimeParser.calenderFormat(cell.getStartTime()));
                            cellsList.add(0,cell);
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                };
                handler.post(runnable);
            }

            @Override
            public void onReachingBottom(final Integer position) {
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        Calendar cal = Calendar.getInstance();
                        cal.setTime ( new Date() ); // convert your date to Calendar object
                        int daysToIncrement = position-8;
                        cal.add(Calendar.DATE, daysToIncrement);
                        Cell cell = new Cell(cal.getTime(), cal.getTime());
                        cell.setText(DateTimeParser.calenderFormat(cell.getStartTime()));
                        cellsList.add(cell);
                        mAdapter.notifyDataSetChanged();
                    }
                };
                handler.post(runnable);
            }
        });
    }

}
