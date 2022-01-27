package com.example.mvp.model;

import com.example.mvp.model.User;

public interface CallbackYyg {
     void onSuccess(User user);
     void onFailed(String msg);
}
