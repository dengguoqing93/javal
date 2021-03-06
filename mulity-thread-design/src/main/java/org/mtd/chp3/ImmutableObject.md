##Immutable Object(不可变对象模式)

#### 一个严格意义上的不可变对象要满足以下所有条件

+ 类本身使用final修饰，防止其子类改变其定义的行为
+ 所有字段都是用final修饰的：使用final修饰不仅仅是从语义上说明修饰字段的引用不可变
- 在对象的创建过程中，this关键字没有泄露给其他类，防止其他类在对象创建过程中修改器状态
- 任何字段若引用了其他状态可变的对象，则这些字段必须是private修饰的，并且这些字段值不能对外暴露。
若有相关方法要求返回这些字段值，应该进行防御性复制

#### 适用场景
+ 被建模对象的状态变化不频繁
+ 同时对一组相关的数据进行写操作，因此需要保证原子性
+ 适用摸个对象作为安全的HashMap的Key

#### 主要问题
+ 被建模对象的状态变更比较频繁
+ 适用等效或者近似的不可变对象
+ 防御性复制