package com.example.mvp.model;

import android.os.Handler;
import android.os.Looper;


/**
 * @author admin
 */
public class MainModel implements IModel {
    @Override
    public void login(final String username, String password, CallbackYyg callback2){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){
            @Override
            public void run() {
                callback2.onSuccess(new User(1,"lance"));
            }
        },2000);
    }
}
