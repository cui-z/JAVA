package Day23;

import java.util.Arrays;
import java.util.Comparator;

/*
在兼顾面向对象特性的基础上，Java语言通过Lambda表达式与方法引用等，为开发者打开了函数式编程的大门。下
    面我们做一个初探。

2.1 Lambda的延迟执行
    有些场景的代码执行后，结果不一定会被使用，从而造成性能浪费。而Lambda表达式是延迟执行的，这正好
    可以作为解决方案，提升性能。
性能浪费的日志案例
    注:日志可以帮助我们快速的定位问题，记录程序运行过程中的情况，以便项目的监控和优化。 一种典型的
    场景就是对参数进行有条件使用，例如对日志消息进行拼接后，在满足条件的情况下进行打印输出：
    public class Demo01Logger {
        private static void log(int level, String msg) {
            if (level == 1) {
                System.out.println(msg);
            }
         }
         public static void main(String[] args) {
              String msgA = "Hello";
              String msgB = "World";
              String msgC = "Java";
              log(1, msgA + msgB + msgC);
          }
      }
这段代码存在问题：无论级别是否满足要求，作为log方法的第二个参数，三个字符串一定会首先被拼接并传入
    方 法内，然后才会进行级别判断。如果级别不符合要求，那么字符串的拼接操作就白做了，存在性能浪费。
备注：SLF4J是应用非常广泛的日志框架，它在记录日志时为了解决这种性能浪费的问题，并不推荐首先进行字符
    串的拼接，而是将字符串的若干部分作为可变参数传入方法中，仅在日志级别满足要求的情况下才会进 行字
    符串拼接。例如： LOGGER.debug("变量{}的取值为{}。", "os", "macOS") ，其中的大括号 {} 为占位符。
    如果满足日志级别要求，则会将“os”和“macOS”两个字符串依次拼接到大括号的位置；否则不会进行字
    符串拼接。这也是一种可行解决方案，但Lambda可以做到更好。




2.2 使用Lambda作为参数和返回值
   如果抛开实现原理不说，Java中的Lambda表达式可以被当作是匿名内部类的替代品。如果方法的参数是一个函数 式
   接口类型，那么就可以使用Lambda表达式进行替代。使用Lambda表达式作为方法参数，其实就是使用函数式接口
   作为方法参数。
   例如 java.lang.Runnable 接口就是一个函数式接口，假设有一个 startThread 方法使用该接口作为参数，那么
   就 可以使用Lambda进行传参。这种情况其实和 Thread 类的构造方法参数为 Runnable 没有本质区别。
   public class Demo04Runnable {
       private static void startThread(Runnable task) {
            new Thread(task).start();
       }
       public static void main(String[] args) {
           startThread(() ‐> System.out.println("线程任务执行！"));
       }
   }

类似地，如果一个方法的返回值类型是一个函数式接口，那么就可以直接返回一个Lambda表达式。当需要通过一
  个方法来获取一个 java.util.Comparator 接口类型的对象作为排序器时,就可以调该方法获取。


 */
public class HanShuShiBianCheng_ {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "World";
        log(1,() -> s1+" "+s2);

        //// 证明Lambda的延迟 下面的代码可以通过结果进行验证：
        log(2,() -> {System.out.println("lambda执行");
        return s1+ " "+ s2;});
        //输出为空从结果中可以看出，在不符合级别要求的情况下，Lambda将不会执行。
        // 从而达到节省性能的效果。
        // 扩展：实际上使用内部类也可以达到同样的效果，只是将代码操作延迟到了另外一个对象当中通
        // 过调用方法 来完成。而是否调用其所在方法是在条件判断之后才执行的。

        System.out.println("=============================");
        //一个方法的返回值类型是一个函数式接口
        String[] arr = {"abc","ab","abcd"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,newcom());
        System.out.println(Arrays.toString(arr));

    }
    private static void log(int level,MessageBuilder me){
        if(level ==1){
            System.out.println(me.buildMessage());
        }
    }
    //这样一来，只有当级别满足要求的时候，才会进行三个字符串的拼接；否则三个字符串将不会进行拼


    //一个方法的返回值类型是一个函数式接口
    private static Comparator<String> newcom(){
        return (a,b) -> b.length() - a.length();
    }
}
