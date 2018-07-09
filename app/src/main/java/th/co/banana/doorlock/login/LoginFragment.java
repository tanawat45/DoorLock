package th.co.banana.doorlock.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseFragment;

public class LoginFragment extends BaseFragment {

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

    }
}
