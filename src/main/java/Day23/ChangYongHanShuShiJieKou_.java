package Day23;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ChangYongHanShuShiJieKou_ {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        System.out.println(get_string(() -> s1 + s2));

        //返回最大值
        int arr[] = {3, 6, 1, 2, 6, 8};
        int maxnum = get_max(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(maxnum);
        System.out.println("================================");


        String[] arr1 = {"迪丽热巴,女", "汪峰,男", "杨幂,女", "站克拉玛,男"};
        printinfo(s -> System.out.println("姓名: " + s.split(",")[0]),
                s -> System.out.println("性别： " + s.split(",")[1]),
                arr1
        );

        fum01(s -> s.length() > 14);

        method(s -> s.contains("H"),
                s -> s.contains("W"));

        method1(s -> s.contains("H"),
                s -> s.contains("W"));
        fum02(s -> s.length() > 14);

        List<String> filter_resu = filter(s -> s.split(",")[0].length() == 4,
                s -> "女".equals(s.split(",")[1]),
                arr1);
        System.out.println(filter_resu);


        /*
3.3 Consumer接口
java.util.function.Consumer<T> 接口则正好与Supplier接口相反，它不是生产一个数据，而是消费一个数据， 其数据类型由泛型决定。
抽象方法：accept Consumer
    接口中包含抽象方法 void accept(T t) ，意为消费一个指定泛型的数据。基本使用如：
    import java.util.function.Consumer;
    public class Demo09Consumer {
        private static void consumeString(Consumer<String> function) {
            function.accept("Hello");
        }
        public static void main(String[] args) {
            consumeString(s ‐> System.out.println(s));
        }
    }
当然，更好的写法是使用方法引用。
默认方法：andThen 如果一个方法的参数和返回值全都是 Consumer 类型，那么就可以实现效果：消费数据的时
    候，首先做一个操作， 然后再做一个操作，实现组合。而这个方法就是 Consumer 接口中的default方法
     andThen 。
要想实现组合，需要两个或多个Lambda表达式即可，而 andThen 的语义正是“一步接一步”操作。例如两个步
    骤组 合的情况：
    import java.util.function.Consumer;
    public class Demo10ConsumerAndThen {
        private static void consumeString(Consumer<String> one, Consumer<String> two) {
            one.andThen(two).accept("Hello");
        }
        public static void main(String[] args) {
            consumeString(
                 s ‐> System.out.println(s.toUpperCase()),
                 s ‐> System.out.println(s.toLowerCase()));
         }
    }
    运行结果将会首先打印完全大写的HELLO，然后打印完全小写的hello。当然，通过链式写法可以实现更
    多步骤的 组合。
         */

    }

    /*
Supplier接口
    java.util.function.Supplier<T> 接口仅包含一个无参的方法： T get() 。用来获取一个泛型参数指定类型的对象
    数据。由于这是一个函数式接口，这也就意味着对应的Lambda表达式需要“对外提供”一个符合泛型类型的对象数
    据。
     */
    private static String get_string(Supplier<String> su) {
        return su.get();
    }

    //获取数组的最大值
    public static int get_max(Supplier<Integer> su) {
        return su.get();
    }

    //下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来。
    // 要求将打印姓 名的动作作为第一个 Consumer 接口的Lambda实例，将打印性别的动作作为第二个
    // Consumer 接口的Lambda实 例，将两个 Consumer 接口按照顺序“拼接”到一起。
    private static void printinfo(Consumer<String> one, Consumer<String> two, String[] arr) {
        for (String s : arr) {
            one.andThen(two).accept(s);
        }

    }


    /*
3.5 Predicate接口
    有时候我们需要对某种类型的数据进行判断，从而得到一个boolean值结果。这时可以使用
    java.util.function.Predicate<T> 接口。
    抽象方法：test Predicate 接口中包含一个抽象方法： boolean test(T t) 。用于条件判断的场景：
     */

    private static void fum01(Predicate<String> predicate) {
        boolean resu = predicate.test("helloword");
        System.out.println("无前长吗？" + resu);
    }


    /*
默认方法：
    and 既然是条件判断，就会存在与、或、非三种常见的逻辑关系。其中将两个 Predicate 条件使用“与”
    逻辑连接起来实 现“并且”的效果时，可以使用default方法 and 。
     */
    private static void method(Predicate<String> one, Predicate<String> two) {
        boolean isValid = one.and(two).test("Helloworld");
        System.out.println("字符串符合要求吗：" + isValid);
    }

    /*
    默认方法：or 与 and 的“与”类似，默认方法 or 实现逻辑关系中的“或”。
     */
    private static void method1(Predicate<String> one, Predicate<String> two) {
        boolean isValid = one.or(two).test("Helloworld");
        System.out.println("字符串符合要求吗：" + isValid);
    }

    /*
默认方法：negate “与”、“或”已经了解了，剩下的“非”（取反）也会简单。默认方法 negate 的JDK源
代码为：
从实现中很容易看出，它是执行了test方法之后，对结果boolean值进行“!”取反而已。一定要在 test 方法调用
之前 调用 negate 方法，正如 and 和 or 方法一样：
     */
    private static void fum02(Predicate<String> predicate) {
        boolean resu = predicate.negate().test("helloword");
        System.out.println("无前长吗？" + resu);
    }

    /*
练习：集合信息筛选
    题目数组当中有多条“姓名+性别”的信息如下，请通过 Predicate 接口的拼装将符合要求的字符串筛选到
    集合 ArrayList 中，需要同时满足两个条件：
    1. 必须为女生；
    2. 姓名为4个字。
     */
    private static List<String> filter(Predicate<String> one, Predicate<String> two, String[] arr) {
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (one.and(two).test(s)) {
                list.add(s);
            }
        }
        return list;
    }


     /*
 Function接口
     java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称为前
     置条件， 后者称为后置条件。
     抽象方法：apply Function 接口中最主要的抽象方法为： R apply(T t) ，根据类型T的参数获取类型R
     的结果。 使用的场景例如：将 String 类型转换为 Integer 类型。
     import java.util.function.Function;
     public class Demo11FunctionApply {
         private static void method(Function<String, Integer> function) {
         int num = function.apply("10");
         System.out.println(num + 20);
     }
     public static void main(String[] args) {
         method(s ‐> Integer.parseInt(s));
         }
     }


      */


}
