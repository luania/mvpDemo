package com.luania.qingke.activities.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.luania.qingke.R;
import com.luania.qingke.activities.base.BaseActivity;
import com.luania.qingke.utils.ui.animations.CircularRevealCreator;

public class SearchActivity extends BaseActivity implements SearchView {
    private LinearLayout searchLayout;
    private View backgroundView;
    private FrameLayout backView;

    private SearchViewListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);
        listener = new SearchPresenter(this);
        findViews();
        initEvent();
    }

    private void findViews() {
        backView = (FrameLayout) findViewById(R.id.backView);
        backgroundView = findViewById(R.id.backgroundView);
        searchLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    private void initEvent() {
        searchLayout.post(new Runnable() {
            @Override
            public void run() {
                listener.onSearchLayoutPost();
            }
        });
        View.OnClickListener closeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClose();
            }
        };
        backgroundView.setOnClickListener(closeListener);
        backView.setOnClickListener(closeListener);
    }

    @Override
    public void animOpenSearchLayout() {
        new CircularRevealCreator()
                .openFromRightTop(searchLayout)
                .setDuration(200)
                .start();
    }

    @Override
    public void animCloseSearchLayout() {
        Animator animator = new CircularRevealCreator()
                .closeToRightTop(searchLayout)
                .setDuration(200);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                listener.onCloseSearchLayoutEnd();
            }
        });
        animator.start();
    }

    @Override
    public void goneSearchLayout() {
        searchLayout.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        listener.onClose();
    }
}
