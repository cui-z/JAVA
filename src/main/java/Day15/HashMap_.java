package Day15;
/*
通过查看Map接口描述，看到Map有多个子类，这里我们主要讲解常用的HashMap集合、LinkedHashMap集合。
HashMap：存储数据采用的哈希表结构，元素的存取顺序不能保证一致。由于要保证键的唯一、不重复，需
    要重写键的hashCode()方法、equals()方法。
LinkedHashMap：HashMap下有个子类LinkedHashMap，存储数据采用的哈希表结构+链表结构。通过链表结构
    可以保证元素的存取顺序一致；通过哈希表结构可以保证的键的唯一、不重复，需要重写键的
     hashCode()方法、equals()方法。
tips：Map接口中的集合都有两个泛型变量,在使用时，要为两个泛型变量赋予数据类型。
     两个泛型变量的数 据类型可以相同，也可以不同。
 */

import java.util.HashMap;
import java.util.Map;

public class HashMap_ {
    public static void main(String[] args) {
        /*
Map接口中定义了很多方法，常用的如下：
public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
public V remove(Object key) : 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
public Set<K> keySet() : 获取Map集合中所有的键，存储到Set集合中。
public Set<Map.Entry<K,V>> entrySet() : 获取到Map集合中所有的键值对对象的集合(Set集合)。

         */
        HashMap<String,String> hs  = new HashMap<String, String>();
        hs.put("aa","bb");
        hs.put("cc","dd");
        hs.put("ee","ff");
        System.out.println(hs);
        hs.remove("aa");
        System.out.println(hs);
        System.out.println(hs.get("cc"));
        System.out.println(hs.get("ab")); //不存在则返回null
        for (String s : hs.keySet()) {
            System.out.println(s);
        }
 //使用put方法时，若指定的键(key)在集合中没有，则没有这个键对应的值，返回null，
        // 并把指定的键值添加到 集合中；
        // 若指定的键(key)在集合中存在，则返回值为集合中键对应的值（该值为替换前的值），
        // 并把指定键所对应的 值，替换成指定的新值。

        /*
键找值方式：即通过元素中的键，获取键所对应的值 分析步骤：
     1. 获取Map中所有的键，由于键是唯一的，所以返回一个Set集合存储所有的键。方法提示: keyset()
     2. 遍历键的Set集合，得到每一个键。
     3. 根据键，获取键所对应的值。方法提示: get(K key)
         */
        for (String s : hs.keySet()) {
            System.out.println("jian"+s+",zhi"+hs.get(s));
        }
        /*
Entry键值对对象
    我们已经知道， Map 中存放的是两种对象，一种称为key(键)，一种称为value(值)，
    它们在在 Map 中是一一对应关 系，这一对对象又称做 Map 中的一个 Entry(项) 。
    Entry 将键值对的对应关系封装成了对象。即键值对对象，这 样我们在遍历 Map 集合时，
    就可以从每一个键值对（ Entry ）对象中获取对应的键与对应的值。
    既然Entry表示了一对键和值，那么也同样提供了获取对应键和对应值得方法：
    public K getKey() ：获取Entry对象中的键。
    public V getValue() ：获取Entry对象中的值。
在Map集合中也提供了获取所有Entry对象的方法：
     public Set<Map.Entry<K,V>> entrySet() : 获取到Map集合中所有的键值对对象的
     集合(Set集合)
         */
        for (Map.Entry<String, String> stringStringEntry : hs.entrySet()) {
            System.out.println("键"+stringStringEntry.getKey()+"，值"+stringStringEntry.getValue());
        }

        /*
HashMap存储自定义类型键值
  练习：每位学生（姓名，年龄）都有自己的家庭住址。那么，既然有对应关系，则将学生对
  象和家庭住址存储到 map集合中。学生作为键, 家庭住址作为值。 注意，学生姓名相同并
  且年龄相同视为同一名学生。
         */

        HashMap<Student,String> map = new HashMap<>();
        map.put(new Student("aa",12),"北京");
        map.put(new Student("bb",13),"山东");
        map.put(new Student("cc",14),"莱芜");
        map.put(new Student("bb",13),"莱芜");

        for (Map.Entry<Student, String> studentStringEntry : map.entrySet()) {
            System.out.println(studentStringEntry.getKey()+"   "+studentStringEntry.getValue());
        }

    }
}
