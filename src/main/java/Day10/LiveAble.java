package Day10;

public interface LiveAble {
    public  abstract void eat();
    public  abstract void slep();
    public  default void fly(){
        System.out.println("天上飞");
    }

    public static void run(){
        System.out.println("跑起来啊  ");
    }



}
