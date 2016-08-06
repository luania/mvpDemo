package com.luania.qingke.utils.ui.measure;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by luania on 16/8/5.
 */
public class ViewRatioChanger {
    public static void changeHeight(final View view, final float ratio) {
        view.post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = (int) (view.getWidth() * ratio);
                view.setLayoutParams(layoutParams);
            }
        });
    }
}
