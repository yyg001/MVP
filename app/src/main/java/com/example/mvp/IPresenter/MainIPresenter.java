package com.example.mvp.IPresenter;

import com.example.mvp.model.CallbackYyg;
import com.example.mvp.model.IModel;
import com.example.mvp.IView;
import com.example.mvp.model.MainModel;
import com.example.mvp.model.User;


public class MainIPresenter implements IPresenter, CallbackYyg {
    private IModel mainModel;
    private IView mainView;

    public MainIPresenter(IView mainView) {
        this.mainView = mainView;
        this.mainModel = new MainModel();
    }

    @Override
    public void login(String username, String age) {
        mainView.showProgress();
        mainModel.login(username, age, this);
    }

    @Override
    public void onSuccess(User user) {
        mainView.hideProgress();
        mainView.loginSuccess(user);
    }

    @Override
    public void onFailed(String msg) {
        mainView.hideProgress();
        mainView.loginFailure(msg);
    }
}
