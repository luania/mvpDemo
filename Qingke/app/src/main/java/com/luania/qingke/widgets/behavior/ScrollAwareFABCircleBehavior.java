package com.luania.qingke.widgets.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import com.github.jorgecastilloprz.FABProgressCircle;
import com.luania.qingke.R;

public class ScrollAwareFABCircleBehavior extends CoordinatorLayout.Behavior<FABProgressCircle> {
    public ScrollAwareFABCircleBehavior(Context context, AttributeSet attrs) {
        super();
    }

    private CollapsingToolbarLayoutState state;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FABProgressCircle child, View dependency) {
        if(dependency instanceof AppBarLayout){
            AppBarLayout appBarLayout = (AppBarLayout)dependency;
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                    if (verticalOffset == 0) {
                        if (state != CollapsingToolbarLayoutState.EXPANDED) {
                            state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
                        }
                    } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                        if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                            state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
                        }
                    } else {
                        if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                            state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                        }
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FABProgressCircle child, View dependency) {
        if(state == CollapsingToolbarLayoutState.EXPANDED){
            ((FloatingActionButton) child.findViewById(R.id.fab)).show();
        }else{
            ((FloatingActionButton) child.findViewById(R.id.fab)).hide();
        }
        return true;
    }
}