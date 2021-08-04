package Day18;
/*
在数学中，函数就是有输入量、输出量的一套计算方案，也就是“拿什么东西做什么事情”。相对而言，面向对
    象过 分强调“必须通过对象的形式来做事情”，而函数式思想则尽量忽略面向对象的复杂语法——强调做
    什么，而不是以 什么形式做。

面向对象的思想:
    做一件事情,找一个能解决这个事情的对象,调用对象的方法,完成事情.
函数式编程思想:
    只要能获取到结果,谁去做的,怎么做的都不重要,重视的是结果,不重视过程
 */

import Day11.Person;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda_ {
    public static void main(String[] args) {
        /*
冗余的Runnable代码 \
    传统写法
    当需要启动一个线程去完成任务时，通常会通过 java.lang.Runnable 接口来定义任务内容，并使用
    java.lang.Thread 类来启动该线程。代码如下：
         */
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("传统学法多线程");
            }
        };
        new Thread(r).start();
//代码分析
//   对于 Runnable 的匿名内部类用法，可以分析出几点内容：
// Thread 类需要 Runnable 接口作为参数，其中的抽象 run 方法是用来指定线程任务内容的核心.
// 为了指定 run 的方法体，不得不需要 Runnable 接口的实现类；
// 为了省去定义一个 RunnableImpl 实现类的麻烦，不得不使用匿名内部类；
// 必须覆盖重写抽象 run 方法，所以方法名称、方法参数、方法返回值不得不再写一遍，且不能写错；
// 而实际上，似乎只有方法体才是关键所在。


        //体验lambda更有写法
        new Thread(() -> System.out.println("lambda 多线程")).start();
        //这段代码和刚才的执行效果是完全一样的，可以在1.8或更高的编译级别下通过。
        // 从代码的语义中可以看出：我们 启动了一个线程，而线程任务的内容以一种更加简洁的形式被\
        // 指定。 不再有“不得不创建接口对象”的束缚，不再有“抽象方法覆盖重写”的负担，就是这
        // 么简单！

        /*
回顾匿名内部类
    Lambda是怎样击败面向对象的？在上例中，核心代码其实只是如下所示的内容：
    () -> System.out.println("lambda 多线程")
为了理解Lambda的语义，我们需要从传统的代码起步。
使用实现类
  要启动一个线程，需要创建一个 Thread 类的对象并调用 start 方法。而为了指定线程执行的内容，需要调
  用 Thread 类的构造方法： public Thread(Runnable target) 为了获取 Runnable 接口的实现对象，可以
  为该接口定义一个实现类 RunnableImpl ：
  public class RunnableImpl implements Runnable {
       @Override
       public void run() {
           System.out.println("多线程任务执行！");
       }
     }
  然后创建该实现类的对象作为 Thread 类的构造参数：
  public class Demo03ThreadInitParam {
      public static void main(String[] args) {
          Runnable task = new RunnableImpl();
          new Thread(task).start();
          }
      }
使用匿名内部类
  这个 RunnableImpl 类只是为了实现 Runnable 接口而存在的，而且仅被使用了唯一一次，所以使用匿名内
  部类的语法即可省去该类的单独定义，即匿名内部类：
  public class Demo04ThreadNameless {
     public static void main(String[] args) {
          new Thread(new Runnable() {
              @Override
              public void run() {
                  System.out.println("多线程任务执行！");
                  }
                  }).start();
                }
            }
匿名内部类的好处与弊端
    一方面，匿名内部类可以帮我们省去实现类的定义；另一方面，匿名内部类的语法——确实太复杂了！
语义分析
    仔细分析该代码中的语义， Runnable 接口只有一个 run 方法的定义：
         public abstract void run();
    即制定了一种做事情的方案（其实就是一个函数）：
        无参数：不需要任何条件即可执行该方案。
        无返回值：该方案不产生任何结果。
        代码块（方法体）：该方案的具体执行步骤。
    同样的语义体现在 Lambda 语法中，要更加简单：
        () ‐> System.out.println("多线程任务执行！")
    前面的一对小括号即 run 方法的参数（无），代表不需要任何条件；
    中间的一个箭头代表将前面的参数传递给后面的代码；
    后面的输出语句即业务逻辑代码。

 Lambda标准格式
 Lambda省去面向对象的条条框框，格式由3个部分组成：
      一些参数
      一个箭头
      一段代码
      Lambda表达式的标准格式为：
      (参数类型 参数名称) ‐> { 代码语句 }
      格式说明：
          小括号内的语法与传统方法参数列表一致：无参数则留空；多个参数则用逗号分隔。
          -> 是新引入的语法格式，代表指向动作。
           大括号内的语法与传统方法体要求基本一致。
         */


