package com.luania.qingke.adapters.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luania.qingke.R;

public class CtoViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;
    public TextView textViewMessage;

    public CtoViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        textView = (TextView) itemView.findViewById(R.id.textView);
        textViewMessage = (TextView) itemView.findViewById(R.id.textViewMessage);
    }
}
