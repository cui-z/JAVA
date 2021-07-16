package Day05;

public class array_03_method {

    public static void main(String[] args) {
        int[] arr  = {1,9,3,3,8,19};
        //数组遍历 快捷键 it
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.println(i1);
        }
        System.out.println("---------------------------");
        //获取最大元素
        int max_num = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if (i1 >max_num) {
                max_num = i1;
            }
        }

        System.out.println(max_num);

        System.out.println("+++++++++++++++++++++++++");

        //数组反转,比较经典
        for (int i = 0,j=arr.length-1; i < j; i++,j--) {
            int tmp  = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.print(i1+" ");

        }
    }
}
