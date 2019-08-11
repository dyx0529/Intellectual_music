package com.example.wisdomsong.util;


import com.example.wisdomsong.bean.HttpExp;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    CompositeDisposable compositeDisposable=new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onNext(T t) {
        OnSuccess(t);
    }



    @Override
    public void onError(Throwable e) {
        if(e instanceof HttpExp){
            HttpExp httpExp= (HttpExp) e;
            int code = httpExp.getErrorCode();
            switch (code){
                case 1:
            }
            OnError(httpExp.getErrorMsg());
        }
        if(compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }
    @Override
    public void onComplete() {
        if(compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }
    protected abstract void OnError(String errorMsg);

    protected abstract void OnSuccess(T t);
}
