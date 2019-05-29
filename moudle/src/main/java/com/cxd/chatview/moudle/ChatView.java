package com.cxd.chatview.moudle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;

/**
 * @author CXD
 * @date :2019/4/16 0016 10:02
 * @description:
 *
 * 这是一个自定义的聊天气泡view 
 * 包含箭头（方向、宽高），view（颜色、边框、圆角、press时颜色变化）等设置
 *
 */


@SuppressLint("AppCompatCustomView")
public class ChatView extends ChatLayout {
    /**
     * 箭头所在的方位（相对于view中心点而言）
     */
    private String arrowDirection = "left";

    /**
     * 箭头是否在中间
     */
    private boolean isArrowCenter = false ;

    /**
     * 箭头的宽度 （px）
     */
    private int arrowWidth = 15;

    /**
     * 箭头的高度 (px)
     */
    private int arrowHeight = 30;

    /**
     * 气泡view是否有描边
     */
    private boolean hasStroke = false ;

    /**
     * 气泡描边的线的宽度 （px）
     */
    private int strokeWidth = 3 ;

    /**
     * 箭头距离view顶部的距离（px）
     */
    private int arrowUpDistance = 50;

    /**
     * view的圆角半径 （px）
     */
    private int connerRadius = 40;

    /**
     * nomal描边颜色，默认边框灰色
     */
    private int strokeColor = Color.parseColor("#CCCCCC");

    /**
     * nomal内填充颜色，默认填充是淡蓝色
     */
    private int  fillColor = Color.parseColor("#66CCFF");

    /**
     * press时view的内填充颜色，默认与nomal同色
     */
    private int pressStrokeColor = strokeColor;

    /**
     * press时view内填充颜色，默认灰色
     */
    private int pressFillColor = strokeColor;




    public ChatView(Context context, AttributeSet attrs) {
        super(context, attrs);

        /*在这里关联自定义属性*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.chat);
        isArrowCenter = typedArray.getBoolean(R.styleable.chat_is_arrow_center,false);
        hasStroke = typedArray.getBoolean(R.styleable.chat_has_stroke,false);
        strokeWidth = typedArray.getDimensionPixelSize(R.styleable.chat_stroke_width,3);
        arrowDirection = typedArray.getString(R.styleable.chat_arrow_direction);
        arrowUpDistance = typedArray.getDimensionPixelSize(R.styleable.chat_arrow_up_distance,50);
        connerRadius = typedArray.getDimensionPixelSize(R.styleable.chat_conner_radius,40);
        strokeColor = typedArray.getColor(R.styleable.chat_stroke_color,strokeColor);
        fillColor = typedArray.getColor(R.styleable.chat_fill_color,fillColor);
        pressStrokeColor = typedArray.getColor(R.styleable.chat_press_stroke_color,pressStrokeColor);
        pressFillColor = typedArray.getColor(R.styleable.chat_press_fill_color,pressFillColor);

        arrowWidth = typedArray.getDimensionPixelSize(R.styleable.chat_arrow_width,15);
        arrowHeight = typedArray.getDimensionPixelSize(R.styleable.chat_arrow_height,30);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /*实际绘图方法，使用canvas*/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.setBackground(getSelectorBackground());
    }

    /*设置点击特效*/
    public  StateListDrawable getSelectorBackground(){
        //初始化一个空对象
        StateListDrawable stalistDrawable = new StateListDrawable();

        //获取对应的属性值 Android框架自带的属性 attr
        ChatShape nomalShape = new ChatShape(arrowWidth,arrowHeight,isArrowCenter,strokeWidth,
                arrowDirection,arrowUpDistance,connerRadius,strokeColor,fillColor);
        ChatShape pressShape = new ChatShape(arrowWidth,arrowHeight,isArrowCenter,strokeWidth,
                arrowDirection,arrowUpDistance,connerRadius,pressStrokeColor,pressFillColor);


        int pressed = android.R.attr.state_pressed;

        stalistDrawable.addState(new int []{pressed}, new ShapeDrawable(pressShape));
        /*没有任何状态时显示的背景*/
        stalistDrawable.addState(new int []{},  new ShapeDrawable(nomalShape));

        return stalistDrawable;
    }


}



