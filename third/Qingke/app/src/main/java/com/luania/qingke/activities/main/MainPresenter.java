package com.luania.qingke.activities.main;

import com.luania.qingke.activities.common.BasePresenter;

/**
 * Created by luania on 16/8/3.
 */
class MainPresenter extends BasePresenter<MainView> implements MainViewListener {
    private long lastBackPressTime = 0;

    public MainPresenter(MainView mainView) {
        super(mainView);
    }

    @Override
    public void onSearchClicked() {
        view.startSearchActivity();
    }

    @Override
    public void onBackPressed() {
        backPressed();
    }

    void backPressed() {
        if (view.isDrawerOpen()) {
            view.closeDrawer();
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastBackPressTime > 1000) {
            view.toastMorePress();
            lastBackPressTime = now;
            return;
        }
        view.finish();
    }
}
