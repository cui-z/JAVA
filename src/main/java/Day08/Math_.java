package Day08;

/*
java.lang.Math 类包含用于执行基本数学运算的方法，
    如初等指数、对数、平方根和三角函数。类似这样的工具 类，
    其所有方法均为静态方法，并且不会创建对象，调用起来非常简单。
 */

public class Math_ {
    public static void main(String[] args) {
        //abs 返回绝对值
        System.out.println(Math.abs(-98));
        System.out.println(Math.abs(-7.6));

        //ceil  返回da于等于参数最大的整数
        System.out.println(Math.ceil(-2.76));
        System.out.println(Math.ceil(2.76));
        // floor  返回小于等于参数最大的整数
        System.out.println(Math.floor(-2.76));
        System.out.println(Math.floor(2.76));

        //round  相当于四舍五入
        System.out.println(Math.round(2.6));
        System.out.println(Math.round(2.4));
        System.out.println("-----------------");
        get_num();
    }


    //请使用 Math 相关的API，计算在 -10.8 到 5.9 之间，
    // 绝对值大于 6 或者小于 2.1 的整数有多少个？
    public static void get_num(){
        double min = -10.8;
        double max = 5.9;
        int num = 0;
        for (double i = Math.ceil(min) ; i <= max ; i++){

            if (Math.abs(i) >=6 || Math.abs(i)<2.1){
                num ++;
            }

        }

        System.out.println(num);



    }
}
