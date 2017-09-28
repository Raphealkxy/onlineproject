package com.szt21.test.shop21.ui.activity;

import android.os.Handler;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.szt21.test.shop21.R;
import com.szt21.test.shop21.ui.fragment.ClassFragment;
import com.szt21.test.shop21.ui.fragment.HomeFragment;
import com.szt21.test.shop21.ui.fragment.MoreFragment;
import com.szt21.test.shop21.ui.fragment.SearchFragment;
import com.szt21.test.shop21.ui.fragment.ShopCarFragment;
import com.szt21.test.shop21.ui.fragment.WelcomeFragment;
import com.szt21.test.szlibrary.base.BaseActivity;
import com.szt21.test.szlibrary.base.BaseFragment;

public class MainActivity extends BaseActivity {
    private RadioGroup mRgTabsActivityMain;
    private RadioButton mRbHomeActivityMain;
    
    private HomeFragment mHomeFragment=new HomeFragment();
    private ClassFragment mClassFragment=new ClassFragment();
    private SearchFragment mSearchFragment=new SearchFragment();
    private ShopCarFragment mShopCarFragment=new ShopCarFragment();
    private MoreFragment mMoreFragment=new MoreFragment();
  
    private BaseFragment[] mFragments={mHomeFragment,mClassFragment,mSearchFragment,mShopCarFragment,mMoreFragment};
    private WelcomeFragment mWelcomeFragment=new WelcomeFragment();
    @Override
    protected int setRootView() {
        return R.layout.activity_main;
    }
    
    @Override
    protected void initDatas() {
        
    }
    
    @Override
    protected void initViews() {
        mRgTabsActivityMain = (RadioGroup) findViewById(R.id.rg_tabs_activity_main);
        mRbHomeActivityMain = (RadioButton) findViewById(R.id.rb_home_activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        addFrag(R.id.activity_main,mWelcomeFragment);
        
//        new Handler().post(new Runnable() {
//            @Override
//            public void run() {
//                //这是主线程执行的。。
//        
//            }
//        });
        //去掉状态栏
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                removeFrag(mWelcomeFragment);
                //加回状态栏
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        },3000);
    }
    
    @Override
    protected void initListeners() {
    
    
        mRgTabsActivityMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                BaseFragment baseFragmentNow=null;
                switch (checkedId) {
                    case R.id.rb_home_activity_main:
                        baseFragmentNow=mHomeFragment;
                        break;
                    case R.id.rb_class_activity_main:
                        baseFragmentNow=mClassFragment;
                        break;
                    case R.id.rb_search_activity_main:
                        baseFragmentNow=mSearchFragment;
                        break;
                    case R.id.rb_shopcar_activity_main:
                        baseFragmentNow=mShopCarFragment;
                        break;
                    case R.id.rb_more_activity_main:
                        baseFragmentNow=mMoreFragment;
                        break;
                }
                changeFrag(baseFragmentNow);
            }
        });
    
        mRbHomeActivityMain.setChecked(true);
    }
    
    private void changeFrag(BaseFragment baseFragmentNow) {
    
        for (BaseFragment fragment : mFragments) {
            if (fragment!=baseFragmentNow) {
                hideFrag(fragment);
                continue;
            }
        }
    
        if (!baseFragmentNow.isAdded()) {
            addFrag(R.id.layout_frag_activity_main,baseFragmentNow);
        }
        showFrag(baseFragmentNow);
    }
    
    @Override
    protected boolean isNotUseTitle() {
        return true;
    }
}
