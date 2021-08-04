package Day13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
在程序开发中，经常需要遍历集合中的所有元素。针对这种需求，JDK专门提供了
  一个接口`java.util.Iterator`。`Iterator`接口也是Java集合中的一员，
  但它与`Collection`、`Map`接口有所不同，`Collection`接口与`Map`接口
  主要用于存储元素，而`Iterator`主要用于迭代访问（即遍历）`Collection`中
  的元素，因此`Iterator`对象也被称为迭代器。
想要遍历Collection集合，那么就要获取该集合迭代器完成迭代操作，下面介绍一下获取迭代器的方法：
* `public Iterator iterator()`: 获取集合对应的迭代器，用来遍历集合中的元素的。

下面介绍一下迭代的概念：
* **迭代**：即Collection集合元素的通用获取方式。在取元素之前先要判断集合中
   有没有元素，如果有，就把这个元素取出来，继续在判断，如果还有就再取出出来
   。一直把集合中的所有元素全部取出。这种取出方式专业术语称为迭代。

Iterator接口的常用方法如下：
    public E next()`:返回迭代的下一个元素。
    public boolean hasNext()`:如果仍有元素可以迭代，则返回 true。
 */
public class Iterator_ {
    public static void main(String[] args) {
        Collection<String> cc = new ArrayList<String>();
        ((ArrayList<String>) cc).add("hhh");
        ((ArrayList<String>) cc).add("jjj");
        cc.add("lll");

        Iterator it = cc.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


        /*
 增强for循环(也称for each循环)是**JDK1.5**以后出来的一个高级for循环，
   专门用来遍历数组和集合的。它的内部原理其实是个Iterator迭代器，
   所以在遍历的过程中，不能对集合中的元素进行增删操作。

格式：
~~~java
for(元素的数据类型  变量 : Collection集合or数组){
  	//写操作代码
}
~~~

它用于遍历Collection和数组。通常只进行遍历元素，
不要在遍历的过程中对集合元素进行增删操作。
快捷键 变量名.for
         */
        for (String s : cc) {
            System.out.println(s);
        }
//新for循环必须有被遍历的目标。目标只能是Collection或者是数组。新式for仅仅作为遍历操作出现。
    }
}
