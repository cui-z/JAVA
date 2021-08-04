package Day12;
/*
String s = "hello";
s+="word"
这样效率很低 因为string是常量，它的值创建后不能改变，上述代码会产生三个字符串，浪费时间又浪费空间。

StringBuilder又称为可变字符序列，它是一个类似于 String 的字符串缓冲区，
    通过某些方法调用可以改变该序列的长度和内容。
    原来StringBuilder是个字符串的缓冲区，即它是一个容器，
    容器中可以装很多字符串。并且能够对其中的字符串进行各种操作。
    它的内部拥有一个数组用来存放字符串内容，进行字符串拼接时，
    直接在数组中加入新内容。StringBuilder会自动维护数组的扩容。

 */

public class StringBuild_ {
    public static void main(String[] args) {
        //创建
        StringBuilder s1 = new StringBuilder();
        System.out.println(s1);
        StringBuilder s2 = new StringBuilder("hello word");
        System.out.println(s2);

        //append方法具有多种重载形式，可以接收任意类型的参数。
        // 任何数据作为参数都会将对应的字符串内容添加到StringBuilder中。

        StringBuilder s3 = s2.append("hahaha");
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s2==s3);
        //任意类型  链式编程
        s1.append(1455).append("soidjgio").append(true);
        System.out.println(s1);

        //toString方法，StringBuilder对象将会转换为不可变的String对象。

        String s4 = s1.toString();
        System.out.println(s4);

    }
}
