package com.app.hotfix_bugly;

/**
 * 加载Bug的类.
 */
public class LoadBugClass {

    /**
     * 获取bug字符串.
     * @return 返回bug字符串
     */
    public static String getBugString() {
        BugClass bugClass = new BugClass();
        return bugClass.bug();
    }
}
