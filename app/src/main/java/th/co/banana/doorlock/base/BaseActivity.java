package th.co.banana.doorlock.base;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public abstract class BaseActivity extends AppCompatActivity {

    public void addFragment(int containerId, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void replaceFragmentAddBackStack(int containerId, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(String.valueOf(getSupportFragmentManager().getBackStackEntryCount() + 1))
                .commit();
    }

    public void replaceFragment(int containerId, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    public void removeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .remove(fragment)
                .commit();
    }

    public void back() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    public void backToMain() {
        finish();
    }

    public void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
