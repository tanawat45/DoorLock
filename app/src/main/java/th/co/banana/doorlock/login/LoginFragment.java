package th.co.banana.doorlock.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseFragment;
import th.co.banana.doorlock.main.MainActivity;
import th.co.banana.doorlock.mqtt.MqttActivity;
import th.co.banana.doorlock.register.RegisterActivity;

public class LoginFragment extends BaseFragment implements LoginView {

    @BindView(R.id.ro_login_area)
    RelativeLayout ro_login_area;

    @BindView(R.id.btn_login)
    Button btn_login;

    @BindView(R.id.etUsername)
    EditText etUsername;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.tv_register)
    TextView tv_register;

    @BindView(R.id.btn_mqtt)
    Button btn_mqtt;


    LoginPresenter presenter;

    public static final String MY_PREFS_NAME = "MyPrefs";
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;


    public  LoginFragment(){
        //required empty public constructor

    }


    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){

        }

    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_login;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onViewBind() {

        presenter = new LoginPresenterImplement(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        ro_login_area.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard(v);
                return false;
            }
        });

        btn_mqtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MqttActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void hideKeyboard(View view)
    {
        InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }




    @Override
    public void showMainActivity() {

        Toast("เข้าสู่ระบบเรียนร้อย");

        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void loginFail(String message) {
        Toast(message);

    }

    void Toast(String text){
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT)
                .show();
    }
}
