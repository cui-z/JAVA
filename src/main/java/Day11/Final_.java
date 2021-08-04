package Day11;

/*
学习了继承后，我们知道，子类可以在父类的基础上改写父类内容，比如，方法重写。
   那么我们能不能随意的继承 API中提供的类，改写其内容呢？显然这是不合适的。
   为了避免这种随意改写的情况，Java提供了 final 关键字， 用于修饰不可改变内容。

final： 不可改变。可以用于修饰类、方法和变量。
    类：被修饰的类，不能被继承。
    final class 类名{}  只供使用，不能改变其内容

    方法：被修饰的方法，不能被重写。
    修饰符 final 返回值类型 方法名（参数列表）{
       方法体
       }

    变量：被修饰的变量，不能被重新赋值。
    下面列子
 */

public class Final_ {
    public static void main(String[] args) {
        //修饰局部变量
        final int a;
        a = 6;
        System.out.println(a);
        //a = 10;  报错 只能赋值一次


        //修饰引用类型 被修饰后，只能指向一个对象，地址不在修改，但是不影响内部修改
         final User u = new User();
        // u = new User();  会报错
        u.setName("zhansan ");
        System.out.println(u.getName());


        //被 final修饰的常量名称，一般都是大写 所有的字母






    }
}
