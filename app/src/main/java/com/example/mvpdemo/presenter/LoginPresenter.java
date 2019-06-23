package com.example.mvpdemo.presenter;

import com.example.mvpdemo.model.entities.User;

public interface LoginPresenter {
    void ValiteCrediter(User user);
    void OnDestroy();
}
