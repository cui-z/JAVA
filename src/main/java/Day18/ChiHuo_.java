package Day18;

public class ChiHuo_ extends Thread {
    private BaoZi_ bz;
    public ChiHuo_(String name,BaoZi_ bz){
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if(bz.flag == false){
                    try {
                        bz.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃"+bz.pier +bz
                .xianer+"包子");

                bz.flag = false;
                bz.notify();
            }
        }
    }
}
