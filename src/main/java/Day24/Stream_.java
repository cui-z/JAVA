package Day24;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
第一章 Stream流
  说到Stream便容易想到I/O Stream，而实际上，谁规定“流”就一定是“IO流”呢？在Java 8中，得益于Lambda所
  带来的函数式编程，引入了一个全新的Stream概念，用于解决已有集合类库既有的弊端。
1.1 引言
  传统集合的多步遍历代码
  几乎所有的集合（如 Collection 接口或 Map 接口等）都支持直接或间接的遍历操作。而当我们需要对集合中的
  元素进行操作的时候，除了必需的添加、删除、获取外，最典型的就是集合遍历。例如：
  import java.util.ArrayList;
  import java.util.List;
  public class Demo01ForEach {
       public static void main(String[] args) {
           List<String> list = new ArrayList<>();
           list.add("张无忌");
           list.add("周芷若");
           list.add("赵敏");
           list.add("张强");
           list.add("张三丰");
           for (String name : list) {
               System.out.println(name);
           }
       }
  }
  这是一段非常简单的集合遍历操作：对集合中的每一个字符串都进行打印输出操作。
循环遍历的弊端
  Java 8的Lambda让我们可以更加专注于做什么（What），而不是怎么做（How），这点此前已经结合内部类进行
  了对比说明。现在，我们仔细体会一下上例代码，可以发现：
    for循环的语法就是“怎么做”
    for循环的循环体才是“做什么”
  为什么使用循环？因为要进行遍历。但循环是遍历的唯一方式吗？遍历是指每一个元素逐一进行处理，而并不是
  从 第一个到最后一个顺次处理的循环。前者是目的，后者是方式。 试想一下，如果希望对集合中的元素进行筛
  选过滤：
    1. 将集合A根据条件一过滤为子集B；
    2. 然后再根据条件二过滤为子集C。
  那怎么办？在Java 8之前的做法可能为：
  import java.util.ArrayList;
  import java.util.List;
  public class Demo02NormalFilter {
      public static void main(String[] args) {
          List<String> list = new ArrayList<>();
          list.add("张无忌");
          list.add("周芷若");
          list.add("赵敏");
          list.add("张强");
          list.add("张三丰");
          List<String> zhangList = new ArrayList<>();
          for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
                }
          }
          List<String> shortList = new ArrayList<>();
          for (String name : zhangList) {
              if (name.length() == 3) {
                  shortList.add(name);
                  }
          }
          for (String name : shortList) {
              System.out.println(name);
              }
          }
   }
   这段代码中含有三个循环，每一个作用不同：
     1. 首先筛选所有姓张的人；
     2. 然后筛选名字有三个字的人；
     3. 最后进行对结果进行打印输出。
   每当我们需要对集合中的元素进行操作的时候，总是需要进行循环、循环、再循环。这是理所当然的么？不是。
   循 环是做事情的方式，而不是目的。另一方面，使用线性循环就意味着只能遍历一次。如果希望再次遍历，
   只能再使 用另一个循环从头开始。 那，Lambda的衍生物Stream能给我们带来怎样更加优雅的写法呢？
   Stream的更优写法 下面来看一下借助Java 8的Stream API，什么才叫优雅：
   import java.util.ArrayList;
   import java.util.List;
   public class Demo03StreamFilter {
       public static void main(String[] args) {
           List<String> list = new ArrayList<>();
           list.add("张无忌");
           list.add("周芷若");
           list.add("赵敏");
           list.add("张强");
           list.add("张三丰");
           list.stream() .filter(
               s ‐> s.startsWith("张")) .filter(
               s ‐> s.length() == 3) .forEach(System.out::println); }
    }
    直接阅读代码的字面意思即可完美展示无关逻辑方式的语义：获取流、过滤姓张、过滤长度为3、逐一打印。
    代码 中并没有体现使用线性循环或是其他任何算法进行遍历，我们真正要做的事情内容被更好地体现在代
    码中。
1.2 流式思想概述
  注意：请暂时忘记对传统IO流的固有印象！整体来看，流式思想类似于工厂车间的“生产流水线”。
  Stream（流）是一个来自数据源的元素队列
    元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
    数据源流的来源。 可以是集合，数组 等。
  和以前的Collection操作不同， Stream操作还有两个基础的特征：
    Pipelining: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道，如同流式风格
       （fluent style）。 这样做可以对操作进行优化， 比如延迟执行(laziness)和短路
       ( short-circuiting)。
    内部迭代： 以前对集合遍历都是通过Iterator或者增强for的方式, 显式的在集合外部进行迭代，
      这叫做外部迭 代。 Stream提供了内部迭代的方式，流可以直接调用遍历方法。
  当使用一个流的时候，通常包括三个基本步骤：
     获取一个数据源（source）→ 数据转换→执行操作获取想要的结果，每次转换原有 Stream 对象不改变，
     返回一个新的 Stream 对象（可以有多次转换），这就允许对其操作可以 像链条一样排列，
     变成一个管道。

