package com.luania.qingke.activities.base;

/**
 * Created by luania on 16/8/4.
 */
public abstract class BasePresenter<V extends BaseView> {
    public V view;

    public BasePresenter(V view) {
        this.view = view;
    }
}
