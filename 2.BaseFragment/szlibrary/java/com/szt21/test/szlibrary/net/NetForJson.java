package com.szt21.test.szlibrary.net;

import android.util.Log;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/27.
 */

public  class NetForJson implements Callback.CommonCallback<String> {
    
    private static final int NET_OK=110;
    private static final int NET_ERROR=120;
    private NetForJsonMethod mNetForJsonMethod=NetForJsonMethod.GET;
    private String mUrl;
    private Type mClassEntity;
    private NetOverListener mNetOverListener;
    private RequestParams mRequestParams;
    
    private Cancelable mCancelable;
    
    public NetForJson(NetForJsonMethod netForJsonMethod, String url,  NetOverListener netOverListener) {
        mNetForJsonMethod = netForJsonMethod;
        mUrl = url;
        mNetOverListener = netOverListener;
//        executorService= Executors.newSingleThreadExecutor()
    
    
        //根据泛型获取Type类型，从而省略传入解析类型参数
        if (netOverListener!=null){
            ParameterizedType parameterizedType = (ParameterizedType) netOverListener
                    .getClass().getGenericSuperclass();
            mClassEntity = parameterizedType.getActualTypeArguments()[0];
        }
    
        mRequestParams=new RequestParams(mUrl);
    
    }
    
    public NetForJson(String url,NetOverListener netOverListener) {
        this(NetForJsonMethod.GET,url,netOverListener);
    }
    
    public  void execute(){
        if (mNetForJsonMethod== NetForJsonMethod.POST) {
           doPost();
        }else {
            doGet();
            
        }
    }
    public void cancel(){
        if (!mCancelable.isCancelled()){
            mCancelable.cancel();
        }
       
        
    }
    public void addParam(String key,Object value){
        if (mNetForJsonMethod==NetForJsonMethod.GET){
            mRequestParams.addParameter(key,value);
        }else {
            mRequestParams.addBodyParameter(key,value+"");
        }
        
    }
    private void doPost() {
        //自己实现
        mCancelable = x.http().post(mRequestParams,this);
    }
    
    private void doGet() {
        mCancelable = x.http().get(mRequestParams,this);
    }
    
    @Override
    public void onSuccess(String json) {
        Gson gson=new Gson();
        Log.e("xx",mClassEntity+"");
        mNetOverListener.onSuccess(gson.fromJson(json,mClassEntity));
    }
    
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        ex.printStackTrace();
        mNetOverListener.onError(ex);
    }
    
    @Override
    public void onCancelled(CancelledException cex) {
        mNetOverListener.onCancelled();
    }
    
    @Override
    public void onFinished() {
        mNetOverListener.onFinish();
    }
}
