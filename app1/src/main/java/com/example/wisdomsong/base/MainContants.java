package com.example.wisdomsong.base;

public interface MainContants {
    interface MainModel{
        interface Callback{
            void OnSuccess(String msg);
            void OnFail(String error);
        }
        void getData(Callback callback);
    }

}
