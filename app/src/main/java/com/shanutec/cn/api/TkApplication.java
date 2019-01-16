package com.shanutec.cn.api;

import android.app.Application;
import android.content.Context;

/**
 * Created by lcodecore on 2016/12/4.
 */

public class TkApplication extends Application {

    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;


    }
}
