package Day19;

import java.io.File;

/*
递归：指在当前方法内调用自己的这种现象。
递归的分类:
    递归分为两种，直接递归和间接递归。
        直接递归称为方法自身调用自己。
        间接递归可以A方法调用B方法，B方法调用C方法，C方法调用A方法。
注意事项：
    递归一定要有条件限定，保证递归能够停止下来，否则会发生栈内存溢出。
    在递归中虽然有限定条件，但是递归次数不能太多。否则也会发生栈内存溢出。
     构造方法,禁止递归
 */
public class DiGui_ {
    public static void main(String[] args) {
        //求1-n的和
        System.out.println(get_sum(5));

        //求1-n的阶乘
        System.out.println(get_mul(4));

        //递归打印多级目录
        File f1 = new File("E:/learn_java/test01");
        get_file_name(f1);



    }

    public static int get_sum(int n){
        if(n == 1){
            return 1;
        }
        return n + get_sum(n-1);

    }
    public static int get_mul(int n){
        if(n ==1){
            return 1;
        }
        return n*get_mul(n-1);
    }
    public static void get_file_name(File f){
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile()){
                System.out.println("文件名 "+file.getAbsolutePath());
            } else {
                get_file_name(file);
            }
        }
    }
}
