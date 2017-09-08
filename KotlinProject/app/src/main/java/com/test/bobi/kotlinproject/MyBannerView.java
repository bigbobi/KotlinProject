package com.test.bobi.kotlinproject;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobi on 2017/5/17.
 */

public class MyBannerView<T> extends RelativeLayout {
    private View rootView;
    private ViewPager vpBanner;
    private MyBannerAdapter bannerAdapter;

    private List<String> datas=new ArrayList<>();
//    private List<BannerModel> models = new ArrayList<>();

    private final int NEXT_PAGE=1;//轮询发送的消息

    /**
     * handle接收轮询消息
     */
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case NEXT_PAGE:
                    loopView();
                    break;
                default:
            }
        }
    };

    public MyBannerView(Context context) {
        this(context,null);
    }

    public MyBannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        rootView= LayoutInflater.from(context).inflate(R.layout.item_pic,this);
        vpBanner= (ViewPager) rootView.findViewById(R.id.vp_loop);
        bannerAdapter=new MyBannerAdapter(context);
        initListener();
    }

    private void initListener() {
        vpBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            int currentPosition;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // ViewPager.SCROLL_STATE_IDLE 标识的状态是当前页面完全展现，并且没有动画正在进行中，如果不
                // 是此状态下执行 setCurrentItem 方法回在首位替换的时候会出现跳动！
                if (state != ViewPager.SCROLL_STATE_IDLE){
                    mHandler.removeMessages(NEXT_PAGE);//当还处于滑动中时，取消发送轮询消息
                    return;
                }
                //开启发送轮询消息
                sendLoopMsg();
                // 当视图在第一个时，将页面号设置为图片的最后一张。
                if (currentPosition == 0) {
                    vpBanner.setCurrentItem(datas.size() - 2, false);

                } else if (currentPosition == datas.size() - 1) {
                    // 当视图在最后一个是,将页面号设置为图片的第一张。
                    vpBanner.setCurrentItem(1, false);
                }
            }
        });
    }

    public void setData(List<String> models){
        datas.addAll(models);
        if(models.size()>1){
            datas.add(0,models.get(models.size()-1));
            datas.add(models.get(0));
//            datas.add
        }
        bannerAdapter.setData(datas);
        vpBanner.setOffscreenPageLimit(datas.size());
        vpBanner.setAdapter(bannerAdapter);
        vpBanner.setCurrentItem(1);
//        bannerAdapter.get
        sendLoopMsg();
    }

//    public void setData(List<BannerModel> models, int type) {
//        this.models=models;
//        if(models.size()>1){
//            this.models.add(0,models.get(models.size()-1));
//            this.models.add(models.get(1));
//        }
//        if (isSameList(this.models, modelHistory))
//            return;
//        modelHistory = this.models;
//        bannerAdapter.setData(this.models,type);
//        vpBanner.setOffscreenPageLimit(models.size());
//        vpBanner.setAdapter(bannerAdapter);
//        indicator.setViewPager(vpBanner, true);
//        vpBanner.setCurrentItem(1);
//        sendLoopMsg();
//    }

    private void sendLoopMsg() {
        Message msg=Message.obtain();
        msg.what=NEXT_PAGE;
        mHandler.sendMessageDelayed(msg,500);
    }

    private void loopView() {
        if(vpBanner.getCurrentItem()<datas.size()-1){
            vpBanner.setCurrentItem(vpBanner.getCurrentItem()+1);
        }
        sendLoopMsg();
    }


    public void start(){
        sendLoopMsg();
    }

    public void stop(){
        mHandler.removeMessages(NEXT_PAGE);
    }

    public void drawCard(){
        bannerAdapter.notifyDataSetChanged();
    }
}
