package Day06;

/*
封装：面向对象编程语言是对客观世界的模拟，客观世界里成员变量都是隐藏在对象内部的，
    外界无法直接操作和修改。 封装可以被认为是一个保护屏障，防止该类的代码和数据被其他类随意访问。
    要访问该类的数据，必须通过指定的 方式。适当的封装可以让代码更容易理解与维护，也加强了代码的安全性。

步骤：
    使用private关键字来修饰成员变量
    如果需要访问 需要 set get 方法

被private修饰后的成员变量和成员方法，只能在本类中访问
例：
public class Student {
     private String name;
     private int age;
     public void setName(String n) {
          name = n;
          }
      public String getName() {
          return name;
          }
      public void setAge(int a) {
           age = a;
           }
       public int getAge() {
        return age;
         }
     }

 可以看出  set get 的形参跟本来的age name  不是同一个意思 ，为了能使用同一个 引入this关键字

this  表示所在类的对象自己的引用
public class Student {
     private String name;
     private int age;
     public void setName(String name) {
          this.name = name;
          }
      public String getName() {
          return name;
          }
      public void setAge(int age) {
           this.age = age;
           }
       public int getAge() {
        return age;
         }
     }


构造方法
    当一个对象被创建时候，构造方法用来初始化该对象，给对象的成员变量赋初始值。
    小贴士：无论你与否自定义构造方法，所有的类都有构造方法，因为Java自动提供了一个无参数构造方法，
     一旦自己定义了构造方法，Java自动提供的默认无参数构造方法就会失效。

    格式：
        修饰符 构造方法名（参数列表）{
            方法体
            }
     public class Student {
          private String name;
          private int age;
          // 无参数构造方法
          public Student() {}
          // 有参数构造方法
          public Student(String name,int age) {
               this.name = name;
               this.age = age;
               }
     }


javaBean规范  要求类必须是具体的和公共的  有无参构造方法  有set get方法

 */

public class Private_ {
    public static void main(String[] args) {
        Student_Bean st  = new Student_Bean();
        st.setAge(18);
        st.setName(" wang 5");
        System.out.println("姓名"+st.getName()+"年龄"+st.getAge());


        Student_Bean s  = new Student_Bean("lisi" , 28);
        System.out.println("姓名"+s.getName()+"年龄"+s.getAge());

    }



}
