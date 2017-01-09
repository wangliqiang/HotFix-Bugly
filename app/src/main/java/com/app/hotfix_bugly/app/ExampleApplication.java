package com.app.hotfix_bugly.app;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by 王立强 on 2017/1/9.
 */

public class ExampleApplication extends TinkerApplication {

    public ExampleApplication(){
        super(ShareConstants.TINKER_ENABLE_ALL, "com.app.hotfix_bugly.app.ExampleApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
