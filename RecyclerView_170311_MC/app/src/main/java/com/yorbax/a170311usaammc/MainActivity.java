package com.yorbax.a170311usaammc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RVClickDelListener {
    List<DaysModel> list = new ArrayList<>();
    DayRVAdapter adapter;
    RecyclerView rvDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvDays = findViewById(R.id.rv_days);
        setUpList();
        setUpAdapter();
    }

    private void setUpAdapter() {
        adapter = new DayRVAdapter(this, list);
        rvDays.setAdapter(adapter);
    }

    private void setUpList() {
        Calendar c = Calendar.getInstance();
        list.add(new DaysModel("Monday", "this is some description"));
        list.add(new DaysModel("Tuesday", "this is some description"));
        list.add(new DaysModel("Wednesday", "this is some description"));
        list.add(new DaysModel("Thursday", "this is some description"));
        list.add(new DaysModel("Friday", "this is some description"));
        list.add(new DaysModel("Saturday", "this is some description"));
        list.add(new DaysModel("Sunday", "this is some description"));
    }

    @Override
    public void onItemDelete(int position, Object item) {
        adapter.deleteItem(position);
    }
}