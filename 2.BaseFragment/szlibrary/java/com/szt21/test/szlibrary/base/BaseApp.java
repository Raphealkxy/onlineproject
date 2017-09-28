package com.szt21.test.szlibrary.base;

import android.app.Application;

import com.szt21.test.szlibrary.BuildConfig;

import org.xutils.x;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/27.
 */

public abstract class BaseApp extends Application {
    //这个变量里，将来肯定会有 标题栏布局的xml  R.layout.xxxx
    public static  int sTitleLayoutID;
    @Override
    public void onCreate() {
        super.onCreate();
        
        initX();
        
        initOthers();
        sTitleLayoutID=initTitleBarResID();
    }
    
    protected abstract int initTitleBarResID();
    
    
    
    protected abstract void initOthers();
    
    private void initX() {
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
