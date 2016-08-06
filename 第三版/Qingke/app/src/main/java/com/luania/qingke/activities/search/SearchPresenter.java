package com.luania.qingke.activities.search;

import com.luania.qingke.activities.common.BasePresenter;

/**
 * Created by luania on 16/8/3.
 */
class SearchPresenter extends BasePresenter<SearchView> implements SearchViewListener {

    public SearchPresenter(SearchView view) {
        super(view);
    }

    @Override
    public void onClose() {
        view.animCloseSearchLayout();
    }

    @Override
    public void onSearchLayoutPost() {
        view.animOpenSearchLayout();
    }

    @Override
    public void onCloseSearchLayoutEnd() {
        view.goneSearchLayout();
        view.finish();
    }
}

