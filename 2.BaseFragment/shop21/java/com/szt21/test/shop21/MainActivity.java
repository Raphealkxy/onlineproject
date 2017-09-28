package com.szt21.test.shop21;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.szt21.test.szlibrary.base.BaseActivityWithNet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivityWithNet<HomeEntity> {
    
    private ListView mLv;

    
    @Override
    protected boolean isNotUseTitle() {
        return true;
    }
    
    @Override
    protected int setRootView() {
        return  R.layout.activity_main;
    }
    
    @Override
    protected void initViews() {
    
        mLv = (ListView) findViewById(R.id.lv);
    }
    
    @Override
    protected void initListeners() {
        
    }
    
    @Override
    protected String getUrl() {
        return "http://192.168.1.236/home";
    }
    
    @Override
    protected void initLocalDatas() {
        
    }
    
    @Override
    protected void initNetDatas() {
    
        //addHeader
        
//        addParam();
//        addParam();
//        addParam();
        
        executeNet();
    }
    
    @Override
    protected void onSuccess(HomeEntity entity) {
        List<String> titles=new ArrayList<>();
        List<HomeEntity.HomeClasslistEntity> home_classlist = entity.getHome_classlist();
        for (HomeEntity.HomeClasslistEntity homeClasslistEntity : home_classlist) {
            titles.add(homeClasslistEntity.getTitle());
        
        }
    
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,titles);
        mLv.setAdapter(arrayAdapter);
    }
    
    @Override
    protected void onError(Throwable e) {
        Toast.makeText(mActivitySelf, "失败", Toast.LENGTH_SHORT).show();
    }
    
    
}
