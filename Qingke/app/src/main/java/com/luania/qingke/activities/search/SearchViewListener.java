package com.luania.qingke.activities.search;

import com.luania.qingke.activities.base.BaseViewListener;

/**
 * Created by luania on 16/8/4.
 */
public interface SearchViewListener extends BaseViewListener {
    void onClose();

    void onSearchLayoutPost();

    void onCloseSearchLayoutEnd();

    class SearchViewListenerAdapter implements SearchViewListener{

        @Override
        public void onClose() {

        }

        @Override
        public void onSearchLayoutPost() {

        }

        @Override
        public void onCloseSearchLayoutEnd() {

        }
    }
}
