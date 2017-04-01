package com.app.hotfix_bugly;

import android.util.Log;

/**
 * 测试bug类.
 */
public class BugClass {

    public String bug() {
        // 这段代码会报空指针异常
        String str = null;
//        Log.e("BugClass", "get String length:" + str.length());
        return "This is a bug class";
    }
}
