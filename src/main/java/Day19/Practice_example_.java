package Day19;
/*
搜索 目录中的 .hh 文件。
分析：
    1. 目录搜索，无法判断多少级目录，所以使用递归，遍历所有目录。
    2. 遍历目录时，获取的子文件，通过文件名称，判断是否符合条件。
 */

import java.io.File;
import java.io.FileFilter;

public class Practice_example_ {
    public static void main(String[] args) {
        File f = new File("E:learn_java/test01");
        printfile(f);
        System.out.println("===================");
        print_lambda(f);

    }

    //文件过滤器
    /*
java.io.FileFilter 是一个接口，是File的过滤器。 该接口的对象可以传递给File类的
     listFiles(FileFilter) 作为参数， 接口中只有一个方法。
    boolean accept(File pathname) ：测试pathname是否应该包含在当前File目录中，
        符合则返回true。
 分析：
     1. 接口作为参数，需要传递子类对象，重写其中方法。我们选择匿名内部类方式，
         比较简单。
     2. accept 方法，参数为File，表示当前File下所有的子文件和子目录。保留住则返回
         true，过滤掉则返回 false。保留规则：
              1. 要么是.java文件。
              2. 要么是目录，用于继续遍历。
     3. 通过过滤器的作用， listFiles(FileFilter) 返回的数组元素中，子文件对象都是
         符合条件的，可以直接打 印。
     */
    public static void printfile(File f){
        File[] arr  = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                //或运算
                return pathname.isDirectory()|| pathname.getName().endsWith(".hh");
            }
        });
        for (File file : arr) {
            if(file.isFile()){
                System.out.println("找到文件 "+file.getAbsolutePath());
            }else {
                printfile(file);
            }
        }
    }

    /*
    Lambda优化
        分析： FileFilter 是只有一个方法的接口，因此可以用lambda表达式简写。
    lambda格式：
        ()‐>{ }
     */
    public static void print_lambda(File f){
        File[] files  = f.listFiles(ff ->{
            return ff.isDirectory()|| ff.getName().endsWith(".hh");
        });
        for (File file : files) {
            if(file.isFile()){
                System.out.println("找到文件 "+file.getAbsolutePath());
            }else {
                printfile(file);
            }
        }

    }

}
