package Day17;
/*
如果有多个线程在同时运行，而这些线程可能会同时运行这段代码。程序每次运行结果和单线程运行的结果
    是一样 的，而且其他的变量的值也和预期的是一样的，就是线程安全的。
我们通过一个案例，演示线程的安全问题：
    电影院要卖票，我们模拟电影院的卖票过程。假设要播放的电影是 “葫芦娃大战奥特曼”，本次电影
    的座位共100个 (本场电影只能卖100张票)。 我们来模拟电影院的售票窗口，实现多个窗口同时卖
    “葫芦娃大战奥特曼”这场电影票(多个窗口一起卖这100张票) 需要窗口，采用线程对象来模拟；
    需要票，Runnable接口子类来模拟
 */
public class XianChengAnQuan_ {
    public static void main(String[] args) {
        //线程不安全例子
        Sell_Ticket st = new Sell_Ticket();
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("============================");
        /*
发现程序出现了两个问题：
     1. 相同的票数,比如5这张票被卖了两回。
     2. 不存在的票，比如0票与-1票，是不存在的。
这种问题，几个窗口(线程)票数不同步了，这种问题称为线程不安全。
    线程安全问题都是由全局变量及静态变量引起的。若每个线程中对全局变量、静态变量只有读操作
    ，而无写 操作，一般来说，这个全局变量是线程安全的；若有多个线程同时执行写操作，一般都
    需要考虑线程同步， 否则的话就可能影响线程安全。
         */


        /*
线程同步
    当我们使用多个线程访问同一资源的时候，且多个线程中对资源有写的操作，就容易出现线程安
    全问题。 要解决上述多线程并发访问一个资源的安全性问题:也就是解决重复票与不存在票问题
    ，Java中提供了同步机制 (synchronized)来解决。
根据案例简述：
    窗口1线程进入操作的时候，窗口2和窗口3线程只能在外等着，窗口1操作结束，窗口1和窗口2和
    窗口3才有机会进入代码 去执行。也就是说在某个线程修改共享资源的时候，其他线程不能修改
    该资源，等待修改完毕同步之后，才能去抢夺CPU 资源，完成对应的操作，保证了数据的同步性
    ，解决了线程不安全的现象。
为了保证每个线程都能正常执行原子操作,Java引入了线程同步机制。
    那么怎么去使用呢？有三种方式完成同步操作：
    1. 同步代码块。
     2. 同步方法。
     3. 锁机制。
         */

        /*
同步代码块：
    synchronized 关键字可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。 格式:
    synchronized(同步锁){
       需要同步操作的代码
       }
同步锁: 对象的同步锁只是一个概念,可以想象为在对象上标记了一个锁.
     1. 锁对象 可以是任意类型。
     2. 多个线程对象 要使用同一把锁。
    注意:在任何时候,最多允许一个线程拥有同步锁,谁拿到锁就进入代码块,其他的线程只能在外等着 (BLOCKED)。
         */
        TongBuDaiMaKuai_ticket_ tb = new TongBuDaiMaKuai_ticket_();
        Thread tb1 = new Thread(tb,"同步窗口1");
        Thread tb2 = new Thread(tb,"同步窗口2");
        Thread tb3 = new Thread(tb,"同步窗口3");
        tb1.start();
        tb2.start();
        tb3.start();
        System.out.println("================================");


        /*
同步方法:
    使用synchronized修饰的方法,就叫做同步方法,保证A线程执行该方法的时候,其他线程只能在方
    法外 等着。
格式：
    public synchronized void method(){
        可能会产生线程安全问题的代码
          }
同步锁是谁?
    对于非static方法,同步锁就是this。
    对于static方法,我们使用当前方法所在类的字节码对象(类名.class)。
         */
        TongBuFangFa_ticket_ tbf = new TongBuFangFa_ticket_();
        Thread tbf1 = new Thread(tbf,"同步方法窗口1");
        Thread tbf2 = new Thread(tbf,"同步方法窗口2");
        Thread tbf3 = new Thread(tbf,"同步方法窗口3");
        tbf1.start();
        tbf2.start();
        tbf3.start();
        System.out.println("================================");


        /*
Lock锁
    java.util.concurrent.locks.Lock 机制提供了比synchronized代码块和synchronized方法更
    广泛的锁定操作, 同步代码块/同步方法具有的功能Lock都有,除此之外更强大,更体现面向对象。
Lock锁也称同步锁，加锁与释放锁方法化了，如下：
    public void lock() :加同步锁。
    public void unlock() :释放同步锁。
         */
        Lock_Ticket_ lc = new Lock_Ticket_();
        Thread lc1 = new Thread(lc,"lock窗口1");
        Thread lc2 = new Thread(lc,"lock窗口2");
        Thread lc3 = new Thread(lc,"lock窗口3");
        lc1.start();
        lc2.start();
        lc3.start();
        System.out.println("================================");

    }
}
