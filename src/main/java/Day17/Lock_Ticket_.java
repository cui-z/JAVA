package Day17;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_Ticket_ implements Runnable {
    private int num =10;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            if(num > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖" + num--);
            }
            lock.unlock();
        }
    }
}
