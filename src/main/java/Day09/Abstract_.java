package Day09;
/*
抽象类：父类中的方法，被它的子类们重写，子类各自的实现都不尽相同。
      那么父类的方法声明和方法主体，只有声明还有 意义，
      而方法主体则没有存在的意义了。我们把没有方法主体的方法称为抽象方法。
      Java语法规定，包含抽象方法 的类就是抽象类。
定义：
    抽象方法：没有方法体的方法。
    抽象类：包含抽象方法的类。

格式：
    抽象方法： 修饰符 abstract 返回值类型 方法名（参数列表）；
    抽象类： 里面有抽象方法就是抽象类
        abstract class 类名{}

抽象的使用：
    继承抽象类的子类必须要重写 父类所有的抽象方法。否则，该子类也必须
    声明为抽象类。最终必须有子类实现该父类的抽象方法，否则从最初父类到
    最终的子类都不能创建对象，失去意义。

 */


abstract class Animal01{
    public abstract void run();
}
class cat extends Animal01{
    public void run(){
        System.out.println("cat un ----");
    }
    //此时的方法重写，是子类对父类抽象方法的完成实现，叫重写也叫实现方法。

}
public class Abstract_ {
    public static void main(String[] args) {
        cat ca = new cat();
        ca.run();

    }
}

/*
注意事项：
关于抽象类的使用，以下为语法上要注意的细节，虽然条目较多，但若理解了抽象的本质，无需死记硬背。
1. 抽象类不能创建对象，如果创建，编译无法通过而报错。只能创建其非抽象子类的对象。
    理解：假设创建了抽象类的对象，调用抽象的方法，而抽象方法没有具体的方法体，没有意义。
2. 抽象类中，可以有构造方法，是供子类创建对象时，初始化父类成员使用的。
    理解：子类的构造方法中，有默认的super()，需要访问父类构造方法。
3. 抽象类中，不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
    理解：未包含抽象方法的抽象类，目的就是不想让调用者创建该类对象，通常用于某些特殊的类结构设 计。
 4. 抽象类的子类，必须重写抽象父类中所有的抽象方法，否则，编译无法通过而报错。除非该子类也是抽象 类。
      理解：假设不重写所有抽象方法，则类中可能包含抽象方法。那么创建对象后，调用抽象的方法，没有 意义。
 */