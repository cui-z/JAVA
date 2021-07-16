package Day02;
// 方法入门
// 方法 ： 把一个功能抽取出来，将代码单独定义在一个大括号里面,形成一个单独的功能

/*
    格式
    修饰符 返回值类型 方法名 （参数列表）{
        代码
        return
        }

    修饰符 目前 public static
    返回值类型  void 没有返回值
 */


// 注意点： 方法必须定义在一类中方法外
    //  方法不能定义在另一个方法的里面
public class Method {

    public static void test_method() {
        System.out.println("  测试定义方法");
    }

    public static void main(String[] args) {
        test_method();

    }
}
