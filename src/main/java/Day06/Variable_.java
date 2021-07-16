package Day06;

public class Variable_ {
    String color ; // 成员变量
    // 在类中  方法外   有默认值

    public static  void tt(){
        int speed = 40; //局部变量
        // 在方法中或者方法声明（形参） 没有默认值，需要先定义
        System.out.println("时速"+speed);
    }

    public static void main(String[] args) {
        tt();
    }
}
