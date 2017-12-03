package com.bwei.myfalor;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * author:Created by QiZhiWei on 2017/12/2.
 */

public class TitleTest extends FrameLayout implements ViewPager.OnPageChangeListener {

    private Context context;
    private int totalCount=100;
    private int showCount=4;
    private int currentPosition=0;
    private ViewPager voLb;
    private LinearLayout llDot;
    private int pageotemWidth;
    private Boolean isUserTpuchedd=false;
    //定义一个接口让外部设置展示的View
    public interface Adapter{
        boolean isEmpty();
        View getView(int position);
        int getCount();
    }

    public TitleTest(Context context) {
        this(context,null);
        this.context=context;
    }

    public TitleTest(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
        this.context=context;
    }

    public TitleTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item1, null, false);
        voLb = (ViewPager)inflate.findViewById(R.id.vp_lb);
        llDot = (LinearLayout)inflate.findViewById(R.id.ll_dot);
        pageotemWidth=5;
        voLb.addOnPageChangeListener(this);
        addView(inflate);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
