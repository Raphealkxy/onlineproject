package com.szt21.test.szlibrary.base;

import com.szt21.test.szlibrary.net.NetForJson;
import com.szt21.test.szlibrary.net.NetOverListener;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/27.
 */

public abstract class BaseActivityWithNet<T> extends BaseActivity {
    protected NetForJson mNetForJson;
    protected String mUrl;
    private NetOverListener mNetOverListener=new NetOverListener<T>() {
        @Override
        public void onSuccess(T entity) {
            BaseActivityWithNet. this.onSuccess(entity);
        }
    
        @Override
        public void onError(Throwable e) {
            BaseActivityWithNet. this.onError(e);
        }
    
        @Override
        public void onCancelled() {
            BaseActivityWithNet. this.onCancelled();
        }
    
        @Override
        public void onFinish() {
            BaseActivityWithNet. this.onFinish();
        }
    };
    
    
    @Override
    protected void initDatas() {
        mNetForJson=new NetForJson(getUrl(),mNetOverListener);
        
        initLocalDatas();
        initNetDatas();
    }
    
    protected void addParam(String key,String value){
        mNetForJson.addParam(key,value);
    }
    protected void executeNet(){
        mNetForJson.execute();
    }
    
    protected abstract String getUrl();
    protected abstract void initLocalDatas();
    protected abstract void initNetDatas();
    protected abstract void onSuccess(T entity);
    protected abstract void onError(Throwable e);
    protected  void onCancelled(){}
    protected  void onFinish(){}
    
    
   
}
