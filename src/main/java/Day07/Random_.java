package Day07;

import java.util.Random;
import java.util.Scanner;

/*
Random 用于生成一个随机数 通过nextInt生成范围在0-n之间的值


 */
public class Random_ {
    public static void main(String[] args) {
        //猜数字小游戏
        Random r = new Random();
        int num = r.nextInt(100)+1;
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个数字" );
            int sc_num = sc.nextInt();
            if(sc_num < num){
                System.out.println(" 你猜的数小了");
            } else if (sc_num  > num){
                System.out.println("你猜的da了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }


    }
}
