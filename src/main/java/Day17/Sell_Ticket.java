package Day17;

public class Sell_Ticket implements Runnable {
    private int num = 10;
    @Override
    public void run() {
        while (true){
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
