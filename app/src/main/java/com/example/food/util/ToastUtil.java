package com.example.food.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author wellorbetter
 * @since 2024/6/19 11:16
 */
public class ToastUtil {
    private Context mContext;
    private ToastUtil(Context mContext){
        this.mContext = mContext;
    }
    private static ToastUtil singleton;
    public static ToastUtil newInstance(Context mContext) {
        if (singleton == null) {
            synchronized (ToastUtil.class) {
                if (singleton == null) {
                    singleton = new ToastUtil(mContext);
                }
            }
        }
        return singleton;
    }
    public void toastShort(String hint) {
        Toast.makeText(mContext, hint, Toast.LENGTH_SHORT).show();
    }
    public void toastLong(String hint) {
        Toast.makeText(mContext, hint, Toast.LENGTH_LONG).show();
    }
}
