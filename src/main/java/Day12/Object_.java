package Day12;

import sun.rmi.runtime.NewThreadAction;

/*
java.lang.Object`类是Java语言中的根类，即所有类的父类。
  它中描述的所有方法子类都可以使用。在对象实例化的时候，最终找的父类就是Object。
如果一个类没有特别指定父类，	那么默认则继承自Object类。
 */
public class Object_ {
    public static void main(String[] args) {
        //toString方法 返回对象类型+@+内存地址值
        //所以为了返回字符串 一般都要重写
        Persion p = new Persion("zhangsan",12);
        System.out.println(p.toString());


        //equals  默认是地址比较  如果相比较内容 需要重写
        Persion p1 = new Persion("zhznag",12);
        System.out.println(p.equals(p1));
        Persion p2 =  new Persion("zhangsan",12);
        System.out.println(p.equals(p2));
    }
}
