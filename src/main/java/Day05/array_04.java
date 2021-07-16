package Day05;

public class array_04 {
    public static void main(String[] args) {
        int[] arr ={1,4,5,2,7,0};
        test01(arr);
        System.out.println("-------------------------------");
        int[] arr1 = test02();
        for (int i = 0; i < arr1.length; i++) {
            int i1 = arr1[i];
            System.out.print(i1+" ");

        }

        System.out.println("+++++++++++++++++++++++++++++");
//  方法的参数 为基本类型时  传递的是数据值
        //  参数为引用类型时  传递的是地址
        int a = 1;
        int b =2;
        System.out.println(a);
        System.out.println(b);
        change(a,b);
        System.out.println(a);
        System.out.println(b);
        a = a+b;
        b = b+a;
        System.out.println(a);
        System.out.println(b);
        System.out.println("=======================");
        int[] arr04 = {1,3,5};
        System.out.println(arr04[0]);
        change(arr04);
        //已经变了
        System.out.println(arr04[0]);

    }

    //数组作为参数 传递的参数是数组的内存地址
    public static void test01(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.print(i1+" ");
        }
    }

    // 数组作为返回值  返回的是数据地址

    public static int[] test02(){
        int[] arr  = {2,3,4,7,8};
        return arr;
    }


    public static void change(int a, int b){
        a = a+b;
        b= b+a;
    }
    public static void change(int[] arr) {
        arr[0] = 200;
    }

}
