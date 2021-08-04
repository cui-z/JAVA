package Day11;

/*
什么是内部类
    将一个类A定义在另一个类B里面，里面的那个类A就称为内部类，B则称为外部类

 */

public class Inside_class {
    public static void main(String[] args) {
        /*
        成员内部类：定义在类中方法外的类。
        格式：
            class 外部类名{
               class 内部类{
                  }
              }
         在描述事物时，若一个事物内部还包含其他事物，就可以使用内部类这种结构。
            比如，汽车类 Car 中包含发动机 类 Engine ，这时，
             Engine 就可以使用内部类来描述，定义在成员位置。

          访问特点：
              内部类可以直接访问外部类的成员，包括私有
              外部类要访问内部类的成员，需要先建立内部类对象
              创建内部类对象格式：
                  外部类.内部类 对象名 = new 外部类型().new  内部类型（）;
         */
        Person p = new Person();
        Person.Heart h = p.new Heart();
        h.jump();

        p.setAlive(false);
        h.jump();
//内部类仍然是一个独立的类




        /*
        匿名内部类：
            是内部类的简化，他的本质是  一个带  具体实现的父 类或者父接口的 匿名的子类对象。
            当你使用接口时，需要的步骤如下：
                1 定义子类
                2 重写接口中的方法
                3 创建子类对象
                4 调用重写的方法
            现在把这几步合而为一


            格式：
            new 父类或者接口名（）{
               方法重写
             }；
         */

        FlyAble f = new FlyAble() {
            @Override
            public void fly() {
                System.out.println("i can fly ....");
            }
        };
        f.fly();


        //通常在方法的形参是接口或者抽象类时 可以将匿名内部类作为参数传递
        showfly(f);

        //简洁版
        showfly(new FlyAble() {
            @Override
            public void fly() {
                System.out.println("osijdfiojqg");
            }
        });

    }


    public static void showfly(FlyAble f){
        f.fly();
    }
}
