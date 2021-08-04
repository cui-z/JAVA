package Day14;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
java.utils.Collections 是集合工具类，用来对集合进行操作。部分方法如下：
public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
public static void shuffle(List<?> list) 打乱顺序 :打乱集合顺序。
public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。
public static <T> void sort(List<T> list，Comparator<? super T> ) :将集合中元素按照指定规则排 序。
 */
public class Collections_ {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr,1,33,6,23);
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);


        /*
 发现我们的集合按照顺序进行了排列，可是这样的顺序是采用默认的顺序，如果想要指定顺序那该 怎么办呢？

比如我想要字符串按照第 一个字符降序排列，那么这样就要修改String的源
  代码，这是不可能的了，那么这个时候我们可以使用
  public static <T> void sort(List<T> list，Comparator<? super T> )
   方法灵活的完成，这个里面就涉及到了 Comparator这个接口，位于位于
   java.util包下，排序是comparator能实现的功能之一,该接口代表一个比
   较器，比 较器具有可比性！顾名思义就是做排序的，通俗地讲需要比较
   两个对象谁排在前谁排在后，那么比较的方法就是：
   public int compare(String o1, String o2) ：
       比较其两个参数的顺序。 两个对象比较的结果有三种：大于，等于，
       小于。 如果要按照升序排序， 则o1 小于o2，返回（负数），相等
       返回0，01大于02返回（正数） 如果要按照 降序排序 则o1 小于o2
       ，返回（正数），相等返回0，01大于02返回（负数）
         */

        ArrayList<String> list = new ArrayList<String>();
        list.add("cba");
        list.add("aba");
        list.add("sba");
        list.add("nba");
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //首字母降序
                return o2.charAt(0) - o1.charAt(0);
            }
        });
        System.out.println(list);



        ArrayList<Student> as = new ArrayList<Student>();
        as.add(new Student("aa",15));
        as.add(new Student("cc",45));
        as.add(new Student("bb",10));
        as.add(new Student("bb",15));
        as.add(new Student("dd",15));
        Collections.sort(as, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o2.getAge() - o1.getAge();  //年龄降序
                if(result == 0){
                    //首字母升序
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;

            }
        });
        System.out.println(as);
     }
}
