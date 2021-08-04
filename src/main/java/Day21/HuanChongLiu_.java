package Day21;
/*
昨天学习了基本的一些流，作为IO流的入门，今天我们要见识一些更强大的流。比如能够高效读写的缓冲流，能够
   转换编码的转换流，能够持久化存储对象的序列化流等等。这些功能更为强大的流，都是在基本的流对象基础之
   上 创建而来的，就像穿上铠甲的武士一样，相当于是对基本流对象的一种增强。

1.1 概述
    缓冲流,也叫高效流，是对4个基本的 FileXxx 流的增强，所以也是4个流，按照数据类型分类：
      字节缓冲流： BufferedInputStream ， BufferedOutputStream
      字符缓冲流： BufferedReader ， BufferedWriter
    缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少
    系统IO 次数，从而提高读写的效率。


1.2 字节缓冲流 构造方法
    public BufferedInputStream(InputStream in) ：创建一个 新的缓冲输入流。
    public BufferedOutputStream(OutputStream out) ： 创建一个新的缓冲输出流。
    构造举例，代码如下：

    // 创建字节缓冲输入流
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bis.txt"));
    // 创建字节缓冲输出流
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt"));

    效率测试 查询API，缓冲流读写方法与基本的流是一致的，我们通过复制大文件（375MB），测试它的效率。
     1. 基本流，代码如下：
     public class BufferedDemo {
         public static void main(String[] args) throws FileNotFoundException {
         // 记录开始时间
         long start = System.currentTimeMillis();
         // 创建流对象
         try (
             FileInputStream fis = new FileInputStream("jdk9.exe");
             FileOutputStream fos = new FileOutputStream("copy.exe")
          ){ // 读写数据
              int b;
              while ((b = fis.read()) != ‐1) { fos.write(b); }
          } catch (IOException e) {
              e.printStackTrace(); }
          // 记录结束时间
          long end = System.currentTimeMillis();
          System.out.println("普通流复制时间:"+(end ‐ start)+" 毫秒"); }
      }十几分钟过去了...
     2. 缓冲流，代码如下：
     public class BufferedDemo {
         public static void main(String[] args) throws FileNotFoundException {
             // 记录开始时间
             long start = System.currentTimeMillis();
             // 创建流对象
             try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("jdk9.exe"));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.exe"));
             ){
                 // 读写数据
                 int b;
                 while ((b = bis.read()) != ‐1) {
                 bos.write(b); }
              } catch (IOException e) {
                  e.printStackTrace();
              }
              // 记录结束时间
              long end = System.currentTimeMillis();
              System.out.println("缓冲流复制时间:"+(end ‐ start)+" 毫秒");
              }
    }缓冲流复制时间:8016 毫秒

    如何更快呢？ 使用数组的方式，代码如下：
    public class BufferedDemo {
        public static void main(String[] args) throws FileNotFoundException {
            // 记录开始时间
            long start = System.currentTimeMillis();
            // 创建流对象
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("jdk9.exe"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.exe"));
                ){
                    // 读写数据
                    int len;
                    byte[] bytes = new byte[8*1024];
                    while ((len = bis.read(bytes)) != ‐1) {
                        bos.write(bytes, 0 , len);
                        }
             } catch (IOException e) { e.printStackTrace(); }
             // 记录结束时间
             long end = System.currentTimeMillis();
             System.out.println("缓冲流使用数组复制时间:"+(end ‐ start)+" 毫秒");
             }
     }缓冲流使用数组复制时间:666 毫秒




1.3 字符缓冲流
    构造方法
        public BufferedReader(Reader in) ：创建一个 新的缓冲输入流。
        public BufferedWriter(Writer out) ： 创建一个新的缓冲输出流

    构造举例，代码如下：
    // 创建字符缓冲输入流
    BufferedReader br = new BufferedReader(new FileReader("br.txt"));
    // 创建字符缓冲输出流
    BufferedWriter bw = new BufferedWriter(new FileWriter("bw.txt"));

    特有方法
      字符缓冲流的基本方法与普通字符流调用方式一致，不再阐述，我们来看它们具备的特有方法。
      BufferedReader： public String readLine() : 读一行文字。
      BufferedWriter： public void newLine() : 写一行行分隔符,由系统属性定义符号。


    readLine 方法演示，代码如下：
    public class BufferedReaderDemo {
        public static void main(String[] args) throws IOException {
            // 创建流对象
            BufferedReader br = new BufferedReader(new FileReader("in.txt"));
            // 定义字符串,保存读取的一行文字
            String line = null;
            // 循环读取,读取到最后返回null
            while ((line = br.readLine())!=null) {
                System.out.print(line);
                System.out.println("‐‐‐‐‐‐");
                }
            // 释放资源 br.close(); } }

     newLine 方法演示，代码如下
     public class BufferedWriterDemo throws IOException {
         public static void main(String[] args) throws IOException {
             // 创建流对象
             BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
              // 写出数据
              bw.write("黑马");
              // 写出换行
              bw.newLine();
              bw.write("程序");
              bw.newLine();
              bw.write("员");
              bw.newLine();
              // 释放资源
              bw.close(); } }

 */

import Day10.B;

import java.io.*;
import java.util.HashMap;

public class HuanChongLiu_ {
    public static void main(String[] args) throws IOException {
        //文本排序
        HashMap<String,String > map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("E:/learn_java/data/paixu.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/learn_java/data/paixuhou.txt"));

        String line = null;
        while ((line = br.readLine()) != null){
            String[] split = line.split("\\.");
            map.put(split[0],split[1]);
        }
        br.close();
        for(int i = 1;i <= map.size();i++){
            String k = i+"";
            String v = map.get(k);
            bw.write(k+"."+v);
            bw.newLine();
        }
        bw.close();

    }
}
