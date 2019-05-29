package com.cxd.chatview.moudle;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * @author CXD
 * @project ChatView
 * @date :2019/5/29 0029 13:09
 * @description:
 *
 * 由于View.class源码第5497~5499行
 * 对background有过滤，所以为了保证ChatView中绘制地正常生效，
 * 在父类ChatLayout中进行手动添加background
 *
 */
public class ChatLayout extends RelativeLayout {
    public ChatLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setBackgroundColor(Color.parseColor("#00000000"));
    }
}
