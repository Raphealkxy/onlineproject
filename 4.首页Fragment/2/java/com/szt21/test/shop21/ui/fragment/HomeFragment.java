package com.szt21.test.shop21.ui.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.szt21.test.shop21.R;
import com.szt21.test.shop21.common.Constant;
import com.szt21.test.shop21.entity.HomeEntity;
import com.szt21.test.shop21.ui.adapter.ItemVPHomeBannerAdapter;
import com.szt21.test.szlibrary.base.BaseFragmentWithNet;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/29.
 */

public class HomeFragment extends BaseFragmentWithNet<HomeEntity> {
    private LinearLayout mLayoutRootFragmentHome;
    private EditText mEdtSearchFragmentHome;
    private Button mBtSearchFragmentHome;
    private ViewPager mVpBannerFragmentHome;
    private RadioGroup mRgRedpFragmentHome;
    private ListView mLvClassFragmentHome;
    private Button mBtCallFragmentHome;
    private ItemVPHomeBannerAdapter mItemVPHomeBannerAdapter;
    
    private Timer mTimer;
    private boolean mCanVPPlay=true;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mVpBannerFragmentHome.setCurrentItem(mVpBannerFragmentHome.getCurrentItem()+1);
                    break;
                default:
                    break;
            }
        }
    };
    
    private void shwoVP(HomeEntity entity) {
        List<HomeEntity.HomeBannerEntity> home_banner = entity.getHome_banner();
        if (mItemVPHomeBannerAdapter==null) {
        
            mItemVPHomeBannerAdapter = new ItemVPHomeBannerAdapter(home_banner,mActivitySelf);
        }
        mVpBannerFragmentHome.setAdapter(mItemVPHomeBannerAdapter);
        mVpBannerFragmentHome.setCurrentItem(mItemVPHomeBannerAdapter.mTotalCount/2);
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                
                //这是子线程
                if (mCanVPPlay) {
                    mHandler.sendEmptyMessage(1);
                }
         
            }
        },3000,3000);
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
    }
    
    @Override
    protected int setRootView() {
        return R.layout.fragment_home;
    }
    
    
    @Override
    protected String getUrl() {
        return Constant.HOME_URL;
    }
    
    @Override
    protected void initLocalDatas() {
        mTimer=new Timer();
    }
    
    @Override
    protected void initNetDatas() {
        executeNet();
    }
    
    @Override
    protected void onSuccess(HomeEntity entity) {
        shwoVP(entity);
    }
    
 
    
    @Override
    protected void onError(Throwable e) {
        
    }
    
    @Override
    protected void initViews() {
        setTitleCenter("欢迎光临大宝剑商城");
        mLayoutRootFragmentHome = (LinearLayout) findViewById(R.id.layout_root_fragment_home);
        mLayoutRootFragmentHome.requestFocus();
        mEdtSearchFragmentHome = (EditText) findViewById(R.id.edt_search_fragment_home);
        mBtSearchFragmentHome = (Button) findViewById(R.id.bt_search_fragment_home);
        mVpBannerFragmentHome = (ViewPager) findViewById(R.id.vp_banner_fragment_home);
        mRgRedpFragmentHome = (RadioGroup) findViewById(R.id.rg_redp_fragment_home);
        mLvClassFragmentHome = (ListView) findViewById(R.id.lv_class_fragment_home);
        mBtCallFragmentHome = (Button) findViewById(R.id.bt_call_fragment_home);
    }
    
    @Override
    protected void initListeners() {
        mVpBannerFragmentHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        
            }
    
            @Override
            public void onPageSelected(int position) {
                int posRed=position%mItemVPHomeBannerAdapter.mEntitySize;
//                mRgRedpFragmentHome.set  posRed  选上
    
                 RadioButton radioButton= (RadioButton) mRgRedpFragmentHome.getChildAt(posRed);
                radioButton.setChecked(true);
            }
    
            @Override
            public void onPageScrollStateChanged(int state) {
                    mCanVPPlay=  state==ViewPager.SCROLL_STATE_IDLE;
            }
            
        });
        
    }
}
