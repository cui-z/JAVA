package Day12;

import Day10.E;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


//使用时  注意将异常抛出
public class Date_ {
    public static void main(String[] args) throws Exception {
        /*
Date拥有多个构造函数，只是部分已经过时，但是其中有未过时的构造函数可以把毫秒值转成日期对象。

- `public Date()`：分配Date对象并初始化此对象，以表示分配它的时间（精确到毫秒）。
- `public Date(long date)`：分配Date对象并初始化此对象，以表示自从标准基准时间（称为“历元（epoch）”，即1970年1月1日00:00:00 GMT）以来的指定毫秒数。

> tips: 由于我们处于东八区，所以我们的基准时间为1970年1月1日8时0分0秒。

简单来说：使用无参构造，可以自动设置当前系统时间的毫秒时刻；指定long类型的构造参数，可以自定义毫秒时刻。例如：

    }
}


`public long getTime()` 把日期对象转换成对应的时间毫秒值。
```
         */
        System.out.println(new Date());
        System.out.println(new Date(0L));
        System.out.println(new Date().getTime());

        /*
DateFormat类
* **格式化**：按照指定的格式，从Date对象转换为String对象。
* **解析**：按照指定的格式，从String对象转换为Date对象。

由于DateFormat为抽象类，不能直接使用，所以需要常用的子类`java.text.SimpleDateFormat`。这个类需要一个模式（格式）来指定格式化或解析的标准。构造方法为：

* `public SimpleDateFormat(String pattern)`：用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。

参数pattern是一个字符串，代表日期时间的自定义格式。

### 格式规则

常用的格式规则为：

| 标识字母（区分大小写） | 含义 |
| ---------------------- | ---- |
| y                      | 年   |
| M                      | 月   |
| d                      | 日   |
| H                      | 时   |
| m                      | 分   |
| s                      | 秒   |

> 备注：更详细的格式规则，可以参考SimpleDateFormat类的API文档0。
         */

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm;ss");

        //- `public String format(Date date)`：将Date对象格式化为字符串。
        //- `public Date parse(String source)`：将字符串解析为Date对象。

        Date d = new Date();
        System.out.println(df.format(d));
        String ds = "2021-07-21  11:54;21";
        System.out.println(df.parse(ds));



        /*
        请使用日期时间相关的API，计算出一个人已经出生了多少天。


**思路：*

1.获取当前时间对应的毫秒值

2.获取自己出生日期对应的毫秒值

3.两个时间相减（当前时间– 出生日期）
         */
        get_day();


    }
    public static void get_day() throws Exception{
        System.out.println("请输入出生日期 格式 YYYY-MM-dd");
        // 获取出生日期,键盘输入
        String birthdayString = new Scanner(System.in).next();
        // 将字符串日期,转成Date对象
        // 创建SimpleDateFormat对象,写日期模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 调用方法parse,字符串转成日期对象
        Date birthdayDate = sdf.parse(birthdayString);
        // 获取今天的日期对象
        Date todayDate = new Date();
        // 将两个日期转成毫秒值,Date类的方法getTime
        long birthdaySecond = birthdayDate.getTime();
        long todaySecond = todayDate.getTime();
        long secone = todaySecond-birthdaySecond;
        if (secone < 0){
            System.out.println("还没出生呢");
        } else {
            System.out.println(secone/1000/60/60/24);
        }
    }
}
