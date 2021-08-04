package Day10;

/*
面向对象三大特性 继承 封装 多态
生活中，比如跑的动作，小猫、小狗和大象，跑起来是不一样的。再比如飞的动作，昆虫、
    鸟类和飞机，飞起来也 是不一样的。可见，同一行为，通过不同的事物，
    可以体现出来的不同的形态。多态，描述的就是这样的状态。

多态是指同一种行为具有多个不同的表现形式

前提：
     继承或者实现【二选一】
     方法的重写【意义体现：补充协议，无意义】
     父类引用指向子类对象【体现】

格式
    父类类型 变量名 =  new 子类对象；
    变量名.方法名（）
 */

public class duotai {
    public static void main(String[] args) {
        Animal a1  = new Cat();
        a1.eat();
        Animal a2 = new Dog();
        a2.eat();

        //优点：实际开发中，父类作为方法形式参数，传递子类对象给方法，进行方法调用，
         //更能体现出多态的扩展性与便利。
        Cat1 c1 = new Cat1();
        Dog1 d1 = new Dog1();
        showAnimal(c1);
        showAnimal(d1);
        //由于多态的特性，showAnimal 方法的参数是animal类型，可以接收子类型cat dog时，、
          //传递给方法
       //当eat 执行时，多态执行的是子类重写的方法，由此多态的好处就是使编程简单，有扩展性




        //引用数据类型转换
        /*
        向上转型：
             多态本身就是子类向父类转换的过程，这个过程是默认的
             父类类型 变量名 = new 子类类型（）
         向下转型：
              父类类型向子类类型向下转换的过程，是强制的
              一个已经向上转型的子类对象，将父类引用转为子类引用，可以使用强制类型转换的格式，便是向下转型。
              子类类型 变量名 = （子类类型）父类变量名;

         为什么要转型
             当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，
             则编译错误。也就是说，不能调用子类拥 有，而父类没有的方法。编译都错误，
             更别说运行了。这也是多态给我们带来的一点"小麻烦"。所以，
             想要调用子 类特有的方法，必须做向下转型。

         */
        Animal1 a3 = new Cat1();
        a3.eat();
        //a3.catchMouse(); 这种是错误的 所以需要向下转型
        Cat1 c3 = (Cat1) a3;
        c3.catchMouse();
        ((Cat1) a3).catchMouse();
        System.out.println("=======================");

        //Dog1 d3 = (Dog1) a3;
        //d3.WatchHouse();  //这样编译可以通过 但是运行会报错 因为dog cat 之间没有任何关系
        //可以使用 instanceof来判断数据类型
        if (a3 instanceof Cat1){
            ((Cat1) a3).catchMouse();
        } else if (a3 instanceof Dog1){
            Dog1 d4 = (Dog1) a3;
            d4.WatchHouse();
        }





    }

    public static void showAnimal(Animal1 an){
        an.eat();
    }
}
