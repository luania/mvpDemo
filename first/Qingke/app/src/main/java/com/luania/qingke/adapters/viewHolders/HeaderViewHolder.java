package com.luania.qingke.adapters.viewHolders;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.luania.qingke.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    public ViewPager viewPager;
    public HeaderViewHolder(View itemView) {
        super(itemView);
        viewPager = (ViewPager) itemView.findViewById(R.id.viewPager);
    }
}