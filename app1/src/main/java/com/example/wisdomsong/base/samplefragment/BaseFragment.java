package com.example.wisdomsong.base.samplefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wisdomsong.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayoutID(), container, false);
        bind = ButterKnife.bind(this, view);
        initMvpFragment();
        //初始化视图
        initFragmentView(view);
        //初始化数据
        initFramentData();
        return view;
    }

    protected void initMvpFragment() {
    }

    protected void initFramentData() {
    }

    protected void initFragmentView(View view) {
    }

    protected abstract int getLayoutID();
    @Override
    public void onDestroy() {
        if(bind!=null){
            bind.unbind();
        }
        super.onDestroy();
    }
}
