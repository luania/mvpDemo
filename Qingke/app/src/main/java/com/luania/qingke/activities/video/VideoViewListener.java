package com.luania.qingke.activities.video;

import com.luania.qingke.activities.base.BaseViewListener;

/**
 * Created by luania on 16/8/4.
 */
public interface VideoViewListener extends BaseViewListener {
    void onViewCreated();

    void onPlayCLicked();

    void onReturnTransitionEnd();

    void onToolbarNavigationClick();

    void onVideoPrepared();

    void onAnimHideImageViewStart();

    void onAnimHideImageViewEnd();

    class VideoViewListenerAdapter implements VideoViewListener{

        @Override
        public void onViewCreated() {

        }

        @Override
        public void onPlayCLicked() {

        }

        @Override
        public void onReturnTransitionEnd() {

        }

        @Override
        public void onToolbarNavigationClick() {

        }

        @Override
        public void onVideoPrepared() {

        }

        @Override
        public void onAnimHideImageViewStart() {

        }

        @Override
        public void onAnimHideImageViewEnd() {

        }
    }
}
