package th.co.banana.doorlock.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseFragment;
import th.co.banana.doorlock.main.MainActivity;
import th.co.banana.doorlock.mqtt.MqttActivity;
import th.co.banana.doorlock.register.RegisterActivity;

public class LoginFragment extends BaseFragment implements LoginView {

    @BindView(R.id.btn_login)
    Button btn_login;

    @BindView(R.id.etUsername)
    EditText etUsername;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.tv_register)
    TextView tv_register;



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

    @Override
    protected void onViewBind() {

        presenter = new LoginPresenterImplement(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MqttActivity.class);
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
