package Day20;
/*
根据数据的流向分为：输入流和输出流。
    输入流 ：把数据从 其他设备 上读取到 内存 中的流。
    输出流 ：把数据从 内存 中写出到 其他设备 上的流。
格局数据的类型分为：字节流和字符流。
    字节流 ：以字节为单位，读写数据的流。
    字符流 ：以字符为单位，读写数据的流。
 */

//import com.sun.org.apache.xpath.internal.operations.String;
import sun.swing.SwingUtilities2;

import java.io.*;

public class ZiJieLiu_ {
    public static void main(String[] args) throws IOException {
        /*
2.1 一切皆为字节
    一切文件数据(文本、图片、视频等)在存储时，都是以二进制数字的形式保存，都一个一个的字节，那么传
    输时一样如此。所以，字节流可以传输任意文件数据。在操作流的时候，我们要时刻明确，无论使用什么样
    的流对象，底层传输的始终为二进制数据。
2.2 字节输出流【OutputStream】
    java.io.OutputStream 抽象类是表示字节输出流的所有类的超类，将指定的字节信息写出到目的地。它定义
    了字 节输出流的基本共性功能方法。
    public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
    public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
    public void write(byte[] b) ：将 b.length字节从指定的字节数组写入此输出流。
    public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开
        始输 出到此输出流。
    public abstract void write(int b) ：将指定的字节输出流。
    小贴士： close方法，当完成流的操作时，必须调用此方法，释放系统资源。
2.3 FileOutputStream类
    OutputStream 有很多子类，我们从最简单的一个子类开始。
    java.io.FileOutputStream 类是文件输出流，用于将数据写出到文件。
    构造方法
        public FileOutputStream(File file) ：创建文件输出流以写入由指定的 File对象表示的文件。
        public FileOutputStream(String name) ： 创建文件输出流以指定的名称写入文件。
    当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有这个文件，会创建该文件。如果有
    这个文件，会清空这个文件的数据。
         */
        File f  = new File("E:/learn_java/data/cc.txt");
        FileOutputStream fos = new FileOutputStream(f);
//没有就会创建
        FileOutputStream fos1 = new FileOutputStream("E:/learn_java/data/cc1.txt");

        /*
写出字节数据 1. 写出字节： write(int b) 方法，每次可以写出一个字节数据，代码使用演示：
         */
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.close();
        //1. 虽然参数为int类型四个字节，但是只会保留一个字节的信息写出。
        // 2. 流操作完毕后，必须释放系统资源，调用close方法，千万记得。


        //写出字节数组： write(byte[] b) ，每次可以写出数组中的数据，代码使用演示：
        byte[] b = "好好学习".getBytes();
        fos1.write(b);
        fos1.close();


        /*
写出指定长度字节数组： write(byte[] b, int off, int len) ,每次写出从off索引开始，len个字节，
代码 使用演示：
public class FOSWrite {
    public static void main(String[] args) throws IOException { /
        / 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
        // 字符串转换为字节数组
        byte[] b = "abcde".getBytes();
        // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
        fos.write(b,2,2);
        // 关闭资源
        fos.close();
        }
      }
输出结果： cd
         */



        /*
数据追加续写
    经过以上的演示，每次程序运行，创建输出流对象，都会清空目标文件中的数据。如何保留目标文件中数据，
    还能 继续添加新数据呢？
        public FileOutputStream(File file, boolean append) ： 创建文件输出流以写入由指定的 File对象
          表示的 文件。
        public FileOutputStream(String name, boolean append) ： 创建文件输出流以指定的名称写入文件。
     这两个构造方法，参数中都需要传入一个boolean类型的值， true 表示追加数据， false 表示清空原有数
     据。 这样创建的输出流对象，就可以指定是否追加续写了，代码使用演示：
         */
        FileOutputStream fos2 = new FileOutputStream("E:/learn_java/data/cc1.txt",true);
        byte[] b1 = "abcde".getBytes();
        fos2.write(b1);
        fos2.close();


        /*
  写出换行
      Windows系统里，换行符号是 \r\n 。把 以指定是否追加续写了，代码使用演示：
      public class FOSWrite {
          public static void main(String[] args) throws IOException {
          // 使用文件名称创建流对象
          FileOutputStream fos = new FileOutputStream("fos.txt");
          // 定义字节数组
          byte[] words = {97,98,99,100,101};
          // 遍历数组
          for (int i = 0; i < words.length; i++) {
               // 写出一个字节
               fos.write(words[i]);
               // 写出一个换行, 换行符号转成数组写出
               fos.write("\r\n".getBytes());
               }//
               关闭资源
               fos.close();
              }
          }
          输出结果：
          a
          b
          c
          d
          e
回车符 \r 和换行符 \n ：
    回车符：回到一行的开头（return）。
    换行符：下一行（newline）。 系统中的换行： Windows系统里，每行结尾是 回车+换行 ，即 \r\n ； Unix系统里，每行结尾只有 换行 ，即 \n ； Mac系统里，每行结尾是 回车 ，即 \r 。从 Mac OS X开始与Linux统一。
         */






        /*
字节输入流【InputStream】
    java.io.InputStream 抽象类是表示字节输入流的所有类的超类，可以读取字节信息到内存中。它定义了字节输入
      流的基本共性功能方法。
    public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
    public abstract int read() ： 从输入流读取数据的下一个字节。
    public int read(byte[] b) ： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。
 小贴士： close方法，当完成流的操作时，必须调用此方法，释放系统资源。

2.5 FileInputStream类
    java.io.FileInputStream 类是文件输入流，从文件中读取字节。
    构造方法 FileInputStream(File file) ： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由
    文件系 统中的 File对象 file命名。
     FileInputStream(String name) ： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件
     系统中的路径名 name命名。
 当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出 FileNotFoundException 。
 构造举例，代码如下：
    public class FileInputStreamConstructor throws IOException{
        public static void main(String[] args) {
             // 使用File对象创建流对象
             File file = new File("a.txt");
             FileInputStream fos = new FileInputStream(file);
             // 使用文件名称创建流对象
             FileInputStream fos = new FileInputStream("b.txt");
              }
          }
         */
        //读操作 read 方法，每次可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回 -1
        FileInputStream fi = new FileInputStream("E:/learn_java/data/read.txt");
        int bf;
        while ((bf = fi.read()) != -1){
            System.out.println((char)bf);
        }
        fi.close();
        //小贴士： 1. 虽然读取了一个字节，但是会自动提升为int类型。
        // 2. 流操作完毕后，必须释放系统资源，调用close方法，千万记得。


        //使用字节数组读取： read(byte[] b) ，每次读取b的长度个字节到数组中，返回读取到的有
        // 效字节个数，读 取到末尾时，返回 -1 ，代码使用演示：
        FileInputStream fi1 = new FileInputStream("E:/learn_java/data/read.txt");
        int len;
        byte[] bb = new byte[2];
//        while ((len = fi1.read(bb)) != -1){
//            System.out.println(new String(bb));
//        }
        //正确用法
        while ((len = fi1.read(bb)) != -1){
            System.out.println(new String(bb,0,len));
        }
        fi1.close();
//小贴士： 使用数组读取，每次读取多个字节，减少了系统间的IO操作次数，从而提高了读
// 写的效率，建议开发中使用。


        //复制图片 从已有文件中读取字节，将该字节写出到另一个文件中
        copy_pic("E:/learn_java/data/pic01/dog.jpg","E:/learn_java/data/pic02/copy_dog.jpg");

    }

    private static void copy_pic(String name01,String name02) throws IOException {
        FileInputStream fi = new FileInputStream(name01);
        FileOutputStream fo = new FileOutputStream(name02);

        byte[] by = new byte[1024];
        int len;
        while ((len = fi.read(by)) != -1){
            fo.write(by,0,len);
        }

        fi.close();
        fo.close();

    }
}
