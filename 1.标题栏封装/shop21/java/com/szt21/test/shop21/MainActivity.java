package com.szt21.test.shop21;

import android.view.View;
import android.widget.Toast;

import com.szt21.test.szlibrary.base.BaseActivity;

public class MainActivity extends BaseActivity {
    
    @Override
    protected int setRootView() {
        return R.layout.activity_main;
    }
    
    @Override
    protected void initDatas() {
        
    }
    
    @Override
    protected void initViews() {
        
        setTitleCenter("呵呵？？");
        setTitleLeft("我是左边的！！", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivitySelf, "返回了", Toast.LENGTH_SHORT).show();
                finish();
        
            }
        }); 
        
        setTitleRight("我是右边的", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "yyyyy", Toast.LENGTH_SHORT).show();
                
            }
        });
        
    }
    
    @Override
    protected void initListeners() {
        
    }
}
