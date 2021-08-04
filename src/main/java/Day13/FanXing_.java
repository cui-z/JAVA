package Day13;
/*
在前面学习集合时，我们都知道集合中是可以存放任意对象的，只要把对象存储集合后，那么这时他们都会被提升成Object类型。当我们在取出每一个对象，并且进行相应的操作，这时必须采用类型转换。

大家观察下面代码：

~~~java
public class GenericDemo {
	public static void main(String[] args) {
		Collection coll = new ArrayList();
		coll.add("abc");
		coll.add("itcast");
		coll.add(5);//由于集合没有做任何限定，任何类型都可以给其中存放
		Iterator it = coll.iterator();
		while(it.hasNext()){
			//需要打印每个字符串的长度,就要把迭代出来的对象转成String类型
			String str = (String) it.next();
			System.out.println(str.length());
		}
	}
}
~~~
程序在运行时发生了问题**java.lang.ClassCastException**。
为什么会发生类型转换异常呢？
   我们来分析下：由于集合中什么类型的元素都可以存储。导致取出时强转引发运行
   时 ClassCastException。
怎么来解决这个问题呢？
    Collection虽然可以存储各种对象，但实际上通常Collection只存储同一类型对
    象。例如都是存储字符串对象。因此在JDK5之后，新增了**泛型**(**Generic**)
    语法，让你在设计API时可以指定类或方法支持泛型，这样我们使用API的时候也
    变得更为简洁，并得到了编译时期的语法检查。

泛型：可以在类或方法中预支地使用未知的类型。
  一般在创建对象时，将未知的类型确定具体的类型。当没有指定泛型时,
   默认类型为Object类型。

 */



import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FanXing_ {
    public static void main(String[] args) {
        //好处
        //将运行时期的ClassCastException，转移到了编译时期变成了编译失败。
        //避免了类型强转的麻烦。
        Collection<String> co = new ArrayList<String>();
        ((ArrayList<String>) co).add("asiodgjf");
        ((ArrayList<String>) co).add("kodf");
        //co.add(2223);  这时候编译就会出错
        Iterator it = co.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }



        /*
        定义和使用含有泛型的类
            格式：修饰符 class 类名<代表泛型的变量> {  }
         */
        MyClass<String> my = new MyClass<String>();
        my.setMvp("勒布朗");
        String mvp = my.getMvp();
        System.out.println(mvp);
        MyClass<Integer> my1 = new MyClass<Integer>();
        my1.setMvp(123);
        System.out.println(my1.getMvp());
        System.out.println("=======================");

        //含有泛型的方法
        //修饰符 <代表泛型的变量> 返回值类型 方法名(参数){  }
        get_test("sjge");


    }

    public static <MVP> void get_test(MVP mvp){
        System.out.println(mvp.getClass());
    }

    /*
    ## 泛型通配符

当使用泛型类或者接口时，传递的数据中，泛型类型不确定，可以通过通配符<?>表示。但是一旦使用泛型的通配符后，只能使用Object类中的共性方法，集合中元素自身方法无法使用。

#### 通配符基本使用

泛型的通配符:**不知道使用什么类型来接收的时候,此时可以使用?,?表示未知通配符。**

此时只能接受数据,不能往该集合中存储数据。

举个例子大家理解使用即可：

~~~java
public static void main(String[] args) {
    Collection<Intger> list1 = new ArrayList<Integer>();
    getElement(list1);
    Collection<String> list2 = new ArrayList<String>();
    getElement(list2);
}
public static void getElement(Collection<?> coll){}
//？代表可以接收任意类型
~~~

> tips:泛型不存在继承关系 Collection<Object> list = new ArrayList<String>();这种是错误的。

#### 通配符高级使用----受限泛型

之前设置泛型的时候，实际上是可以任意设置的，只要是类就可以设置。但是在JAVA的泛型中可以指定一个泛型的**上限**和**下限**。

**泛型的上限**：

* **格式**： `类型名称 <? extends 类 > 对象名称`
* **意义**： `只能接收该类型及其子类`

**泛型的下限**：

- **格式**： `类型名称 <? super 类 > 对象名称`
- **意义**： `只能接收该类型及其父类型`

比如：现已知Object类，String 类，Number类，Integer类，其中Number是Integer的父类

~~~java
public static void main(String[] args) {
    Collection<Integer> list1 = new ArrayList<Integer>();
    Collection<String> list2 = new ArrayList<String>();
    Collection<Number> list3 = new ArrayList<Number>();
    Collection<Object> list4 = new ArrayList<Object>();

    getElement(list1);
    getElement(list2);//报错
    getElement(list3);
    getElement(list4);//报错

    getElement2(list1);//报错
    getElement2(list2);//报错
    getElement2(list3);
    getElement2(list4);

}
// 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
public static void getElement1(Collection<? extends Number> coll){}
// 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
public static void getElement2(Collection<? super Number> coll){}
~~~
     */
}
