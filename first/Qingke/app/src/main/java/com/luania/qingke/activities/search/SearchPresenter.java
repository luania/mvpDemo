package com.luania.qingke.activities.search;

import com.luania.qingke.activities.common.BasePresenter;

/**
 * Created by luania on 16/8/3.
 */
class SearchPresenter extends BasePresenter {
    public SearchView searchView;

    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
    }

    public void onClose() {
        searchView.animCloseSearchLayout();
    }

    public void onSearchLayoutPost() {
        searchView.animOpenSearchLayout();
    }

    public void onCloseSearchLayoutEnd() {
        searchView.goneSearchLayout();
        searchView.finish();
    }
}

