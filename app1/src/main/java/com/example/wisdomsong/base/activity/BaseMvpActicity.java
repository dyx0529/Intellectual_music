package com.example.wisdomsong.base.activity;

import com.example.wisdomsong.base.BasePersent;

public abstract class BaseMvpActicity<V,P extends BasePersent<V>> extends BaseActivity{
  protected P initPersnet;
    @Override
    protected void initMvpActivity() {
            initPersnet=attatchPersent();
            if(initPersnet!=null){
                initPersnet.attatchView((V) this);
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(initPersnet!=null){
            initPersnet.deatchView();
        }
    }

    protected abstract P attatchPersent();
}
