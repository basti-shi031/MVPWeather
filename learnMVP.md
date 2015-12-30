# Android开发中的MVP模式
## 主要目的
把UI展示和逻辑分开

## 具体说明
M:Model 1.为UI提供数据 2.并保存UI的数据

V:View 1.展示数据 2.相应相应用户的操作（click、touch等）并交给Presenter处理

P:Presenter 负责逻辑控制 1.从UI层取数据、运算、转化，并有View展示 2.处理View层传过来的事件

## 关系图
View <=====>Presenter<=====>Model

## 约束条件
1.View和Model不能直接通信，必须通过Presenter，Presenter担任中间人的角色进行协调和调度

2.Model和View是接口，Presenter持有的是一个Model接口和View接口

3.Model和View都是被动的，有Presenter主导一切

4.Model应该把与业务逻辑层的交互封装掉，及Presenter和View不应该知道业务逻辑层

5.View的逻辑应该尽可能简单，不应该有状态。当事件发生时，调用Presenter处理，且不穿参数，Presenter处理时在调用View的方法获取

## MVP和MVC的区别
MVC模式中，逻辑放在了Model中，Controller负责联接View和Model，View发生变化时，通知Controller，Controller再去通知Model，由Model进行逻辑处理，更新数据，通知View刷新。

MVP在此基础上做出了改进：

1.逻辑放在Presenter中

2.View和Model抽象成接口

这样的好处是:
1.代码更容易移植
2.代码更容易单元测试
