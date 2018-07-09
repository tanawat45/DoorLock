package th.co.banana.doorlock.login;

public class LoginPresenterImplement implements LoginPresenter {

    private LoginView view;

    public LoginPresenterImplement(LoginView view){
        this.view = view;
    }

    @Override
    public void goToMainActivity(String username, String password) {

    }

    @Override
    public void validateUserAndPassword(String username, String password) {
        if(username.length() == 0 && password.length() == 0){
            view.loginFail("กรุณากรอกชื่อผู้ใช้ และรหัสผ่าน");
        }

        else if(username.length() == 0){
            view.loginFail("กรุณากรอกชื่อผู้ใช้");
        }
        else if(password.length() == 0){
            view.loginFail("กรุณากรอกรหัสผ่าน");
        }
        else onLogin(username, password);
    }

    private void onLogin(String username, String password) {
        view.showMainActivity();
    }

    @Override
    public void start() {
        view.showMainActivity();

    }
}
