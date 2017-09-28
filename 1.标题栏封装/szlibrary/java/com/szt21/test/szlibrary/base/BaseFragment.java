package com.szt21.test.szlibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/27.
 */

public abstract class BaseFragment  extends Fragment{
    
    public String mTag;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTag=this.getClass().getSimpleName()+this.hashCode();
    }
}
