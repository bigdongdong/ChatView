package com.cxd.chatview.moudle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;
import android.util.Log;

/**
 * @author CXD
 * @project ChatView
 * @date :2019/5/29 0029 9:50
 * @description:
 *
 * 自定义气泡的shape背景
 */
class ChatShape extends Shape {
    /**
     * 箭头所在的方位（相对于view中心点而言）
     */
    private String arrowDirection;

    /**
     * 箭头是否在中间
     */
    private boolean isArrowCenter ;

    /**
     * 箭头的宽度 （px）
     */
    private int arrowWidth ;

    /**
     * 箭头的高度 (px)
     */
    private int arrowHeight;

    /**
     * 气泡view是否有描边
     */
    private boolean hasStroke;

    /**
     * 气泡描边的线的宽度 （px）
     */
    private int strokeWidth ;

    /**
     * 箭头距离view顶部的距离（px）
     */
    private int arrowUpDistance ;

    /**
     * view的圆角半径 （px）
     */
    private int connerRadius ;

    /**
     * 描边颜色
     */
    private int strokeColor ;

    /**
     * 内填充颜色
     */
    private int  fillColor ;


    /*以下是默认设置，修正值为3F*/
    final float reviseValue = 3F; //向内修正值
    final float widthStart = reviseValue;
    final float heightStart = reviseValue;

    /*以下是绘制时需要使用的变量*/

    float width,height;  //测量得到的view的长宽
    float widthEnd ;   //减去修正值后，view右侧边界的坐标
    float heightEnd ;  //减去修正值后，view底部边界的坐标

    Path strokePath = new Path(); //边框path
    Path fillPath = new Path();  //填充path

    /*全部设置的constructor*/
    public ChatShape(int arrowWidth, int arrowHeight, boolean isArrowCenter,
                     int strokeWidth, String arrowDirection, int arrowUpDistance,
                     int connerRadius, int strokeColor, int fillColor) {
        this.arrowWidth = arrowWidth;
        this.arrowHeight = arrowHeight;
        this.isArrowCenter = isArrowCenter;
        this.strokeWidth = strokeWidth;
        this.arrowDirection = arrowDirection;
        this.arrowUpDistance = arrowUpDistance;
        this.connerRadius = connerRadius;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
    }
    private void resizePath(float width, float height, Path path){
        widthEnd = width - widthStart;
        heightEnd = height - widthStart;
        if(isArrowCenter){
            arrowUpDistance = (int) (height/2-arrowHeight/2);//箭头居中设置
        }

        /*圆角的rect*/
        RectF connerRect = new RectF();

        path.reset();
        /*绘制箭头*/
        path.moveTo(widthStart+arrowWidth, arrowUpDistance+arrowHeight);
        path.lineTo(widthStart, arrowUpDistance+arrowHeight/2);
        path.lineTo(widthStart+arrowWidth, arrowUpDistance);
        /*绘制左上方直线*/
        path.lineTo(widthStart+arrowWidth, connerRadius);
        /*绘制左上方圆角*/
        connerRect.set(widthStart+arrowWidth,heightStart,widthStart+arrowWidth+connerRadius,connerRadius);
        path.arcTo(connerRect, 180,90);
        /*上方直线边框*/
        path.lineTo(width-connerRadius, heightStart);
        /*右上方圆角*/
        connerRect.set(width-connerRadius,heightStart,width,connerRadius);
        path.arcTo(connerRect, 270,90);
        /*右侧直线*/
        path.lineTo(width, height-connerRadius);
        /*右下方圆角*/
        connerRect.set(width-connerRadius,height-connerRadius,width,height);
        path.arcTo(connerRect, heightStart,90);
        /*下方直线*/
        path.lineTo(widthStart+arrowWidth+connerRadius, height);
        /*左下角圆角*/
        connerRect.set(widthStart+arrowWidth,height-connerRadius,widthStart+arrowWidth+connerRadius,height);
        path.arcTo(connerRect, 90,90);
        /*闭合路径*/
        path.close();

    }

    @Override
    protected void onResize(float width, float height) {
        super.onResize(width, height);
        this.width = width;
        this.height = height;
        /*测量外部的path
         * 以及内部填充颜色*/
        resizePath(width-3, height-3 ,strokePath);
        resizePath(width-3, height-3 ,fillPath);

    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        /*记录画布*/
        canvas.save();

        /*如果箭头向右，则将画布翻转*/
        if(arrowDirection.equals("right")){
            /*以中间点进行画布翻转*/
            canvas.scale(-1,1,width/2,height/2);
        }
        /*先绘制填充 然后绘制边框  否则边框会被遮盖*/

        /*绘制填充*/
        drawFill(canvas, paint);
        /*绘制边框*/
        drawStroke(canvas, paint);
        /*还原画布*/
        canvas.restore();
    }



    /*边框的paint*/
    private void drawStroke(Canvas canvas, Paint paint) {
        paint.setColor(strokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(strokeWidth);

        canvas.drawPath(strokePath, paint);
    }
    /*填充的paint*/
    private void drawFill(Canvas canvas, Paint paint) {
        paint.setColor(fillColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);//抗锯齿
        paint.setDither(true);//抖动
        paint.setStrokeWidth(strokeWidth);

        canvas.drawPath(fillPath, paint);
    }
}