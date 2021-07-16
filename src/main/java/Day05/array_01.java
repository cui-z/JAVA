package Day05;
/*
数组就是存储数据长度固定的容器，其中保证多个数据的数据类型完全一致
 */

public class array_01 {

    public static void main(String[] args) {
        //  创建1  数据类型[] 数组名称 = new 数据类型[长度]

        int[] arr1 = new  int[3];

        // 创建2 数据类型[] 数组名称 = new 数据类型[]{元素1，元素2 。。。}

        int[] arr2 = new int[]{1,2,3,4};


        //创建3  数据类型[] 数组名称 = {元素1 ，2,3, ...}

        int[]  arr3  = {1,2,3,4};
        for (int i : arr3) {
            System.out.println(i);
        }

        System.out.println("-------------------------");

        //数组访问
        int[] arr = {1,6,3,4,8};
        // 数组索引
        System.out.println(arr[0]);
        // 数组长度
        System.out.println(arr.length);
        // f索引复制
        arr[0] = 100;
        System.out.println(arr[0]);
    }
}
