#### 第一个demo不舒服的地方
* presenter对象的创建在activity(view)中
* presenter中直接调用view层的方法


#### 第二个mvpDemo
* 只对activity做了mvp分层
* 所以把activity中的view相关代码也分离出去，
* activity作为一个连接层连接presenter和view的互相调用



