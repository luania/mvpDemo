package com.luania.qingke.activities.main;

import com.luania.qingke.activities.base.BaseView;

/**
 * Created by luania on 16/8/3.
 */
interface MainView extends BaseView {
    boolean isDrawerOpen();

    void closeDrawer();

    void toastMorePress();

    void startSearchActivity();

    void finish();
}
