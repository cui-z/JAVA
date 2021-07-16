package Day02;

public class Extend_Knowledge {
    public static void main(String[] args) {
        /*

        += 是一个运算符，只运算一次，并带有强制转换的特点，
        也就是说 s += 1 就是 s = (short)(s + 1) ，
        因此程序没有问题编译通过，
         */

        short s = 6;
        s+=1;
        System.out.println(s);
    }
}
