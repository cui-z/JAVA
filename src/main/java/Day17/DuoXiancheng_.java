package Day17;
/*
Thread类
   在上一天内容中我们已经可以完成最基本的线程开启，那么在我们完成操作过程中用到了
   java.lang.Thread 类， API中该类中定义了有关线程的一些方法，具体如下：
   构造方法：
        public Thread() :分配一个新的线程对象。
        public Thread(String name) :分配一个指定名字的新的线程对象。
        public Thread(Runnable target) :分配一个带有指定目标新的线程对象。
        public Thread(Runnable target,String name) :分配一个带有指定目标新的线程对象并指定名字。
   常用方法：
        public String getName() :获取当前线程名称。
        public void start() :导致此线程开始执行; Java虚拟机调用此线程的run方法。
        public void run() :此线程要执行的任务在此处定义代码。
        public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
        public static Thread currentThread() :返回对当前正在执行的线程对象的引用。
 翻阅API后得知创建线程的方式总共有两种，一种是继承Thread类方式，一种是实现Runnable接口方式，
    方式一我 们上一天已经完成，接下来讲解方式二实现的方式。
创建线程方式二 采用 java.lang.Runnable 也是非常常见的一种，我们只需要重写run方法即可。 步骤如下：
     1. 定义Runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程
          执行体。
     2. 创建Runnable实现类的实例，并以此实例作为Thread的target来创建Thread对象，
         该Thread对象才是真正 的线程对象。
     3. 调用线程对象的start()方法来启动线程。
 */

public class DuoXiancheng_ {
    public static void main(String[] args) {
        //创建自定义的类对象
        MyRunnable_ my = new MyRunnable_();
        //创建线程对象
        Thread t = new Thread(my,"小强");
        t.start();
        for(int i = 0;i<10;i++){
            System.out.println("旺财 "+i);
        }
        /*
通过实现Runnable接口，使得该类有了多线程类的特征。run()方法是多线程程序的一个执行
   目标。所有的多线程 代码都在run方法里面。Thread类实际上也是实现了Runnable接口的
   类。 在启动的多线程的时候，需要先通过Thread类的构造方法Thread(Runnable target)
    构造出对象，然后调用Thread 对象的start()方法来运行多线程代码。 实际上所有的多
    线程代码都是通过运行Thread的start()方法来运行的。因此，不管是继承Thread类还是
    实现 Runnable接口来实现多线程，最终还是通过Thread的对象的API来控制线程的，熟
    悉Thread类的API是进行多线程 编程的基础。
tips:Runnable对象仅仅作为Thread对象的target，Runnable实现类里包含的run()方法仅作
   为线程执行体。 而实际的线程对象依然是Thread实例，只是该Thread线程负责执行其
   target的run()方法。
         */





        /*
Thread和Runnable的区别
    如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。
总结： 实现Runnable接口比继承Thread类所具有的优势：
     1. 适合多个相同的程序代码的线程去共享同一个资源。
     2. 可以避免java中的单继承的局限性。
     3. 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
      4. 线程池只能放入实现Runable或Callable类线程，不能直接放入继承Thread的类。
 扩充：在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。因为每当使用
     java命令执行一个类的时候，实际上都会启动一个JVM，每一个JVM其实在就是在操作系统中启动了一
     个进程。
         */

        /*
匿名内部类方式实现线程的创建
    使用线程的内匿名内部类方式，可以方便的实现每个线程执行不同的线程任务操作。
    使用匿名内部类的方式实现Runnable接口，重新Runnable接口中的run方法：
         */

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("张宇 "+i);
                }
            }
        };
        new Thread(r).start();

    }
}
