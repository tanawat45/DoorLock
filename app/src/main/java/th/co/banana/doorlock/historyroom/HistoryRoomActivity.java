package th.co.banana.doorlock.historyroom;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import th.co.banana.doorlock.R;
import th.co.banana.doorlock.register.RegisterFragment;


public class HistoryRoomActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_room);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container_body, HistoryRoomFragment.newInstance())
                    .commit();
        }
        initInstance();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initInstance() {
        toolbar = findViewById(R.id.toolbar);
        setToolBar();

        DialogFragment newFragment = new HistoryDate();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    private void setToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("ประวัติการเข้าห้อง");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new HistoryDate();
        newFragment.show(getFragmentManager(), "datePicker");
    }
}
