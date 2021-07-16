package Day08;

/*
 static 关键字  可以用来修饰 成员变量 和成员方法 被修饰的成员是属于类的 不是单单属于
     某个对象。也就是说 既然属于类 就可以不依靠创建对象来调用


 类变量(修饰成员变量）  static修饰成员变量时，该变量称为类变量。该类的每个对象都享同一个类变量的
     值。任何对象都可以更改该类变量的值，但也可以在不创建该类的对象
     的情况下对类变量进行操作 。
     static 数据类型 变量名；

 静态方法（修饰成员方法） 该方法称为类方法，静态方法在声明中有static,
     建议使用类名来调用，而不需要创建类的对象，调用方式比较简单



 静态代码块     定义在成员位置，使用static修饰的代码块{ }。
                    位置：类中方法外。
                    执行：随着类的加载而执行且执行一次，优先于main方法和构造方法的执行。

           public class Game {
               public static int number;
               public static ArrayList<String> list;
               static {
                   // 给类变量赋值
                   number = 2;
                   list = new ArrayList<String>();
                   // 添加元素到集合中
                   list.add("张三");
                   list.add("李四");
                   }
                }


 */

public class Static_ {
    public static void main(String[] args) {

        //类变量  比如说，基础班新班开班，学员报到。
        // 现在想为每一位新来报到的同学编学号（sid），
        // 从第一名同学开始，sid为 1，以此类推。学号必须是唯一的，
        // 连续的，并且与班级的人数相符，这样以便知道，
        // 要分配给下一名新同学的学 号是多少。这样我们就需要一个变量，’
        // 与单独的每一个学生对象无关，而是与整个班级同学数量有关。
        Student s1 = new Student("aa",11);
        Student s2 = new Student("bb",12);
        Student s3 = new Student("cc",13);
        s1.show();
        s2.show();
        s3.show();


        //静态方法
         // 直接用类名来调用

        /*
        注意事项：
            静态方法可以访问 类变量 和 类方法（静态方法）
            静态方法不能访问普通成员变量或者成员方法。反之可以
            静态方法中不能出现this关键字
         */
        System.out.println(Student.number);
        Student.shownum();
    }
}
