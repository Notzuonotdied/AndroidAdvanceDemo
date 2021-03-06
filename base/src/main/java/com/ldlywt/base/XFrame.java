package com.ldlywt.base;


import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.util.DisplayMetrics;

import com.ldlywt.base.frame.http.IHttpEngine;
import com.ldlywt.base.frame.http.XHttp;
import com.ldlywt.base.frame.imageload.ImageLoader;
import com.ldlywt.base.frame.imageload.XImage;
import com.ldlywt.base.widget.loadingview.XLoadingView;
import com.ldlywt.base.widget.loadingview.XLoadingViewConfig;

public class XFrame {
    private static Context context;

    public static void init(Context context) {
        XFrame.context = context;
    }


    public static XLoadingViewConfig initXLoadingView() {
        return XLoadingView.init();
    }

    public static void initXHttp(IHttpEngine httpEngine) {
        XHttp.init(httpEngine);
    }

    public static void initXImageLoader(ImageLoader loader) {
        XImage.init(loader);
    }

    public static String getString(@StringRes int id) {
        return getResources().getString(id);
    }

    public static Resources getResources() {
        return XFrame.getContext().getResources();
    }

    public static Context getContext() {
        synchronized (XFrame.class) {
            if (XFrame.context == null)
                throw new NullPointerException("Call XFrame.init(context) within your Application onCreate() method." +
                        "Or extends XApplication");
            return XFrame.context.getApplicationContext();
        }
    }

    public static Resources.Theme getTheme() {
        return XFrame.getContext().getTheme();
    }

    public static AssetManager getAssets() {
        return XFrame.getContext().getAssets();
    }

    public static Object getSystemService(String name) {
        return XFrame.getContext().getSystemService(name);
    }

    public static Configuration getConfiguration() {
        return XFrame.getResources().getConfiguration();
    }


}
