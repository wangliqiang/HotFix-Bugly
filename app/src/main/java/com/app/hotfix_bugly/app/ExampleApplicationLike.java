package com.app.hotfix_bugly.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.tinker.loader.app.DefaultApplicationLike;

/**
 * Created by 王立强 on 2017/1/9.
 * Application代理类
 */
public class ExampleApplicationLike extends DefaultApplicationLike {

    public ExampleApplicationLike(Application application, int tinkerFlags,
                                  boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime,
                                  long applicationStartMillisTime, Intent tinkerResultIntent, Resources[] resources,
                                  ClassLoader[] classLoader, AssetManager[] assetManager) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent, resources, classLoader,
                assetManager);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplication(), "b54951a9d0", false);
        Bugly.setIsDevelopmentDevice(getApplication(), true);
    }


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // 安装tinker
        Beta.installTinker(this);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callbacks) {
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }
}
