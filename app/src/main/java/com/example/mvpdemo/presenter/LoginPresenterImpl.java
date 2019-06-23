package com.example.mvpdemo.presenter;

import com.example.mvpdemo.View.LoginView;
import com.example.mvpdemo.model.LoginModel;
import com.example.mvpdemo.model.LoginModelImpl;
import com.example.mvpdemo.model.entities.User;

public class LoginPresenterImpl implements LoginPresenter,LoginFinishListener {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void ValiteCrediter(User user) {
        if (loginView!=null){
            loginView.showProgressBar();
        }
        loginModel.login(user,this);


    }

    @Override
    public void OnDestroy() {
        loginView = null;

    }

    @Override
    public void OnNameError() {
        if (loginView!=null){
            loginView.hideProgressBar();
            loginView.setNameError();
        }

    }

    @Override
    public void OnPasswordError() {
        if (loginView != null){
            loginView.hideProgressBar();
            loginView.setPasswordError();
        }

    }

    @Override
    public void OnSucceed() {
        if (loginView != null){
            loginView.hideProgressBar();
            loginView.showSuccess();
        }

    }
}
