package com.example.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpdemo.View.LoginView;
import com.example.mvpdemo.model.entities.User;
import com.example.mvpdemo.presenter.LoginPresenter;
import com.example.mvpdemo.presenter.LoginPresenterImpl;

public class MainActivity extends AppCompatActivity implements LoginView {
    private ProgressBar progressBar;
    private EditText name;
    private EditText password;
    private Button login;

    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        loginPresenter = new LoginPresenterImpl(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = name.getText().toString();
                String pass = password.getText().toString();
                User user = new User(nameString,pass);
                loginPresenter.ValiteCrediter(user);
            }
        });
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setNameError() {
        Toast.makeText(this,"Name Error!",Toast.LENGTH_LONG).show();

    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,"Password Error!",Toast.LENGTH_LONG).show();

    }

    @Override
    public void showSuccess() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this,"Login Success!",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,ShowActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        loginPresenter.OnDestroy();
        super.onDestroy();
    }
}
