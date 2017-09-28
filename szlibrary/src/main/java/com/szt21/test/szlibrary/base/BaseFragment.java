package com.szt21.test.szlibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.szt21.test.szlibrary.R;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/27.
 */

public abstract class BaseFragment  extends Fragment{
    
    public String mTag;
    protected BaseActivity mActivitySelf;
    protected LayoutInflater mLayoutInflater;
    protected FragmentManager mFragmentManager;
    private View mViewTitleLeft,mViewTitleCenter,mViewTitleRight;
    protected View mRootView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTag=this.getClass().getSimpleName()+this.hashCode();
    }
    
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
    
        //实例化属性
        mActivitySelf = (BaseActivity) this.getActivity();
        mLayoutInflater = inflater;
        mFragmentManager = this.getFragmentManager();
    
    
        int rootLayoutID=setRootView();
      
    
        if (isNotUseTitle()) {
            //如果不使用标题栏，那么直接渲染原有布局，赋值给mRootView,return mRootView作为Fragment的布局视图
            mRootView=mLayoutInflater.inflate(rootLayoutID,container,false);
        }else {
            //如果使用标题栏，那么把LinearLaout 赋值给mRootView,return mRootView作为Fragment的布局视图
            addTitleBar(rootLayoutID);
        }
    
        initDatas();
        initViews();
        initListeners();
        
        return mRootView;
    }
    
    //true代表不使用标题栏
    protected boolean isNotUseTitle(){
        
        return false;
    }
    
    
    private void addTitleBar(int rootLayoutID) {
        //----设置自己的带有标题栏的布局--------------
        LinearLayout linearLayout=new LinearLayout(mActivitySelf);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        
        
        View titleView=mLayoutInflater.inflate(BaseApp.sTitleLayoutID,linearLayout,false);
        linearLayout.addView(titleView);
        mViewTitleLeft=titleView.findViewById(R.id.title_left);
        mViewTitleCenter=titleView.findViewById(R.id.title_center);
        mViewTitleRight=titleView.findViewById(R.id.title_right);
        
        if (mViewTitleLeft != null) {
            mViewTitleLeft.setVisibility(View.INVISIBLE);
        }
        
        if (mViewTitleRight != null) {
            mViewTitleRight.setVisibility(View.INVISIBLE);
        }
        
        
        View rootView = mLayoutInflater.inflate(rootLayoutID, linearLayout, false);
        
        linearLayout.addView(rootView);
        mRootView=linearLayout;
        //----设置自己的带有标题栏的布局--------------
        
    }
    
    protected void setTitleCenter(String text){
        if (mViewTitleCenter==null) {
            return;
        }
        if (mViewTitleCenter instanceof TextView){
            TextView textView= (TextView) mViewTitleCenter;
            textView.setText(text);
        }
    }
    
    protected void setTitleLeft(String text, View.OnClickListener onClickListener){
        if (mViewTitleLeft==null) {
            return;
        }
        mViewTitleLeft.setVisibility(View.VISIBLE);
        if (mViewTitleLeft instanceof TextView){
            TextView textView= (TextView) mViewTitleLeft;
            textView.setText(text);
        }
        
        mViewTitleLeft.setOnClickListener(onClickListener);
    }
    
    protected void setTitleRight(String text, View.OnClickListener onClickListener){
        if (mViewTitleRight==null) {
            return;
        }
        
        mViewTitleRight.setVisibility(View.VISIBLE);
        if (mViewTitleRight instanceof TextView){
            TextView textView= (TextView) mViewTitleRight;
            textView.setText(text);
        }
        
        mViewTitleRight.setOnClickListener(onClickListener);
    }
    
    protected abstract int setRootView();
    
    //----三大流程------------
    
    protected abstract void initDatas();
    
    protected abstract void initViews();
    
    protected abstract void initListeners();
    //----三大流程------------
    
    
    //----fragment的快捷操作------------
    
    protected  void addFrag(int desId,BaseFragment fragment){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(desId,fragment,fragment.mTag);
        transaction.commit();
        
    }
    protected  void removeFrag(BaseFragment fragment){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
        
    }
    protected  void replaceFrag(int desId,BaseFragment newFragment){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(desId,newFragment,newFragment.mTag);
        transaction.commit();
        
    }
    protected  void hideFrag(BaseFragment fragment){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
        
    }
    protected  void showFrag(BaseFragment fragment){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.show(fragment);
        transaction.commit();
        
    }
    
    //----fragment的快捷操作------------
}
    
