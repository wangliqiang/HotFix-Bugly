package com.app.hotfix_bugly;

/**
 * 测试bug类.
 */
public class BugClass {

    public String bug() {
        // 这段代码会报空指针异常
//        String str = null;
//        int length = str.length();
        return "This is a fixed bug class";
    }
}
