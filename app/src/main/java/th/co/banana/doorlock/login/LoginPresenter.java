package th.co.banana.doorlock.login;

import th.co.banana.doorlock.base.BasePresenter;

public interface LoginPresenter extends BasePresenter {

    void goToMainActivity();

    void validateUserAndPassword();
}
