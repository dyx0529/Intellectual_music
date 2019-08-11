package com.example.wisdomsong.bean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface Apiserverce {
    @GET
    Observable<ApiException<ResponseBody>> getAa();
}
