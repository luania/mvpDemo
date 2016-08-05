package com.luania.qingke.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luania.qingke.R;
import com.squareup.picasso.Picasso;

public class ImageAdapter extends PagerAdapter {

    private Context context;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    private String[] uris = {"http://7xjubq.com1.z0.glb.clouddn.com/2_banner22.png"
            ,"http://7xjubq.com1.z0.glb.clouddn.com/3_banner3.png"};

    @Override
    public int getCount() {
        //设置成最大，使用户看不到边界
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //对ViewPager页号求模取出View列表中要显示的项
        position %= uris.length;
        if (position < 0) {
            position = uris.length + position;
        }
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.item_banner,container,false);
        Picasso.with(context).load(uris[position]).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}