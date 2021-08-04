package Day12;
/*
calendar 是日历类，在Date后出现，替换掉了许多Date的方法。
    该类将所有可能用到的时间信息封装为静态成员变量，方便获取。
    日历类就是方便获取各个时间属性的。

Calendar为抽象类，由于语言敏感性，Calendar类在创建对象时并非直接创建，
    而是通过静态方法创建，返回子类对象。

根据Calendar类的API文档，常用方法有：

- `public int get(int field)`：返回给定日历字段的值。
- `public void set(int field, int value)`：将给定的日历字段设置为给定值。
- `public abstract void add(int field, int amount)`：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
- `public Date getTime()`：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。

Calendar类中提供很多成员常量，代表给定的日历字段：

| 字段值       | 含义                                  |
| ------------ | ------------------------------------- |
| YEAR         | 年                                    |
| MONTH        | 月（从0开始，可以+1使用）             |
| DAY_OF_MONTH | 月中的天（几号）                      |
| HOUR         | 时（12小时制）                        |
| HOUR_OF_DAY  | 时（24小时制）                        |
| MINUTE       | 分                                    |
| SECOND       | 秒                                    |
| DAY_OF_WEEK  | 周中的天（周几，周日为1，可以-1使用） |

 */

import java.util.Calendar;
import java.util.Date;

public class Calendar_ {
    public static void main(String[] args) {
        //创建
        Calendar cl = Calendar.getInstance();
        int year  = cl.get(Calendar.YEAR);
        //月需要加1
        int Month = cl.get(Calendar.MONTH)+1;
        int day = cl.get(Calendar.DAY_OF_MONTH);
        System.out.println(year+" "+Month+" "+day);

        //set 方法
        cl.set(Calendar.YEAR,1989);
        int yearr  = cl.get(Calendar.YEAR);
        System.out.println(yearr+" "+Month+" "+day);

        //add 方法
        cl.add(Calendar.YEAR ,-4);
        int yearrr = cl.get(Calendar.YEAR);
        System.out.println(yearrr+" "+Month+" "+day);


        // getTime 方法  获取的是Date对象
        Date d  = cl.getTime();
        System.out.println(d);


    }

}
