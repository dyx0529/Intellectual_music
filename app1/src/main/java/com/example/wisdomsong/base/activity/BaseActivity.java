package com.example.wisdomsong.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wisdomsong.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        bind = ButterKnife.bind(this);
        initMvpActivity();
        //初始化视图
        initView();
        //初始化数据
        initData();
        //监听
        initListener();
    }

    protected void initMvpActivity() {
    }

    protected void initData() {
    }

    protected void initListener() {
    }

    protected void initView() {
    }

    protected abstract int getLayoutID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bind!=null){
            bind.unbind();
        }
    }
}
