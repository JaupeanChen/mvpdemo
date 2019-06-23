package com.example.mvpdemo.model;

import android.os.Handler;
import android.text.TextUtils;

import com.example.mvpdemo.model.entities.User;
import com.example.mvpdemo.presenter.LoginFinishListener;

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(User user, final LoginFinishListener listener) {
        final String name = user.getName();
        final String pass = user.getPassword();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(name)){
                    listener.OnNameError();
                    error = true;
                }else if (TextUtils.isEmpty(pass)){
                    listener.OnPasswordError();
                    error = true;
                }
                if (!error){
                    listener.OnSucceed();
                }
            }
        },1000);
    }
}
