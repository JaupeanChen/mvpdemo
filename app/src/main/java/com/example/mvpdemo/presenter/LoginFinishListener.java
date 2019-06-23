package com.example.mvpdemo.presenter;

public interface LoginFinishListener {
    void OnNameError();
    void OnPasswordError();
    void OnSucceed();
}
