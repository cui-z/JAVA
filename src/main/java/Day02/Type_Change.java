package Day02;

/*
自动类型转换： 将范围小的类型提升到范围大的类型
 */

public class Type_Change {
    public static void main(String[] args) {
        short a  = 1;
        byte b= 3;
        //short c = b+a; 错误
        // 范围小向范围大转换
        // byte short char -> int  -> long ->float -> double
        int c  = a +b ;
        System.out.println(c);

        System.out.println("----------------------");
        // 强制类型转换   范围大的可以转换成范围小的
        // 格式   数据类型 变量名 = （数据类型） 原数值；
        int i = (int) 2.67;
        System.out.println(i);


        //当一个 short 类型与 1 相加，我们知道会类型提升，
        // 但是还想给结果赋值给short类型变量，就需要强制转换。

        short s = 8;
        // s =s +1 ; 错误
        s = (short)(s +1);
        System.out.println(s);

        // 浮点类型转为 整形 ，直接去掉小数点 数据损失
        // int  转 short  会砍掉两个字节，造成数据损失
    }
}
