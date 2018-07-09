package th.co.banana.doorlock.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseActivity;

public class LoginActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container_body, LoginFragment.newInstance())
                    .commit();
        }

        initInstance();
    }

    private void initInstance() {

    }
}
