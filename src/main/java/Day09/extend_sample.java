package Day09;

import java.util.ArrayList;
import java.util.Scanner;

/*
群主发普通红包。某群有多名成员，群主给成员发普通红包。普通红包的规则：
1. 群主的一笔金额，从群主余额中扣除，平均分成n等份，让成员领取。
2. 成员领取红包后，保存到成员余额中。
请根据描述，完成案例中所有类的定义以及指定类之间的继承关系，并完成发红包的操作。
 */
public class extend_sample {
    public static void main(String[] args) {

        Qun_zhu qz = new Qun_zhu("qunzhu",200);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入金额");
        int money = sc.nextInt();
        System.out.println("请输入个数");
        int count = sc.nextInt();
        ArrayList<Double> arr = qz.send(money,count);
        if (arr == null){
            System.out.println("余额不足");
            return;
        }

        Member m1 = new Member();
        Member m2 = new Member();
        Member m3 = new Member();

        m1.openRed(arr);
        m2.openRed(arr);
        m3.openRed(arr);

        qz.show();
        m1.show();
        m2.show();
        m3.show();




    }
}
