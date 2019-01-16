package com.shanutec.cn.util;

import android.widget.Toast;

import com.shanutec.cn.api.TkApplication;


/**
 * Created by lcodecore on 2017/2/28.
 */

public class ToastUtil {
    public static void show(String msg){
        Toast.makeText(TkApplication.appContext, msg, Toast.LENGTH_SHORT).show();
    }
}
