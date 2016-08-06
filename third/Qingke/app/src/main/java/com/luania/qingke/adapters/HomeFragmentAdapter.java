package com.luania.qingke.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.luania.qingke.fragments.AndroidFragment;
import com.luania.qingke.fragments.CtoFragment;
import com.luania.qingke.fragments.IosFragment;
import com.luania.qingke.fragments.JavaFragment;

/**
 * Created by luania on 16/7/27.
 */
public class HomeFragmentAdapter extends FragmentPagerAdapter {
    public HomeFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = CtoFragment.newInstance();
                break;
            case 1:
                fragment = JavaFragment.newInstance();
                break ;
            case 2:
                fragment = AndroidFragment.newInstance();
                break;
            case 3:
                fragment = IosFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title= "CTO访谈";
                break;
            case 1:
                title= "JAVA";
                break;
            case 2:
                title= "ANDROID";
                break;
            case 3:
                title = "IOS";
                break;
        }
        return title;
    }
}
