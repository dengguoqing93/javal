###流简介
    流：从支持数据处理操作的源生成的元素序列
    集合讲的是数据，流讲的是计算

###流的特点
    流水线--很多流操作本身会返回一个流，这样多个操作就可以链接起来，形成一个大的流水线
    流水线的操作可以看做对数据库对数据源进行数据库式查询
    内部迭代--流的迭代操作是在背后进行的
   
###流的常用操作
    用filter、distinct、skip、limit对流做筛选和切片
    用map和flatMap提取或转换流中的元素
    用findFirst和findAny方法查找流中的元素。用allMatch、noneMatch和anyMatch方法让流匹配给定的谓词
    以上方法都利用了短路
    用reduce方法将流中的所有元素迭代合并成一个结果
    filter和map等操作是无状态的；reduce等操作要存储状态才能计算出一个值。sorted和distinct等操作也存储状态
    因为这些 操作需要把流中的所有元素缓存起来才能返回一个新的流。这种操作称为有状态操作
    流有三种基本的原始类型特化：IntStream、DoubleStream和LongStream
    流不仅可以从集合创建，也可以从值、数组、文件以及iterate与generate等特定方法创建
    