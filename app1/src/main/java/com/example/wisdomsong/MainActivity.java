package com.example.wisdomsong;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import com.example.wisdomsong.base.activity.BaseActivity;
import com.example.wisdomsong.fragment.DiscoverFragment;
import com.example.wisdomsong.fragment.InFormationFragment;
import com.example.wisdomsong.fragment.MusicLibraryFragment;
import com.example.wisdomsong.fragment.Myfragment;
import com.example.wisdomsong.util.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.head_fram)
    FrameLayout Framhead;
    @BindView(R.id.head_nav)
    BottomNavigationView Navhead;
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> titles;
    private FragmentManager manager;
    private PopupWindow mPopupWindow;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //初始化页面
        initFragment();
        //初始化标题
        initTitles();
        //Fragment切换
        initBottomFragment();
        //初始化管理布局
        manager = getSupportFragmentManager();
        //默认第一个fragment
        addfragment();
    }


    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new DiscoverFragment());
        fragments.add(new MusicLibraryFragment());
        fragments.add(new InFormationFragment());
        fragments.add(new Myfragment());
    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add(AppConstants.TYPE_Discover);
        titles.add(AppConstants.TYPE_Musiclibrary);
        titles.add(AppConstants.TYPE_Message);
        titles.add(AppConstants.TYPE_My);
    }

    private void initBottomFragment() {
        Navhead.setItemIconTintList(null);
        Navhead.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.discover:
                        SwitchFragment(AppConstants.TYPE_Discover);
                        break;
                    case R.id.Musiclibrary:
                        SwitchFragment(AppConstants.TYPE_Musiclibrary);
                        break;
                    case R.id.Shoot:
                        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.shoot_pop, null);
                        //   SwitchFragment(AppConstants.TYPE_Shoot);
                        mPopupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                        //设置背景
                        mPopupWindow.setBackgroundDrawable(new ColorDrawable(R.color.colorPrimary));
                        //点击外部消失
                        mPopupWindow.setOutsideTouchable(true);
                        //水平方向
                        mPopupWindow.showAtLocation(inflate, Gravity.CENTER, 0, 0);

                        inflate.findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //关闭
                                mPopupWindow.dismiss();
                            }
                        });

                        break;
                    case R.id.Message:
                        SwitchFragment(AppConstants.TYPE_Message);
                        break;
                    case R.id.My:
                        SwitchFragment(AppConstants.TYPE_My);
                        break;
                }
                return true;
            }
        });
    }
    int lastType=0;
    private void SwitchFragment(int type) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragments.get(type);
        if (!fragment.isAdded()) {
            transaction.add(R.id.head_fram, fragment);
        }
        Fragment fragment1 = fragments.get(lastType);
        transaction.hide(fragment1);
        transaction.show(fragment);
        transaction.commit();
        lastType=type;
    }

    private void addfragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragments.get(0);
        transaction.add(R.id.head_fram, fragment);
        transaction.commit();
    }
}
