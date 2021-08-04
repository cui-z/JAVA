package Day21;

import Day08.String_;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
序列化
3.1 概述
    Java 提供了一种对象序列化的机制。用一个字节序列可以表示一个对象，该字节序列包含该 对象的数据 、 对象的
     类型 和 对象中存储的属性 等信息。字节序列写出到文件之后，相当于文件中持久保存了一个对象的信息。 反之
     ，该字节序列还可以从文件中读取回来，重构对象，对它进行反序列化。 对象的数据 、 对象的类型 和 对象中存
     储的数据信息，都可以用来在内存中创建对象。
3.2 ObjectOutputStream类
    java.io.ObjectOutputStream 类，将Java对象的原始数据类型写出到文件,实现对象的持久存储。
    构造方法
         public ObjectOutputStream(OutputStream out) ： 创建一个指定OutputStream的ObjectOutputStream。
    构造举例，代码如下：
      FileOutputStream fileOut = new FileOutputStream("employee.txt");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
    序列化操作
       1. 一个对象要想序列化，必须满足两个条件:
           该类必须实现 java.io.Serializable 接口， Serializable 是一个标记接口，不实现此接口的类将不会使
           任何状态序列化或反序列化，会抛出 NotSerializableException 。
           该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，
           使用 transient 关键字修饰。

       public class Employee implements java.io.Serializable {
           public String name;
           public String address;
           public transient int age;
           // transient瞬态修饰成员,不会被序列化
           public void addressCheck() {
               System.out.println("Address check : " + name + " ‐‐ " + address);
               }
         }

       2.写出对象方法
           public final void writeObject (Object obj) : 将指定的对象写出。

       public class SerializeDemo{
           public static void main(String [] args) {
               Employee e = new Employee();
               e.name = "zhangsan";
               e.address = "beiqinglu";
               e.age = 20;
               try {
                   // 创建序列化流对象
                   ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
                   // 写出对象
                   out.writeObject(e);
                   // 释放资源
                   out.close();
                   fileOut.close();
                   System.out.println("Serialized data is saved"); // 姓名，地址被序列化，年龄没有被序列 化。
                } catch(IOException i) {
                    i.printStackTrace();
                 }
              }
           }
           输出结果： Serialized data is saved


3.3 ObjectInputStream类
  ObjectInputStream反序列化流，将之前使用ObjectOutputStream序列化的原始数据恢复为对象。
  构造方法
    public ObjectInputStream(InputStream in) ： 创建一个指定InputStream的ObjectInputStream。
反序列化操作1
     如果能找到一个对象的class文件，我们可以进行反序列化操作，调用 ObjectInputStream 读取对象
     的方法：
     public final Object readObject () : 读取一个对象。

    public class DeserializeDemo {
        public static void main(String [] args) {
            Employee e = null;
            try {
                // 创建反序列化流
                FileInputStream fileIn = new FileInputStream("employee.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                // 读取一个对象
                e = (Employee) in.readObject();
                // 释放资源
                in.close();
                fileIn.close();
             }catch(IOException i) {
                 // 捕获其他异常
                 i.printStackTrace();
                 return;
             }catch(ClassNotFoundException c) {
                  // 捕获类找不到异常
                  System.out.println("Employee class not found");
                  c.printStackTrace();
                  return;
              }// 无异常,直接打印输出
              System.out.println("Name: " + e.name); // zhangsan
              System.out.println("Address: " + e.address); // beiqinglu
              System.out.println("age: " + e.age); // 0 } }
     对于JVM可以反序列化对象，它必须是能够找到class文件的类。如果找不到该类的class文件，则抛出一个
      ClassNotFoundException 异常。

反序列化操作2
    另外，当JVM反序列化对象时，能找到class文件，但是class文件在序列化对象之后发生了修改，那么反序列
    化操 作也会失败，抛出一个 InvalidClassException 异常。发生这个异常的原因如下：
      该类的序列版本号与从流中读取的类描述符的版本号不匹配
      该类包含未知数据类型
      该类没有可访问的无参数构造方法
    Serializable 接口给需要序列化的类，提供了一个序列版本号。 serialVersionUID 该版本号的目的在于验
      证序 列化的对象和对应类是否版本匹配。
      public class Employee implements java.io.Serializable {
          // 加入序列版本号
          private static final long serialVersionUID = 1L;
          public String name; public String address;
          // 添加新的属性 ,重新编译, 可以反序列化,该属性赋为默认值.
          public int eid;
          public void addressCheck() {
              System.out.println("Address check : " + name + " ‐‐ " + address);
              }
       }

 */
public class XuLieHua_ {
    public static void main(String[] args) throws Exception{
        Student_ s1 = new Student_("aa",11);
        Student_ s2 = new Student_("bb",12);
        Student_ s3 = new Student_("cc",13);

        ArrayList<Student_> arr = new ArrayList<>();
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        //序列化
        //serialize(arr);
        String path  = "E:/learn_java/data/studentlist.txt";
        Deserialize(path);

    }
    private static void serialize(ArrayList<Student_> arr) throws Exception{
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("E:/learn_java/data/studentlist.txt"));
        os.writeObject(arr);
        os.close();
    }

    private static void Deserialize(String path) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        ArrayList<Student_> arr = (ArrayList<Student_>)ois.readObject();
        for (int i = 0; i < arr.size(); i++) {
           Student_ s = arr.get(i);
            System.out.println("姓名:"+s.getName()+" 年龄："+s.getAge());

        }

    }
}
