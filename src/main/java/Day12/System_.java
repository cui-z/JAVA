package Day12;
/*
.System`类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，在System类的API文档中，常用的方法有：

- `public static long currentTimeMillis()`：返回以毫秒为单位的当前时间。
- `public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`：将数组中指定的数据拷贝到另一个数组中。
 */

public class System_ {
    public static void main(String[] args) {
       //currentTimeMillis方法就是 获取当前系统时间与1970年01月01日00:00点之间的毫秒差值
        System.out.println(System.currentTimeMillis());

        //验证for循环打印数字1-9999所需要使用的时间（毫秒）
        get_time();

        /*
        * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`：将数组中指定的数据拷贝到另一个数组中。

数组的拷贝动作是系统级的，性能很高。System.arraycopy方法具有5个参数，含义分别为：

| 参数序号 | 参数名称 | 参数类型 | 参数含义             |
| -------- | -------- | -------- | -------------------- |
| 1        | src      | Object   | 源数组               |
| 2        | srcPos   | int      | 源数组索引起始位置   |
| 3        | dest     | Object   | 目标数组             |
| 4        | destPos  | int      | 目标数组索引起始位置 |
| 5        | length   | int      | 复制元素个数         |
         */

        int[] src = new int[]{1,2,3,4,5,6};
        int[] dest = {4,5,6,7,8};
        System.arraycopy(src,2,dest,3,2);
        for (int i = 0; i < dest.length; i++) {
            int i1 = dest[i];
            System.out.println(i1);
        }
        System.out.println("----------------");
        for (int i = 0; i < src.length; i++) {
            int i1 = src[i];
            System.out.println(i1);

        }


    }

    public static void get_time(){
        long start = System.currentTimeMillis();
        for(int i = 0;i <9999;i++){
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start));
    }


}
