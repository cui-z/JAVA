package Day07;

import java.util.ArrayList;
import java.util.Random;

public class Array_list_practice {
    public static void main(String[] args) {
        test01();
        System.out.println("=====================");
        test02();
        System.out.println("+++++++++++++++++++++");
        test03();


    }

    // 生成1-33随机数添加到集合
    public static void test01(){
        ArrayList<Integer> arr01 = new ArrayList<Integer>();
        Random rc = new Random();
        for (int i =0 ; i <10;i++){
            int num = rc.nextInt(33)+1;
            arr01.add(num);
        }
        System.out.println(arr01);
    }

    //创建学生对象添加到集合
    public static void test02(){
        ArrayList<Student>  arr = new ArrayList<Student>();
        Student s1 = new Student("aa",12);
        Student s2 = new Student("bb",34);
        arr.add(s1);
        arr.add(s2);

        for (Student student : arr) {
            System.out.println(student.getName()+"===="+student.getAge());
        }
    }


    // 定义获取所有 偶数元素集合的方法（ArryList类型作为返回值）

    public static void test03(){
        Random rc  = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0 ; i<20;i++){
            arr.add(rc.nextInt(20));
        }

        ArrayList<Integer> result = getarraylist(arr);
        System.out.println(result);

    }
    public static ArrayList<Integer> getarraylist(ArrayList<Integer> arr){
        ArrayList<Integer> small_arr = new ArrayList<Integer>();
        for (int i = 0; i<arr.size();i++){
            if (arr.get(i) %2 ==0){
                small_arr.add(arr.get(i));
            }
        }
        return small_arr;
    }

}
