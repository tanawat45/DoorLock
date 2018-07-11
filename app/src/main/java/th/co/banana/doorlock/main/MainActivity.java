package th.co.banana.doorlock.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.OnClick;
import th.co.banana.doorlock.R;
import th.co.banana.doorlock.login.LoginActivity;
import th.co.banana.doorlock.room.RoomActivity;

public class MainActivity extends AppCompatActivity{

    Toolbar toolbar;
    MainAdapter adapter;
    RecyclerView rvRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container_body, MainFragment.newInstance())
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
    }

    private void setToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("เลือกห้อง");
    }

}
