package com.szt21.test.szlibrary.base;

import com.szt21.test.szlibrary.net.NetForJson;
import com.szt21.test.szlibrary.net.NetOverListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/27.
 * <p>
 * <p>
 * 一展现，就要联网获取数据，加载数据
 */

public abstract class BaseActivityWithNet<T> extends BaseActivity {
    protected NetForJson mNetForJson;
    protected String mUrl;
    private NetOverListener<T> mNetOverListener = new NetOverListener<T>() {
        
        @Override
        public void onSuccess(T entity) {
            BaseActivityWithNet.this.onSuccess(entity);
        }
        
        @Override
        public void onError(Throwable e) {
            BaseActivityWithNet.this.onError(e);
        }
        
        @Override
        public void onCancelled() {
            BaseActivityWithNet.this.onCancelled();
        }
        
        @Override
        public void onFinish() {
            BaseActivityWithNet.this.onFinish();
        }
    };
    
    
    @Override
    protected void initDatas() {
        ParameterizedType parameterizedType = (ParameterizedType) this
                .getClass().getGenericSuperclass();
        Type mClassEntity = parameterizedType.getActualTypeArguments()[0];
        
        mNetForJson = new NetForJson(getUrl(), mNetOverListener);
        mNetForJson.setClassEntity(mClassEntity);
        initLocalDatas();
        initNetDatas();
    }
    
    protected void addParam(String key, String value) {
        mNetForJson.addParam(key, value);
    }
    
    protected void executeNet() {
        mNetForJson.execute();
    }
    
    protected abstract String getUrl();
    
    protected abstract void initLocalDatas();
    
    protected abstract void initNetDatas();
    
    protected abstract void onSuccess(T entity);
    
    protected abstract void onError(Throwable e);
    
    protected void onCancelled() {
    }
    
    protected void onFinish() {
    }
    
    
}
