package Day20;
/*
当使用字节流读取文本文件时，可能会有一个小问题。就是遇到中文字符时，可能不会显示完整的字符，那是
因为 一个中文字符可能占用多个字节存储。所以Java提供一些字符流类，以字符为单位读写数据，专门用于
处理文本文 件。
 */



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZiFuLiu_ {
    public static void main(String[] args) throws IOException {
  /*
3.1 字符输入流【Reader】
    java.io.Reader 抽象类是表示用于读取字符流的所有类的超类，可以读取字符信息到内存中。它定义了字
    符输入 流的基本共性功能方法。
    public void close() ：关闭此流并释放与此流相关联的任何系统资源。
    public int read() ： 从输入流读取一个字符。
     public int read(char[] cbuf) ： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。
3.2 FileReader类
    java.io.FileReader 类是读取字符文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。
    小贴士：
        1. 字符编码：字节与字符的对应规则。Windows系统的中文编码默认是GBK编码表。 idea中UTF-8
        2. 字节缓冲区：一个字节数组，用来临时存储字节数据。
    构造方法
        FileReader(File file) ：创建一个新的 FileReader ，给定要读取的File对象。
        FileReader(String fileName) ： 创建一个新的 FileReader ，给定要读取的文件的名称。
    当你创建一个流对象时，必须传入一个文件路径。类似于FileInputStream 。 构造举例，代码如下：
     public class FileReaderConstructor throws IOException{
         public static void main(String[] args) {
             // 使用File对象创建流对象
             File file = new File("a.txt");
             FileReader fr = new FileReader(file);
             // 使用文件名称创建流对象
             FileReader fr = new FileReader("b.txt");
             }
         }
    读取字符数据 1. 读取字符： read 方法，每次可以读取一个字符的数据，提升为int类型，读取到文件末尾
        ，返回 -1 ，循环读 取，代码使用演示：
   */
        FileReader fr = new FileReader("E:/learn_java/data/read01.txt");
        //定义变量，保存数据
        int b;
        while ((b =  fr.read()) != -1) System.out.println((char) b);

//使用字符数组读取： read(char[] cbuf) ，每次读取b的长度个字符到数组中，返回读取到的有效字
// 符个数， 读取到末尾时，返回 -1 ，代码使用演示：
        FileReader fr1 = new FileReader("E:/learn_java/data/read01.txt");
        //定义变量，保存有效字符个数
        int len;
        char[] ch = new char[2];
        while ((len = fr1.read(ch)) != -1){
            System.out.println(new String(ch ,0, len));
        }
        fr1.close();

        /*
3.3 字符输出流【Writer】
  java.io.Writer
      抽象类是表示用于写出字符流的所有类的超类，将指定的字符信息写出到目的地。它定义了字节
       输出流的基本共性功能方法。
       void write(int c) 写入单个字符。
       void write(char[] cbuf) 写入字符数组。
       abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分,off数组的
          开始索引,len 写的字符个数。
       void write(String str) 写入字符串。
       void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引
            ,len写的字符个 数。void flush() 刷新该流的缓冲。
       void close() 关闭此流，但要先刷新它。
3.4 FileWriter类
    java.io.FileWriter 类是写出字符到文件的便利类。构造时使用系统默认的字符编码和默认字节
       缓冲区。
    构造方法
      FileWriter(File file) ： 创建一个新的 FileWriter，给定要读取的File对象。
      FileWriter(String fileName) ： 创建一个新的 FileWriter，给定要读取的文件的名称。
    当你创建一个流对象时，必须传入一个文件路径，类似于FileOutputStream。
     构造举例，代码如下：
     public class FileWriterConstructor {
         public static void main(String[] args) throws IOException {
              // 使用File对象创建流对象
              File file = new File("a.txt");
              FileWriter fw = new FileWriter(file);
              // 使用文件名称创建流对象
              FileWriter fw = new FileWriter("b.txt");
               }
            }
     基本写出数据 写出字符： write(int b) 方法，每次可以写出一个字符数据，代码使用演示：
         */
        FileWriter fr04 = new FileWriter("E:/learn_java/data/write01.txt");
        fr04.write(97);
        fr04.write("97");
        fr04.write("a");
        fr04.write(30000);
        //【注意】关闭资源时,与FileOutputStream不同。 如果不关闭,数据只是保存到缓冲区，并未保存到文件。
        fr04.close();
        //小贴士：
        // 1. 虽然参数为int类型四个字节，但是只会保留一个字符的信息写出。
        // 2. 未调用close方法，数据只是保存到了缓冲区，并未写出到文件中。

        /*
关闭和刷新
    因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无
    法继续写出数据 的。如果我们既想写出数据，又想继续使用流，就需要 flush 方法了。
    flush ：刷新缓冲区，流对象可以继续使用。
    close :先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了
         */
        FileWriter fr05 = new FileWriter("E:/learn_java/data/write02.txt");
        fr05.write("哈哈");
        fr05.flush();
        fr05.write("学习");
        fr05.close();

        /*
写出其他数据
  1. 写出字符数组 ： write(char[] cbuf) 和 write(char[] cbuf, int off, int len) ，每次可
     以写出字符数组中的数据，用法类似FileOutputStream，代码使用演示：
     public class FWWrite {
         public static void main(String[] args) throws IOException {
            // 使用文件名称创建流对象
            FileWriter fw = new FileWriter("fw.txt"); \
            // 字符串转换为字节数组
            char[] chars = "黑马程序员".toCharArray();
            // 写出字符数组
            fw.write(chars);
            // 黑马程序员
            // 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
             fw.write(b,2,2); // 程序
             // 关闭资源
             fos.close();
             }
           }
  2. 写出字符串： write(String str) 和 write(String str, int off, int len) ，每次可以写出
    字符串中的 数据，更为方便，代码使用演示：
    public class FWWrite {
        public static void main(String[] args) throws IOException {
              // 使用文件名称创建流对象
              FileWriter fw = new FileWriter("fw.txt");
              // 字符串
              String msg = "黑马程序员";
              // 写出字符数组
              fw.write(msg); //黑马程序员
              // 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
              fw.write(msg,2,2); // 程序
              // 关闭资源
              fos.close();
              }
         }
3. 续写和换行：操作类似于FileOutputStream。
    public class FWWrite {
        public static void main(String[] args) throws IOException {
            // 使用文件名称创建流对象，可以续写数据
             F ileWriter fw = new FileWriter("fw.txt"，true);
             // 写出字符串
             fw.write("黑马");
             // 写出换行
             fw.write("\r\n");
             // 写出字符串
             fw.write("程序员");
             // 关闭资源
              f w.close();
               }
             }
  小贴士：字符流，只能操作文本文件，不能操作图片，视频等非文本文件。 当我们单纯读或者写文本文件时 使用字符流 其他情况使用字节流
         */





    }
}
