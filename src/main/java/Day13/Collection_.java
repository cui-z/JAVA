package Day13;

import java.util.ArrayList;
import java.util.Collection;

/*
在前面基础班我们已经学习过并使用过集合ArrayList<E> ,那么集合到底是什么呢?

* **集合**：集合是java中提供的一种容器，可以用来存储多个数据。

集合和数组既然都是容器，它们有啥区别呢？
   * 数组的长度是固定的。集合的长度是可变的。
   * 数组中存储的是同一类型的元素，可以存储基本数据类型值。
   * 集合存储的都是对象。而且对象的类型可以不一致。
   * 在开发中一般当对象多的时候，使用集合进行存储。


集合按照其存储结构可以分为两大类，
    分别是单列集合`java.util.Collection`
    和双列集合`java.util.Map`


**Collection**：单列集合类的根接口，用于存储一系列符合某种规则的元素，
* 它有两个重要的子接口，分别是`java.util.List`和`java.util.Set`。
* 其中，`List`的特点是元素有序、元素可重复。
* `Set`的特点是元素无序，而且不可重复。
* `List`接口的主要实现类有`java.util.ArrayList`和`java.util.LinkedList`，
* `Set`接口的主要实现类有`java.util.HashSet`和`java.util.TreeSet`。
 */
public class Collection_ {
    public static void main(String[] args) {
        Collection<String> c  = new ArrayList<String>();
//Collection是所有单列集合的父接口，因此在Collection中定义了单列集合(List和Set)通用的一些方法，这些方法可用于操作所有的单列集合。方法如下：
///public boolean add(E e)`：  把给定的对象添加到当前集合中 。
        ((ArrayList<String>) c).add("lisi");
        c.add("wangwu");
        ((ArrayList<String>) c).add("zhangsan");
        ((ArrayList<String>) c).add("zhangsan");
        System.out.println(c);

//* `public boolean remove(E e)`: 把给定的对象在当前集合中删除。
        c.remove("zhangsan");
        System.out.println(c);
//* `public boolean contains(E e)`: 判断当前集合中是否包含给定的对象。
        System.out.println(c.contains("wangwu"));
//* `public boolean isEmpty()`: 判断当前集合是否为空。
        System.out.println(c.isEmpty());
//* `public int size()`: 返回集合中元素的个数。
        System.out.println(c.size());
//* `public Object[] toArray()`: 把集合中的元素，存储到数组中。
        Object[] ss = c.toArray();
        for(int i = 0;i < ss.length;i++){
            System.out.print(ss[i]+" ");
        }
        System.out.println();
// * `public void clear()` :清空集合中所有的元素。
        c.clear();
        System.out.println(c);
    }
}
