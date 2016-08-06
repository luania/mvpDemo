package com.luania.qingke.activities.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.github.jorgecastilloprz.FABProgressCircle;
import com.luania.qingke.R;
import com.luania.qingke.activities.common.BaseActivity;
import com.luania.qingke.utils.ui.animations.CircularRevealCreator;
import com.luania.qingke.utils.ui.measure.ViewRatioChanger;
import com.luania.qingke.widgets.listener.TransitionListenerAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by luania on 16/8/3.
 */
public class VideoActivity extends BaseActivity implements VideoView {
    private ImageView imageView;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private android.widget.VideoView videoView;
    private FloatingActionButton fabPlay;
    private FABProgressCircle fabProgressCircle;

    private VideoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        presenter = new VideoPresenter(this);
        initTransitions();
        findViews();
        initAppBar();
        presenter.onViewCreated();
    }

    private void initTransitions() {
        getWindow().setEnterTransition(new Explode().setInterpolator(new DecelerateInterpolator()));
        Explode returnExplode = new Explode();
        returnExplode.setInterpolator(new AccelerateInterpolator());
        returnExplode.addListener(new TransitionListenerAdapter() {
            @Override
            public void onTransitionEnd(Transition transition) {
                super.onTransitionEnd(transition);
                presenter.onReturnTransitionEnd();
            }
        });
        getWindow().setReturnTransition(returnExplode);
    }

    private void findViews() {
        fabPlay = (FloatingActionButton) findViewById(R.id.fab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        videoView = (android.widget.VideoView) findViewById(R.id.videoView);
        imageView = (ImageView) findViewById(R.id.imageView);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBar);
        fabProgressCircle = (FABProgressCircle) findViewById(R.id.fabProgressCircle);
    }

    private void initAppBar() {
        fabPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPlayCLicked();
            }
        });
        toolbar.setNavigationIcon(R.drawable.navigation_close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onToolbarNavigationClick();
            }
        });
    }

    @Override
    public void initAppBarHeight(float ratio) {
        ViewRatioChanger.changeHeight(appBarLayout,ratio);
    }

    @Override
    public void insertData(String title, String uri,float ratio) {
        toolbar.setTitle(title);
        initAppBarHeight(ratio);
        Picasso.with(this).load(uri).into(imageView);
    }

    @Override
    public void startVideo(Uri uri) {
        videoView.setVideoURI(uri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                presenter.onVideoPrepared();
            }
        });
        videoView.start();
    }

    @Override
    public void animHideImageView(){
        Animator animator = new CircularRevealCreator()
                .closeToOtherView(imageView, fabProgressCircle)
                .setDuration(getResources().getInteger(R.integer.anim_default_duration));
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                presenter.onAnimHideImageViewStart();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                presenter.onAnimHideImageViewEnd();
            }
        });
        animator.start();
    }

    @Override
    public void hideStatusBar() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(lp);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void showFabProgressCircle() {
        fabProgressCircle.show();
    }

    @Override
    public void goneVideoView() {
        videoView.setVisibility(View.GONE);
    }

    @Override
    public void hideFab(){
        fabPlay.hide();
    }

    @Override
    public void hideFabProgressCircle() {
        fabProgressCircle.hide();
    }

    @Override
    public void goneImageView(){
        imageView.setVisibility(View.GONE);
    }
}
