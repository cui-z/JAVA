package Day15;

import java.util.Map;

/*
JDK9对集合添加的优化 通常，我们在代码中创建一个集合（例如，List 或
    Set ），并直接用一些元素填充它。
    实例化集合，几个 add方法 调用，使得代码重复
 */
public class Jdk9_ {
    public static void main(String[] args) {
        /*
Java 9，添加了几种集合工厂方法,更方便创建少量元素的集合、map实例。
  新的List、Set、Map的静态工厂方法可 以更方便地创建集合的不可变实例。
Set<String> str1=Set.of("a","b","c");
//str1.add("c");这里编译的时候不会错，但是执行的时候会报错，因为是不可变的集合
System.out.println(str1);
Map<String,Integer> str2=Map.of("a",1,"b",2);
System.out.println(str2);
List<String> str3=List.of("a","b");
System.out.println(str3);

         */
    }
}
