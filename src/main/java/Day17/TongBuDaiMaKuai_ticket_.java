package Day17;

public class TongBuDaiMaKuai_ticket_ implements Runnable {
    private int num = 10;

    Object lock = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (lock){
                if(num > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在卖" + num--);
                }
            }

        }

    }
}
