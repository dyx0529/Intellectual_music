package com.example.wisdomsong.base.samplefragment;

import com.example.wisdomsong.base.BasePersent;

public abstract class BaseMvpfragment <V,P extends BasePersent<V>>extends BaseFragment {
    private P initPersentFragment;
    @Override
    protected void initMvpFragment() {
        initPersentFragment=initFragmentPersnet();
        if(initPersentFragment!=null){
            initPersentFragment.attatchView((V) this);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(initPersentFragment!=null){
            initPersentFragment.deatchView();
        }
    }
    protected abstract P initFragmentPersnet();


}
