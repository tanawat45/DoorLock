package th.co.banana.doorlock.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import th.co.banana.doorlock.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        if (savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.content_container_body, MainFragment.)
//                    .commit();
        }
    }
}
