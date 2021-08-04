package Day18;
/*
我们使用线程的时候就去创建一个线程，这样实现起来非常简便，但是就会有一个问题：
  如果并发的线程数量很多，并且每个线程都是执行一个时间很短的任务就结束了，这样频繁创建线程就会
  大大降低 系统的效率，因为频繁创建线程和销毁线程需要时间。
  那么有没有一种办法使得线程可以复用，就是执行完一个任务，并不被销毁，而是可以继续执行其他的
  任务？
  在Java中可以通过线程池来达到这样的效果。今天我们就来详细讲解一下Java的线程池。


线程池概念
    线程池：其实就是一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的
      操作， 无需反复创建线程而消耗过多资源

合理利用线程池能够带来三个好处：
   1. 降低资源消耗。减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
   2. 提高响应速度。当任务到达时，任务可以不需要的等到线程创建就能立即执行。
   3. 提高线程的可管理性。可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为消耗
      过多的内 存，而把服务器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大
      ，最后死机)。
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class XianChengChi_ {
    public static void main(String[] args) {
        /*
Java里面线程池的顶级接口是 java.util.concurrent.Executor ，但是严格意义上讲 Executor 并不是一个线程池，
而只是一个执行线程的工具。真正的线程池接口是 java.util.concurrent.ExecutorService 。

要配置一个线程池是比较复杂的，尤其是对于线程池的原理不是很清楚的情况下，很有可能配置的线程池不是较优的
    ，因此在 java.util.concurrent.Executors 线程工厂类里面提供了一些静态工厂，生成一些常用的线程池。
    官 方建议使用Executors工程类来创建线程池对象。

Executors类中有个创建线程池的方法如下：
    public static ExecutorService newFixedThreadPool(int nThreads) ：返回线程池对象。(创建的是有界线
     程池,也就是池中的线程个数可以指定最大数量)
    获取到了一个线程池ExecutorService 对象，那么怎么使用呢，在这里定义了一个使用线程池对象的方法如下：
     public Future<?> submit(Runnable task) :获取线程池中的某一个线程对象，并执行 Future接口：
        用来记录线程任务执行完毕后产生的结果。

 使用线程池中线程对象的步骤：
     1. 创建线程池对象。
     2. 创建Runnable接口子类对象。(task)
    3. 提交Runnable接口子类对象。(take task)
    4. 关闭线程池(一般不做)。
         */
        ExecutorService service = Executors.newFixedThreadPool(2);
        MyRunable_ my = new MyRunable_();

        service.submit(my);
        service.submit(my);
        service.submit(my);
        service.submit(my);
        service.shutdown();
    }
}
