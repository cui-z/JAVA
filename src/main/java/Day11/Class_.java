package Day11;

/*
class 作为成员变量

类作为成员变量时，对他进行复制操作时，实际是赋给他该类的一个对象。
 */
public class Class_ {
    public static void main(String[] args) {
        Weapon w = new Weapon("刀",999);
        Armour ar  = new Armour("麒麟甲",100);

        Role r  = new Role();
        r.blood = 99;
        r.setAm(ar);
        r.setWp(w);
        r.attack();
        r.wear();

    }
}
