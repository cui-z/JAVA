package Day08;

/*
Arrays类包含操作数组的各种方法，比如排序、搜索。
    所有方法均为静态方法，调用方便
 */

import java.util.Arrays;

public class Arrays_ {
    public static void main(String[] args) {
        int[] arr = {1,2,6,9,3,5};
        // toString 数组转为字符串
        System.out.println(Arrays.toString(arr));
        // sort 按数组升序进行排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("========================");
        sort_array();
    }

   //请使用 Arrays 相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印。
    public static void sort_array(){
        String s = "aosdjfgiohuqiwegrhKJUfa";
        char[] chars  = s.toCharArray();
        Arrays.sort(chars);
        for(int i = chars.length-1;i>=0;i--){
            System.out.println(chars[i]);
        }
    }
}
