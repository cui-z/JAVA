package Day19;

import java.io.File;
import java.io.IOException;

/*
java.io.File 类是文件和目录路径名的抽象表示，主要用于文件和目录的创建、
     查找和删除等操作。
 */
public class File_ {
    public static void main(String[] args) throws IOException {
        //构造方法
//public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
        String path = "data/aa.txt";
        File f1 = new File(path);
// public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
        String parent = "E\\learn_java\\data";
        String child = "aa.txt";
        File f2 = new File(parent, child);
// public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
        File f3 = new File("E\\learn_java\\data");
        File f4 = new File(f3, child);

        System.out.println("-----------------------------");
        //常用方法
//        public String getAbsolutePath() ：返回此File的绝对路径名字符串。
        System.out.println("绝对路径"+f1.getAbsolutePath());
//        public String getPath() ：将此File转换为路径名字符串。
        System.out.println("路径名字符串"+f1.getPath());
//        public String getName() ：返回由此File表示的文件或目录的名称。
        System.out.println("文件或者目录名称"+f1.getName());
//        public long length() ：返回由此File表示的文件的长度。
        System.out.println("文件的长度为"+f1.length());

        System.out.println("---------------------------------");
        //判断功能的方法
//        public boolean exists() ：此File表示的文件或目录是否实际存在。
        File f5 = new File("data/nnv.txt");
        System.out.println(f5.exists());
        System.out.println(f1.exists());
//        public boolean isDirectory() ：此File表示的是否为目录。
        System.out.println(f1.isDirectory());
//        public boolean isFile() ：此File表示的是否为文件。
        System.out.println(f1.isFile());

        System.out.println("_-----------------------------");

        //创建删除功能的方法
//        public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建
//       一个新的空文件。
        File f6 = new File("data/bb.txt");
        System.out.println(f6.exists());
        System.out.println("创建"+f6.createNewFile());
        System.out.println("文件存在"+f6.exists());
//        public boolean delete() ：删除由此File表示的文件或目录。
        System.out.println("删除"+f6.delete());
//        public boolean mkdir() ：创建由此File表示的目录。
        File f7 = new File("test");
        System.out.println("创建目录"+f7.mkdir());
//        public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
        File f8 = new File("test01/aa");
        System.out.println("连续创建目录"+f8.mkdirs());
        System.out.println("-----------------------------------");


        //目录遍历
//        public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
        File f9 = new File("test01");
        String[] arr  = f9.list();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.print(s+"     ");
        }
        System.out.println();
        System.out.println("=======================");
//        public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
        File[] arr01 = f9.listFiles();
        for (int i = 0; i < arr01.length; i++) {
            File file = arr01[i];
            System.out.print(file+ "    ");
        }
    }
}
