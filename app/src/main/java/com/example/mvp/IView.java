package com.example.mvp;

import com.example.mvp.model.User;

/**
 * @author admin
 */
public interface IView {

    void showProgress();
    void hideProgress();
    void loginSuccess(User user);
    void loginFailure(String msg);
}
