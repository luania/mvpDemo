package com.luania.qingke.activities.search;

import com.luania.qingke.activities.base.BaseView;

/**
 * Created by luania on 16/8/3.
 */
interface SearchView extends BaseView {
    void animOpenSearchLayout();

    void animCloseSearchLayout();

    void goneSearchLayout();

    void finish();
}
