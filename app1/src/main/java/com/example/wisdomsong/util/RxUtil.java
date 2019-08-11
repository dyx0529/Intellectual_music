package com.example.wisdomsong.util;

import com.example.wisdomsong.bean.ApiException;
import com.example.wisdomsong.bean.HttpExp;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxUtil {
     public static <T> ObservableTransformer<T,T> getRx(){
             return new ObservableTransformer<T, T>() {
                 @Override
                 public ObservableSource<T> apply(Observable<T> upstream) {
                     return upstream.subscribeOn(Schedulers.io())
                             .observeOn(AndroidSchedulers.mainThread());
                 }
             };
         }
       public static <T> ObservableTransformer<ApiException<T>,T> getchange(){
         return new ObservableTransformer<ApiException<T>, T>() {
             @Override
             public ObservableSource<T> apply(Observable<ApiException<T>> upstream) {
                 return upstream.flatMap(new Function<ApiException<T>, ObservableSource<T>>() {
                     @Override
                     public ObservableSource<T> apply(final ApiException<T> e) throws Exception {
                         if (e.getErrorCode() == 0) {
                             return Observable.create(new ObservableOnSubscribe<T>() {
                                 @Override
                                 public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                                     try {
                                         emitter.onNext(e.getData());
                                         emitter.onComplete();
                                     } catch (Exception e) {
                                         emitter.onError(e);
                                     }
                                 }
                             });
                         } else {
                             return Observable.error(new HttpExp(e.getErrorCode(), e.getErrorMsg()));
                         }
                     }
                 });
             }
         };
       }
}
