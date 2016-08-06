#### 第一个mvpDemo
* 只对activity做了mvp分层
* 把activity做成了一个更广义的view，其实可以理解为一个大的自定义view
* 把所有的业务逻辑代码放到了Presenter层
* 原来打算在基类中泛型封装Presenter的绑定，后来觉得一个activity可以绑定多个Presenter更合理
