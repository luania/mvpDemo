package com.luania.qingke.activities.video;

import android.net.Uri;
import android.os.Bundle;

import com.luania.qingke.activities.common.BasePresenter;

/**
 * Created by luania on 16/8/3.
 */
public class VideoPresenter extends BasePresenter<VideoView> implements VideoViewListener {

    public VideoPresenter(VideoView view) {
        super(view);
    }

    @Override
    public void onViewCreated() {
        initData();
    }

    @Override
    public void onPlayCLicked() {
        view.showFabProgressCircle();
        view.hideStatusBar();
        view.startVideo(Uri.parse("http://oar0q73sl.bkt.clouddn.com/90_qingke_uiactionsheet.mp4"));
    }

    @Override
    public void onVideoPrepared() {
        view.animHideImageView();
    }

    @Override
    public void onReturnTransitionEnd() {
        view.goneVideoView();
    }

    @Override
    public void onToolbarNavigationClick() {
        view.onBackPressed();
    }

    @Override
    public void onAnimHideImageViewStart() {
        view.hideFabProgressCircle();
        view.hideFab();
    }

    @Override
    public void onAnimHideImageViewEnd() {
        view.goneImageView();
    }

    private void initData() {
        Bundle bundle = view.getIntent().getExtras();
        String title = bundle.getString("title");
        String uri = bundle.getString("uri");
        view.insertData(title, uri, 9f / 16);
    }
}
