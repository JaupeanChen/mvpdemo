package com.example.mvpdemo.model;

import com.example.mvpdemo.model.entities.User;
import com.example.mvpdemo.presenter.LoginFinishListener;

public interface LoginModel {
    void login(User user, LoginFinishListener listener);
}
