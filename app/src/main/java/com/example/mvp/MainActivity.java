package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.IPresenter.IPresenter;
import com.example.mvp.IPresenter.MainIPresenter;
import com.example.mvp.model.User;


/**
 * @author admin
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView{

    EditText et_1, et_2;
    ProgressDialog progressDialog;
    Button btn_load;
    IPresenter mainIPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_1 = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);
        btn_load = findViewById(R.id.btn_load);
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("请稍后...");
        mainIPresenter=new MainIPresenter(this);
        btn_load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = et_1.getText().toString();
        String password = et_2.getText().toString();
        mainIPresenter.login(name ,password);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void loginSuccess(User user) {
        Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure(String msg) {
        Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_SHORT).show();
    }
}