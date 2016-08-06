package com.luania.qingke.activities.video;

import android.content.Intent;
import android.net.Uri;

import com.luania.qingke.activities.common.BaseView;

/**
 * Created by luania on 16/8/3.
 */
public interface VideoView extends BaseView {
    Intent getIntent();

    void startVideo(Uri uri);

    void showFabProgressCircle();

    void hideStatusBar();

    void insertData(String title, String uri, float ratio);

    void goneVideoView();

    void initAppBarHeight(float ratio);

    void onBackPressed();

    void animHideImageView();

    void hideFab();

    void hideFabProgressCircle();

    void goneImageView();
}
