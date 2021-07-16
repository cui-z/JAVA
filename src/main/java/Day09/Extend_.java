package Day09;

/*
继承 多个类存在相同的属性和行为，可以将这些共性抽取到一个单独的类中，那么多个类不用定义，只需要
    继承那一个类即可。
    继承几十子类继承父类的属性和行为，使得子类具有与父类相同的属性和行为
        子类可以直接访问父类中的非私有的属性和行为。

 */

class Employee{
    String name;
    public void work(){
        System.out.println(" 尽心尽力工作");
    }
}
class Teacher extends Employee{
    public void printName() {
        System.out.println("name is "+name);
    }
}




class fu{
    int num = 6;

    public void show() {
        System.out.println("fu fu num is " + this.num);
    }
}
class zi extends fu{
    int num = 9;
    public void shoe(){
        System.out.println("fu num is "+super.num);
        System.out.println("zi num is "+ this.num);
    }
}



class phone{
    public void sedmessage(){
        System.out.println("发短信");
    }
    public void call(){
        System.out.println("打电话");
    }
    public void shownum(){
        System.out.println("显示来电号码");
    }
}
class xiaomi extends phone{
    public void shownum(){
        //如果要调用父类存在的功能使用super
        super.shownum();
        //增加自己的功能
        System.out.println("小米手机还可以显示头像");
    }
}





class fu1{
    private int num ;
    fu1(){
        System.out.println("fu 构造");
    }
}

class zi1 extends fu1{
    zi1(){
        System.out.println("zi gouzao ");
    }
}

class Animal{
    public void eat(){
        System.out.println("animal  eat ==");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("cat  eat ====");
    }

    public void eat_test(){
        super.eat(); //父类eat
        this.eat(); //本类 eat
    }
}


public class Extend_ {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.name = "zhansan ";
        t.work();
        t.printName();


        System.out.println("===================");
        //成员变量  如果子类中出现跟父类相同的名称 会出现问题
        //在子类中需要访问父类非私有成员变量时，需要使用super关键字


        //成员方法
        // 1 子类父类中不重名的，没有影响，调用时会先在子类中查找，若子类有就不再父类中查找
        // 2  重名，需要方法重写  子类跟父类的方法一模一样（方法名 参数 返回值），会覆盖


        zi z = new zi();
        z.shoe();
        z.show();

        // 子类可以根据需要，定义特定于自己的行为。既沿袭了父类功能名称，又根据自己子类的需要重新实现了
            //父类的方法，从而进行扩展增强。
        System.out.println("==================");
        xiaomi xm = new xiaomi();
        xm.shownum();


        // 构造方法
        /*
        当类之间产生了关系，其中各类中的构造方法，又产生了哪些影响呢？
            首先我们要回忆两个事情，构造方法的定义格式和作用。
                1. 构造方法的名字是与类名一致的。所以子类是无法继承父类构造方法的。
                 2. 构造方法的作用是初始化成员变量的。所以子类的初始化过程中，必须先执行父类的初始化动作。
                     子类的构 造方法中默认有一个 super() ，表示调用父类的构造方法，父类成员变量初始化后，才可以给子类使用。
         */

        zi1 z1 = new zi1(); //会限制性父类构造  然后子类构造

        /* super 和 this
        父类空间优先于子类对象产生
            在每次创建子类对象时，会优先初始化父类空间，再创建子类对象本身。
            目的在于子类对象中包含了其对应的父类空 间，便可以包含其父类的成员，如果父类成员非private修饰，
            则子类可以随意使用父类成员。代码体现在子类的构 造方法调用时，一定先调用父类的构造方法。

        super:代表父类的存储空间表示，即父类引用
        this ：代表当前对象引用

         */

        Animal an = new Animal();
        an.eat();
        System.out.println("----------------");
        Cat c = new Cat();
        c.eat_test();


        //JAVA只支撑单继承
        // java 多层继承


    }
}
