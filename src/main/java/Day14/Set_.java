package Day14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
java.util.Set 接口和 java.util.List 接口一样，同样继承自 Collection 接口，它与
  Collection 接口中的方法基本一致，并没有对 Collection 接口进行功能上的扩充，只是比
  Collection 接口更加严格了。与 List 接口不 同的是，Set 接口中元素无序，并且都会以
  某种规则保证存入的元素不出现重复。
Set 集合有多个子类，这里我们介绍其中的
    java.util.HashSet 、
    java.util.LinkedHashSet
    这两个集合。
 tips:Set集合取出元素的方式可以采用：迭代器、增强for。
 */
public class Set_ {
    public static void main(String[] args) {
        /*
HashSet 是 Set 接口的一个实现类，它所存储的元素是不可重复的，并且元素
  都是无序的(即存取顺序 不一致)。 java.util.HashSet 底层的实现其实是一个
  java.util.HashMap 支持，由于我们暂时还未学习，先做了 解。
HashSet 是根据对象的哈希值来确定元素在集合中的存储位置，因此具有良好的
  存取和查找性能。保证元素唯一性 的方式依赖于： hashCode 与 equals 方法。
         */
        HashSet<String> hs = new HashSet<String>();
        hs.add(new String("cba"));
        hs.add("abc");
        hs.add("bca");
        hs.add("cba");
        for (String h : hs) {
            System.out.println(h);
        }

        System.out.println("=====================");

        /*
 HashSet存储自定义类型元素 给HashSet中存放自定义类型元素时,
     需要重写对象中的hashCode和equals方法，建立自己的比较方式，
     才能保 证HashSet集合中的对象唯一
         */

        HashSet<Student> set = new HashSet<Student>();
        Student s1 = new Student("zhangsan",14);
        Student s2 = new Student("lisi",12);
        set.add(s1);
        set.add(s2);
        set.add(new Student("zhangsan",14));

        for (Student student : set) {
            System.out.println(student);
        }


        /*
我们知道HashSet保证元素唯一，可是元素存放进去是没有顺序的，那么我们要保
   证有序，怎么办呢？ 在HashSet下面有一个子类 java.util.LinkedHashSet ，
   它是链表和哈希表组合的一个数据存储结构。
         */

        Set<String> ss = new LinkedHashSet<String>();
        ss.add("ccc");
        ss.add("aaa");
        ss.add("bbb");
        for (String s : ss) {
            System.out.println(s);
        }

        /*
如果我们定义一个方法需要接受多个参数，并且多个参数类型一致，我们可以对
    其简化成如下格式：修饰符 返回值类型 方法名(参数类型... 形参名){ }
    其实这个书写完全等价与 修饰符 返回值类型 方法名(参数类型[] 形参名){ }
    只是后面这种定义，在调用时必须传递数组，而前者可以直接传递数据即可。
JDK1.5以后。出现了简化操作。... 用在参数上，称之为可变参数。
同样是代表数组，但是在调用这个带有可变参数的方法时，不用创建数组(这就
   是简单之处)，直接将数组中的元素 作为实际参数进行传递，其实编译成的
   class文件，将这些元素先封装到一个数组中，在进行传递。这些动作都在
   编译.class文件时，自动完成了。
         */
        System.out.println(getSum(1,2,3,4,5));


    }


    public static int getSum(int... arr){
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }
}
