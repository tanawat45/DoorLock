package th.co.banana.doorlock.history;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shrikanthravi.collapsiblecalendarview.data.Day;
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

import th.co.banana.doorlock.R;

public class HistoryActivity extends AppCompatActivity implements HistoryAdapter.MainAdapterListenner{

    Toolbar toolbar;
    TextView tvDate;
    Day day;
    CollapsibleCalendar collapsibleCalendar;
    RecyclerView recyclerView;

    public HistoryAdapter adapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

//        final Calendar today=new GregorianCalendar();
//        today.add(Calendar.DATE,1);
//        collapsibleCalendar.addEventTag(today.get(Calendar.YEAR),today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH));
//        collapsibleCalendar.addEventTag(today.get(Calendar.YEAR),today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH),Color.BLUE);
        tvDate = findViewById(R.id.tv_date);
        collapsibleCalendar = findViewById(R.id.calendarView);
        day = collapsibleCalendar.getSelectedDay();
        tvDate.setText(day.getDay() + "/" + (day.getMonth() + 1) + "/" + day.getYear());
        calendarCollapsible();
        initInstance();
        setRecycle();
    }

    private void calendarCollapsible() {

        collapsibleCalendar.setCalendarListener(new CollapsibleCalendar.CalendarListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDaySelect() {
                day = collapsibleCalendar.getSelectedDay();
                tvDate.setText(day.getDay() + "/" + (day.getMonth() + 1) + "/" + day.getYear());
            }

            @Override
            public void onItemClick(View view) {

            }

            @Override
            public void onDataUpdate() {

            }

            @Override
            public void onMonthChange() {

            }

            @Override
            public void onWeekChange(int i) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initInstance() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("History");

    }

    public void setRecycle(){
        recyclerView = findViewById(R.id.rv_name);
        adapter = new HistoryAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void clickRoom() {

    }
}
