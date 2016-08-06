package com.luania.qingke.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luania.qingke.R;
import com.luania.qingke.activities.video.VideoActivity;
import com.luania.qingke.utils.ui.measure.ViewRatioChanger;
import com.squareup.picasso.Picasso;

/**
 * Created by luania on 16/7/27.
 */
public class PublicAdapter extends RecyclerView.Adapter<PublicAdapter.ViewHolder> {
    private Context context;

    String[] uris = {"http://7xjubq.com1.z0.glb.clouddn.com/90_page1-1.png"
            , "http://7xjubq.com1.z0.glb.clouddn.com/89_page1-2.png"
            , "http://7xjubq.com1.z0.glb.clouddn.com/88_page1-3.png"
            , "http://7xjubq.com1.z0.glb.clouddn.com/87_page1-4.png"};
    String[] titles = {"使用UIActionSheet实现提示弹出框"
            , "svg从零开始－基本的svg元素"
            , "svg从零开始－课程简介"
            , "轻松学UIGestureRecognizer #7 - 边缘拖动手"};

    public PublicAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_public, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final int dataPosition = position % 4;
        final ImageView imageView = holder.imageView;
        imageView.post(new Runnable() {
            @Override
            public void run() {
                ViewRatioChanger.changeHeight(imageView, 9f / 16);
            }
        });
        Picasso.with(context).load(uris[dataPosition]).into(imageView);
        holder.textView.setText(titles[dataPosition]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("uri", uris[dataPosition]);
                bundle.putString("title",titles[dataPosition]);
                intent.putExtras(bundle);
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                context.startActivity(intent, activityOptions.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
