package com.example.wisdomsong.util;

import android.os.Environment;

import java.io.File;

/**
 * Created by $lzj on 2019/5/5.
 */
public interface AppConstants {
    public static final int TYPE_Discover= 0;
    public static final int TYPE_Musiclibrary= 1;
    public static final int TYPE_Message= 2;
    public static final int TYPE_My= 3;



    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "code" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApplication.getBaseApplication().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";
}
