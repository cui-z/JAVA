package Day17;

public class TongBuFangFa_ticket_ implements Runnable {
    private int num =10;
    @Override
    public void run() {
        while (true){
            sell_ticket();

        }
    }

    public synchronized void sell_ticket(){
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
