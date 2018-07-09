package th.co.banana.doorlock.login;

import th.co.banana.doorlock.base.BaseView;

public interface LoginView extends BaseView{
    void showMainActivity();

    void showProgressBar();

    void hideProgressBar();

    void loginFail(String message);

}
