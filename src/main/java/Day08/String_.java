package Day08;

/*

String 类代表字符串， java中所有的字符串文字都可以看做是此类的实例

 */

import java.util.Scanner;

public class String_ {
    public static void main(String[] args) {
        //字符串不变：字符串在创建后不能被改变

        String s1 = "abc";
        s1 += "d";
        System.out.println(s1); // s1 本来指向abc 后来指向abcd

        // 字符串不变性，所以是可以被共享

        String s2 = "abc";
        String s3 = "abc"; //内存中只有一个 abc 同事被s1 s2共享

        //  常用方法   equals  字符串与指定对象进行比较
        // euqalsIgnoreCase   忽略大小写的比较

        String s4 = "ABC";
        System.out.println(s2.equals(s3));
        System.out.println(s2.equals(s4));
        System.out.println(s3.equalsIgnoreCase(s4));
        System.out.println("=======================");


        String s = "helloword";
        // length  返回长度
        System.out.println(s.length());
        // concat 将指定字符串连接到该字符串后面
        String concat_s = s.concat("hahahaha");
        System.out.println(concat_s);
        // charAt  返回指定所引处的char值
        System.out.println(s.charAt(2));
        // indexOf  返回第一次出现该字符的索引
        System.out.println(s.indexOf("l"));
        System.out.println(s.indexOf("ll"));
        // substring(int i) 返回从i开始到结尾的字符串
        System.out.println(s.substring(3));
        //  substring(int i, int j) 返回从i 到 j 的字符串切片
        System.out.println(s.substring(3,6));
        // replace(ratget,replacement) 将target替换掉
        System.out.println(s.replace("hell","HELL"));


        // split 分割功能 分割成为字符串数组
        String s6  = "hello word hello java";
        String[] s7 = s6.split(" ");
        for (int i = 0; i < s7.length; i++) {
            String ss = s7[i];
            System.out.println(ss);
        }
        System.out.println("===========");


        //键盘录入字符串，统计字符串 大写 小写  数字 的 个数
        get_num();


    }

    public static void  get_num(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输出字符串");
        String s = sc.nextLine();

        int big = 0;
        int small = 0;
        int num = 0;
        for(int i = 0 ; i < s.length();i++){
            char ss = s.charAt(i);
            if (ss >= 'A' && ss <= 'Z'){
                big +=1;
            }else if (ss >= 'a' && ss <= 'z'){
                small +=1;
            } else if (ss >= '0' && ss <= '9'){
                num +=1;
            }
        }
        System.out.println(" 大写字母数量为"+big);
        System.out.println(" 小写字母数量为"+small);
        System.out.println(" 数字数量为"+num);


    }
}
