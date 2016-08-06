package com.luania.qingke.activities.video;

import android.net.Uri;
import android.os.Bundle;

import com.luania.qingke.activities.common.BasePresenter;

/**
 * Created by luania on 16/8/3.
 */
public class VideoPresenter extends BasePresenter {

    private VideoView videoView;

    public VideoPresenter(VideoView videoView) {
        this.videoView = videoView;
    }

    public void onViewCreated() {
        initData();
    }

    public void onPlayCLicked() {
        videoView.showFabProgressCircle();
        videoView.hideStatusBar();
        videoView.startVideo(Uri.parse("http://oar0q73sl.bkt.clouddn.com/90_qingke_uiactionsheet.mp4"));
    }

    public void onVideoPrepared() {
        videoView.animHideImageView();
    }

    public void onReturnTransitionEnd() {
        videoView.goneVideoView();
    }

    public void onToolbarNavigationClick() {
        videoView.onBackPressed();
    }

    public void onAnimHideImageViewStart() {
        videoView.hideFabProgressCircle();
        videoView.hideFab();
    }

    public void onAnimHideImageViewEnd() {
        videoView.goneImageView();
    }

    private void initData() {
        Bundle bundle = videoView.getIntent().getExtras();
        String title = bundle.getString("title");
        String uri = bundle.getString("uri");
        videoView.insertData(title, uri, 9f / 16);
    }
}
