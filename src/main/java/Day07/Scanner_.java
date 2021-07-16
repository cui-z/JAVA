package Day07;

import java.util.Scanner;

//  用于完成键盘输入
public class Scanner_ {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        System.out.println("输入第一个数");
        int a = sc.nextInt();
        System.out.println("输入第二个数");
        int b = sc.nextInt();
        System.out.println(a+b);

    }
}
