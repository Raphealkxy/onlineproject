package com.szt21.test.szlibrary.net;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/27.
 */

public abstract  class  NetOverListener<T> {
    
    public  abstract void  onSuccess(T entity);
    public   abstract void  onError(Throwable e);
    public   abstract void  onCancelled();
    public   abstract void  onFinish();
    
}
