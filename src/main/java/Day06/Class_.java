package Day06;

/*
面向对象的语言中 三大基本特性  封装 继承  多态

什么是类
类：是一组相关属性和行为的集合。可以看成是一类事物的模板，
       使用事物的属性特征和行为特征来描述该类事物。
现实中，描述一类事物：
      属性：就是该事物的状态信息。
      行为：就是该事物能够做什么。
举例：小猫。 属性：名字、体重、年龄、颜色。 行为：走、跑、叫。



什么是对象
对象：是一类事物的具体体现。对象是类的一个实例（对象并不是找个女朋友），
    必然具备该类事物的属性和行为。
现实中，一类事物的一个实例：一只小猫。
举例：一只小猫。 属性：tom、5kg、2 years、yellow。 行为：溜墙根走、蹦跶的跑、喵喵叫。


类与对象的关系
  类是对一类事物的描述，是抽象的。
  对象是一类事物的实例，是具体的。
  类是对象的模板，对象是类的实体。



类的定义
    成员变量 对应事物的属性
    成员方法 对应事物的行为

    public class Classname {
        成员变量  在类中，方法外
        成员方法   跟前面定义方法一样 不过去电static
    }
 */


public class Class_ {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.age);
        System.out.println(s.name);

        //  复制
        s.age = 30;
        s.name = "水货";
        System.out.println(s.age);
        System.out.println(s.name);
        s.study();
        s.eat();


    }
}
