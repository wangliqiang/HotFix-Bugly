package com.app.hotfix_bugly;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mVersion;
    Button mHotFix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVersion = (TextView) findViewById(R.id.version_txt);
        mHotFix = (Button) findViewById(R.id.hotfix_btn);
        mVersion.setText(getVersion());
        mHotFix.setOnClickListener(this);
    }

    public String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return "当前版本号：" + version;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "获取版本失败！！！";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hotfix_btn:
                testToast();
                break;
            default:
                break;
        }
    }

    /**
     * 根据应用patch包前后来测试是否应用patch包成功.
     *
     * 应用patch包前，提示"This is a bug class"
     * 应用patch包之后，提示"The bug has fixed"
     */
    public void testToast() {
        Toast.makeText(this, LoadBugClass.getBugString(), Toast.LENGTH_SHORT).show();
    }
}
