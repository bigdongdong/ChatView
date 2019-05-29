# ChatView
自定义的聊天气泡View，内部可以添加子View，可以附带边框，圆角

# 截图预览（Screen Recrod）
<img  width = "450" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/simple_demo0.jpg"></img></br>
<img  width = "450" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/simple_demo2.jpg"></img></br>
<img  width = "350" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/onclick.gif"></img>
<img  width = "350" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/longclick.gif"></img></br>
<img  width = "350" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/chat_screen.jpg"></img>
<img  width = "350" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/chat_screen2.jpg"></img>

# 项目配置

```
  allprojects {
      repositories {
          ...
          maven { url 'https://jitpack.io' }  //添加jitpack仓库
      }
  }
  
  dependencies {
	  implementation 'com.github.bigdongdong:ChatView:1.0' //添加依赖
  }
```

# 属性说明
```xml
xmlns:chat="http://schemas.android.com/apk/res-auto"
        chat:arrow_direction="left"
        chat:is_arrow_center="true"
        chat:arrow_up_distance = "10dp"
        chat:arrow_width = "5dp"
        chat:arrow_height = "12dp"
        chat:stroke_width = "1px"
        chat:stroke_color = "#FFFFFF"
        chat:fill_color = "#FFFFFF"
        chat:press_stroke_color = "#50111111"
        chat:press_fill_color = "#50111111"
	chat:conner_radius = "6dp"
```

|属性名称|解释|是否必须|备注|
|:---|:---|:---|:---|
|arrow_direction|箭头方向（left/right）|**是**|
|is_arrow_center|箭头是否居中（true/false）|**是**|
|arrow_up_distance|箭头距离view顶部距离|否|仅在is_arrow_center为false时生效|
|arrow_width|箭头的宽度|**是**|
|arrow_height|箭头的高度|**是**|
|stroke_width|view的边框宽度|否|
|stroke_color|view的边框颜色|否|
|fill_color|view填充颜色|否|
|press_stroke_color|按下时view边框颜色|否|
|press_fill_color|按下时view填充颜色|否|
|conner_radius|view四周圆角半径|否|如果不设置这一属性，则圆角半径默认为40px;若不想要圆角，请将该属性设置为0dp|

***以上属性，再配合上padding使用，效果更佳**

# 实例展示
```xml
    <com.cxd.chatview.moudle.ChatView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"

        android:paddingTop="10dp"
        android:paddingBottom="10dp"
        android:paddingLeft="15dp"
        android:paddingRight="10dp"
        android:layout_marginRight="30dp"

        xmlns:chat="http://schemas.android.com/apk/res-auto"
        chat:arrow_direction="left"
        chat:is_arrow_center="true"
        chat:arrow_up_distance = "10dp"
        chat:arrow_width = "5dp"
        chat:arrow_height = "12dp"
        chat:stroke_width = "1px"
        chat:stroke_color = "#FFFFFF"
        chat:fill_color = "#FFFFFF"
        chat:press_stroke_color = "#50111111"
        chat:press_fill_color = "#50111111"
        chat:conner_radius = "6dp"
        >
        <TextView
            android:textSize="16dp"
            android:layout_centerVertical="true"
            android:id="@+id/text"
            android:text="这是箭头向左的聊天气泡"
            android:textColor="#4a4a4a"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </com.cxd.chatview.moudle.ChatView>
```
### 效果图
<img  width = "450" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/simple_demo.jpg"></img></br>