//给定一个厨子 Cook 接口，内含唯一的抽象方法 makeFood ，且无参数、无返回值。
// 在下面的代码中，请使用Lambda的标准格式调用 invokeCook 方法，打印输出“吃饭啦！”字样：
        lambdacook(() ->{
            System.out.println("做饭吃饭了");
        });

        System.out.println("===============================");
//需求:使用数组存储多个Person对象 对数组中的Person对象使用Arrays的sort方法通过年龄进行
// 升序排序下面举例演示
// java.util.Comparator<T> 接口的使用场景代码，其中的抽象方法定义为：
//     public abstract int compare(T o1, T o2); 当需要对一个对象数组进行排序时，
// Arrays.sort 方法需要一个 Comparator 接口实例来指定排序的规则。
// 假设有 一个 Person 类，含有 String name 和 int age 两个成员变量：

        //传统方法
        Person_[]  arr = {
                new Person_("aa",14),
                new Person_("bb",15),
                new Person_("cc",19)
        };
        Comparator<Person_> cp = new Comparator<Person_>() {
            @Override
            public int compare(Person_ o1, Person_ o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Arrays.sort(arr,cp);
        for (Person_ person_ : arr) {
            System.out.println(person_);
        }
        /*
这种做法在面向对象的思想中，似乎也是“理所当然”的。其中 Comparator 接口的实例（使用了匿
   名内部类）代表 了“按照年龄从小到大”的排序规则。
代码分析 下面我们来搞清楚上述代码真正要做什么事情。
    为了排序， Arrays.sort 方法需要排序规则，即 Comparator 接口的实例，抽象方法 compare
         是关键；
     为了指定 compare 的方法体，不得不需要 Comparator 接口的实现类；
     为了省去定义一个 ComparatorImpl 实现类的麻烦，不得不使用匿名内部类；
     必须覆盖重写抽象 compare 方法，所以方法名称、方法参数、方法返回值不得不再写一遍，
       且不能写错；
     实际上，只有参数和方法体才是关键。
         */

        //lambda写法
        Person_[]  arr1 = {
                new Person_("aaa",14),
                new Person_("bbb",15),
                new Person_("ccc",19)
        };
        Arrays.sort(arr1,(Person_ a,Person_ b) ->{
            return a.getAge() -b.getAge();
        });
        for (Person_ person_ : arr1) {
            System.out.println(person_);
        }


        //计算有返回值
        get_sum(14,15,(int a,int b) ->{
            return a+b;
        });
//省略规则 在Lambda标准格式的基础上，使用省略写法的规则为：
//     1. 小括号内参数的类型可以省略；
//     2. 如果小括号内有且仅有一个参，则小括号可以省略；
//     3. 如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、
//     return关键字及语句分号。
        get_sum(14,10,( a, b) -> a+b );



/*
Lambda的语法非常简洁，完全没有面向对象复杂的束缚。但是使用时有几个问题需要特别注意：
    1. 使用Lambda必须具有接口，且要求接口中有且仅有一个抽象方法。 无论是JDK内置的
        Runnable 、 Comparator 接口还是自定义的接口，只有当接口中的抽象方法存在且
        唯一 时，才可以使用Lambda。
    2. 使用Lambda必须具有上下文推断。 也就是方法的参数或局部变量类型必须为Lambda对应
        的接口类型，才能使用Lambda作为该接口的实例。
备注：有且仅有一个抽象方法的接口，称为“函数式接口”。
 */
    }
    private static void lambdacook(Cook_ ck){
        ck.makefood();
    }

    private static void get_sum(int a,int b, Get_sum su){
        int result = su.sum_(a,b);
        System.out.println("和为："+result);
    }
}
