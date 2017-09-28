package com.szt21.test.shop21.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.szt21.test.shop21.R;
import com.szt21.test.shop21.entity.HomeEntity;

import java.util.List;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/29.
 */

public class ItemVPHomeBannerAdapter extends PagerAdapter {
    
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<HomeEntity.HomeBannerEntity> mHomeBannerEntityList;
    public int mEntitySize;
    public int mTotalCount;
    
    public ItemVPHomeBannerAdapter(List<HomeEntity.HomeBannerEntity> homeBannerEntityList, Context context) {
        mHomeBannerEntityList = homeBannerEntityList;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mEntitySize = mHomeBannerEntityList.size();
        mTotalCount=mEntitySize * 10000;
    }
    
    @Override
    public int getCount() {
        return mTotalCount;
    }
    
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        
        View view = mLayoutInflater.inflate(R.layout.item_vp_home_banner, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgv_item_vp_home_banner);
        
        container.addView(view);
        
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.product_loading)
                .error(R.drawable.product_loading);
        HomeEntity.HomeBannerEntity homeBannerEntity = mHomeBannerEntityList.get(position % mEntitySize);
        Glide.with(mContext).load(homeBannerEntity.getPic()).apply(requestOptions).into(imageView);
        
        return view;
    }
    
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
