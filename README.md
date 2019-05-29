# ChatView
自定义的聊天气泡View，内部可以添加子View

### 截图预览（Screen Recrod）
<img  width = "400" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/onclick.gif"></img>
<img  width = "400" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/longclick.gif"></img>
<img  width = "400" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/chat_screen.jpg"></img>
<img  width = "400" src = "https://github.com/bigdongdong/ChatView/blob/master/preview/chat_screen2.jpg"></img>

### 项目配置（Gradle Dependency）

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
