package com.luania.qingke.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luania.qingke.R;
import com.luania.qingke.activities.video.VideoActivity;
import com.luania.qingke.adapters.viewHolders.CtoViewHolder;
import com.luania.qingke.adapters.viewHolders.HeaderViewHolder;
import com.luania.qingke.utils.ui.measure.ViewRatioChanger;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by luania on 16/7/27.
 */
public class CtoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;

    private Context context;

    String[] uris = {"http://7xjubq.com1.z0.glb.clouddn.com/39_1446351376_500x500.png.jpg"
            , "http://7xjubq.com1.z0.glb.clouddn.com/33_GGG.jpg"
            , "http://7xjubq.com1.z0.glb.clouddn.com/32_11221423.jpg"
            , "http://7xjubq.com1.z0.glb.clouddn.com/31_c.png"};
    String[] titles = {"聚牛讲堂：轻课网CTO牛气冲天！！！"
            , "如何达到百万年薪，细说那些你所不知道的秘密▏杭师大特别篇"
            , "房费减半的爱情公寓弱爆了，大QK公寓房费全免啦！！"
            , "进击的轻课|高校巡回演讲第三波之科技学院篇"};
    String[] messages = {"聚牛讲堂第四期——轻课网CTO分享高并发高可用网站系统嘉宾介绍李彦强，曾任支付宝技术专家，现担任轻课网CTO，杭州市经济信息人才理事。毕业于浙江大学计算机学院，12年软件开发，构架和团队管理经验，主导开发过多个金融、电商软件平台，和App系统。主导开发的App正品折扣获得数百万的下载量。擅长Java,Ruby,iOS等多种编程技术。国内首批IOS技术开发者，开发APP产品近30款，有丰富的团队组建和团队管理经验，组建和管理了开发，构架，系统分析，UED，数据分析等多个团队。分享内容和大家一起探讨和梳理构建高并发，高可用网站系统在不同层面上的常用方法和要点。"
            , "进击的轻课轻课网在杭师大展开的历时5天的征途结束啦。参与的同学们每天都准时到达，一张张脸上都写上了认真二字，在期末考试后不去想着休闲放松，而是跟随轻课网讲师一起探究JAVA开发的林林总总。真是让小编深受感动呢，那么这些天同学们都经历了什么呢？来，来，FOLLOWME，跟着小编的节奏一起回顾吧~授课轻课网的师资队伍可谓强大，15年Java经验的前阿里巴巴资深专家Micro，两位5年以上大型金融机构Java架构师经验的讲师，三位企业界的专家轮番上阵，给同学们讲授IT名企对Java技术的需求，帮助同学们迅速踏入职业通道的快车道。精彩纷呈，妙语连篇，同学们，笑的合"
            , "还记得那个“情侣入住，房租减半，水电全免”的爱情公寓吧？小编一直畅想着什么时候能够住进这样一栋房租减半的公寓。可是今天老板发了一句话，QK公寓全免费，一下子颠覆了小编对公寓的认知了。老板啊老板，为啥要把条件那么好的学员公寓全免费呢？老板说了一句话，还是轻课网的理念啊：一切为了学员的未来。如今的一个准大四狗是这样思考滴：暑假来了，快要毕业工作全没着落。G20又来捣乱，学校不让住外面房租又太高，难道只能在家安度暑假？伦家也是个努力奋斗小青年好伐。租房，租房，哪里能找到好房子，安下心来努力学习啊？找一个靠谱的房子有多么的难。你有没有过一整天跑到城市的另一端只为看"
            , "高校巡回演讲已经顺利完成第三波，收获了满满的粉丝和追捧，我们几位老师每天都需要回答好多编程方面的问题呢~接下来让我们一起来回顾一下这周二的现场表现吧~这次的主讲人依然有幸请到了君强科技创始人Henry韩伟先生那这一次的讲座又给我们带来了哪些不一样的干货分享呢？让小编带你们来重温一次讲座吧！选择大于努力“一份工作是否有好的发展，并不完全在于你付出了多少努力，更重要的是一开始就要做出一个更加合适的选择”韩总如是说道。在讲座上，韩总分析了几个比较具体典型的例子，给学生说明了对企业进行筛选是多么重要。所以同学们找工作之前一定要擦亮双眼，不要被眼前的利益迷惑了眼睛哦"};

    public CtoAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return 11;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_cto_header, parent, false);
            viewHolder = new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_cto, parent, false);
            viewHolder = new CtoViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            bindHeader((HeaderViewHolder) holder);
            return;
        }
        bind((CtoViewHolder) holder, position + 1);
    }

    boolean timed = false;

    private void bindHeader(final HeaderViewHolder headerViewHolder) {
        final ViewPager viewPager = headerViewHolder.viewPager;
        viewPager.setAdapter(new ImageAdapter(context));
        ViewRatioChanger.changeHeight(viewPager, 425f / 960);
        if (!timed) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        }
                    });
                }
            }, 2000, 2000);
            timed = true;
        }
    }

    private void bind(final CtoViewHolder ctoViewHolder, int position) {
        final ImageView imageView = ctoViewHolder.imageView;
        final int dataPosition = position % 4;
        ViewRatioChanger.changeHeight(imageView, 3f / 4);
        Picasso.with(context).load(uris[dataPosition]).into(ctoViewHolder.imageView);
        ctoViewHolder.textView.setText(titles[dataPosition]);
        ctoViewHolder.textViewMessage.setText(messages[dataPosition]);

        ctoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("uri", uris[dataPosition]);
                bundle.putString("title", titles[dataPosition]);
                intent.putExtras(bundle);
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                context.startActivity(intent, activityOptions.toBundle());
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }
}
