package Day07;


import java.util.ArrayList;

public class Array_list_ {
    public static void main(String[] args) {
        Student[] sds = new Student[3];

        Student s1 = new Student("a",12);
        Student s2 = new Student("b",13);
        Student s3 = new Student("c",14);
        sds[0]= s1;
        sds[1] = s2;
        sds[2] = s3;

        for (int i = 0; i < sds.length; i++) {
            Student sd = sds[i];
            System.out.println(sd.getAge()+"----------"+sd.getName());

        }

        /*
        由于数组array是固定长度   引入ArrayList 为可变长数组
         */

        ArrayList<String> al  = new ArrayList<String>();
        String s4 = "a";
        String s5 = "b";
        String s6 = "c";
        System.out.println(al);
        al.add(s4);
        al.add(s5);
        al.add(s6);
        System.out.println(al);
        System.out.println("=======================");
        /*
        常用方法
            add 添加元素到集合尾部
            remove 删除指定位置元素，返回被删除值
            get  获取指定位置元素 返回
            size  返回元素个数
         */

        System.out.println("get " + al.get(0));
        System.out.println("size "+ al.size());
        System.out.println("remove " + al.remove(0));
// 遍历 arraylist
        for (int i = 0 ;i < al.size();i++){
            System.out.print(al.get(i));
        }


        /*
        ArrayList 不能存储基本数据类型  只能存储引用类型 比如 <int> 就是错的
        为了能够存储基本数据类型 需要转换 如下
        基本类型 基本类型包装类
        byte       Byte
        short      Short
        int        Integer
        long       Long
        float      Float
        double     Double
        char       Character
        boolean    Boolean
         */

        ArrayList<Integer> int_arr = new ArrayList<Integer>();
        int_arr.add(4);
        int bb = 6;
        int_arr.add(bb);
        System.out.println(int_arr);


    }


}

