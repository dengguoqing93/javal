###使用分支/合并框架的最佳做法
    1.对一个任务调用join方法会阻塞调用方，直到该任务作出结果。因此有必要在两个子任务的计算都开始之后再调用它。
    2.不应该在RecursiveTask内部使用ForkJoinPool的invoke方法。相反，应该始终直接调用compute或fork方法
    只有顺序代码才应该用invoke来启动并行计算
    3.对子任务调用fork方法可以把它排进ForkJoinPool。同时对左边和右边的子任务调用要比直接对其中一个调用compute
    低。