1.3 获取流
  java.util.stream.Stream<T> 是Java 8新加入的最常用的流接口。（这并不是一个函数式接口。） 获取一个
  流非常简单，有以下几种常用的方式：
    所有的 Collection 集合都可以通过 stream 默认方法获取流；
    Stream 接口的静态方法 of 可以获取数组对应的流。

  根据Collection获取流
    首先， java.util.Collection 接口中加入了default方法 stream 用来获取流，所以其所有实现类均可获
    取流。
  import java.util.*;
  import java.util.stream.Stream;
  public class Demo04GetStream {
      public static void main(String[] args) {
          List<String> list = new ArrayList<>();
          // ...
          Stream<String> stream1 = list.stream();
          Set<String> set = new HashSet<>();
           // ...
          Stream<String> stream2 = set.stream();
          Vector<String> vector = new Vector<>();
          // ...
          Stream<String> stream3 = vector.stream();
         }
   }

   根据Map获取流
      java.util.Map 接口不是 Collection 的子接口，且其K-V数据结构不符合流元素的单一特征，
      所以获取对应的流 需要分key、value或entry等情况：
      import java.util.HashMap;
      import java.util.Map;
      import java.util.stream.Stream;
      public class Demo05GetStream {
          public static void main(String[] args) {
               Map<String, String> map = new HashMap<>();
               // ...
               Stream<String> keyStream = map.keySet().stream();
               Stream<String> valueStream = map.values().stream();
               Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();
           }
       }

   根据数组获取流
       如果使用的不是集合或映射而是数组，由于数组对象不可能添加默认方法，所以 Stream 接口中提供了静态方
       法 of ，使用很简单：
       import java.util.stream.Stream;
       public class Demo06GetStream {
           public static void main(String[] args) {
               String[] array = { "张无忌", "张翠山", "张三丰", "张一元" };
               Stream<String> stream = Stream.of(array);
             }
        }

1.4 常用方法
  流模型的操作很丰富，这里介绍一些常用的API。这些方法可以被分成两种：
  延迟方法：返回值类型仍然是 Stream 接口自身类型的方法，因此支持链式调用。（除了终结方法外，其余方 法均
      为延迟方法。）
  终结方法：返回值类型不再是 Stream 接口自身类型的方法，因此不再支持类似 StringBuilder 那样的链式调 用。
      本小节中，终结方法包括 count 和 forEach 方法。

  逐一处理：forEach
  import java.util.stream.Stream;
  public class Demo12StreamForEach {
      public static void main(String[] args) {
          Stream<String> stream = Stream.of("张无忌", "张三丰", "周芷若");
          stream.forEach(name‐> System.out.println(name));
      }
  }

  过滤：filter
  import java.util.stream.Stream;
  public class Demo07StreamFilter {
      public static void main(String[] args) {
          Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
          Stream<String> result = original.filter(s ‐> s.startsWith("张"));
      }
  }

  映射：map 如果需要将流中的元素映射到另一个流中，可以使用 map 方法。
  import java.util.stream.Stream;
  public class Demo08StreamMap {
      public static void main(String[] args) {
          Stream<String> original = Stream.of("10", "12", "18");
          Stream<Integer> result = original.map(str‐>Integer.parseInt(str));
      }
  }

  统计个数：count 正如旧集合 Collection 当中的 size 方法一样，流提供 count 方法来数一数其中的元素个数：
  import java.util.stream.Stream;
  public class Demo09StreamCount {
      public static void main(String[] args) {
          Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
          Stream<String> result = original.filter(s ‐> s.startsWith("张"));
          System.out.println(result.count()); // 2
      }
  }

  取用前几个：limit limit 方法可以对流进行截取，只取用前n个。
  参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作。
  import java.util.stream.Stream;
  public class Demo10StreamLimit {
      public static void main(String[] args) {
          Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
          Stream<String> result = original.limit(2);
          System.out.println(result.count()); // 2
       }
   }

   跳过前几个：skip
   如果希望跳过前几个元素，可以使用 skip 方法获取一个截取之后的新流：
   import java.util.stream.Stream;
   public class Demo11StreamSkip {
       public static void main(String[] args) {
           Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
           Stream<String> result = original.skip(2);
           System.out.println(result.count()); // 1
       }
   }

   组合：concat
   如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat ：
   import java.util.stream.Stream;
   public class Demo12StreamConcat {
       public static void main(String[] args) {
           Stream<String> streamA = Stream.of("张无忌");
           Stream<String> streamB = Stream.of("张翠山");
           Stream<String> result = Stream.concat(streamA, streamB);
       }
   }


 */
public class Stream_ {
    public static void main(String[] args) {
        /*
题目
    现在有两个ArrayList 集合存储队伍当中的多个成员姓名，要求依次进行以
     下若干操作步骤：
     1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。 \
     2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
      3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
       4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        5. 将两个队伍合并为一个队伍；存储到一个新集合中。
         6. 根据姓名创建 Person 对象；存储到一个新集合中。
         7. 打印整个队伍的Person对象信息。
         */
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        // 第一个队伍只要名字为3个字的成员姓名；
        // 第一个队伍筛选之后只要前3个人；
        Stream<String> streamone= one.stream().filter(s -> s.length() ==3).limit(3);
        // 第二个队伍只要姓张的成员姓名；
        // 第二个队伍筛选之后不要前2个人；
        Stream<String> streamtwo = two.stream().filter(s -> s.startsWith("张")).skip(2);
        // 将两个队伍合并为一个队伍；
        // 根据姓名创建Person对象；
        // 打印整个队伍的Person对象信息。
        Stream.concat(streamone,streamtwo).map(s -> new Persion_(s)).forEach(s -> System.out.println(s));
        //Stream.concat(streamOne, streamTwo).map(Person::new).forEach(System.out::println);
    }
}
