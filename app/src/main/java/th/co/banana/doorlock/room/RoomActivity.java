package th.co.banana.doorlock.room;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import th.co.banana.doorlock.R;
import th.co.banana.doorlock.main.MainFragment;

public class RoomActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container_body, RoomFragment.newInstance())
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
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle(name);
    }
}
