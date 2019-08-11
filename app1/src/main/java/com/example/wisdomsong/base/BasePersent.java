package com.example.wisdomsong.base;

import java.lang.ref.WeakReference;

public class BasePersent <V>{

    private WeakReference<V> weakReference;
    protected V myview;

    public void attatchView(V v){
        weakReference = new WeakReference<>(v);
        myview = weakReference.get();
    }
    public void deatchView(){
        weakReference.clear();
    }
}
