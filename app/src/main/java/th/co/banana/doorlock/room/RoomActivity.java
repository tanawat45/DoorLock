package th.co.banana.doorlock.room;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
                    .add(R.id.content_container_body, MainFragment.newInstance())
                    .commit();
        }

        initInstance();
    }

    private void initInstance() {

        toolbar = findViewById(R.id.toolbar);

        setToolBar();


    }

    private void setToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Room1");
    }
}
