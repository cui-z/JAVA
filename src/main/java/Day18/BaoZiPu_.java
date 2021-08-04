package Day18;

public class BaoZiPu_ extends Thread {
    private BaoZi_ bz;
    public BaoZiPu_(String name,BaoZi_ bz){
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        int num = 0;
        while (true){
            synchronized (bz){
                if(bz.flag == true){
                    try {
                        bz.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                System.out.println("包子铺开始生产包子");
                if(num%2 ==0){
                    bz.pier = "冰皮";
                    bz.xianer = "五仁";
                }else{
                    bz.pier = "脆皮";
                    bz.xianer = "猪肉大葱";
                }
                num++;
                bz.flag = true;
                System.out.println("包子包好了："+bz.pier+bz.xianer);
                System.out.println("可以来吃了");
                bz.notify();

            }

        }
    }
}
