package Day11;

public class Role {
    String name;
    int id;
    int blood;

    public void setFs(FashuSkil fs) {
        this.fs = fs;
    }

    FashuSkil fs;

    public Weapon getWp() {
        return wp;
    }

    public Armour getAm() {
        return am;
    }

    public void setWp(Weapon wp) {
        this.wp = wp;
    }

    public void setAm(Armour am) {
        this.am = am;
    }

    Weapon wp;
    Armour am;

    //攻击方法
    public void attack(){
        System.out.println("使用"+wp.name+",造成了"+wp.hurt+"伤害");
    }

    //防御方法

    public void wear(){
        this.blood += am.protect;
        System.out.println("穿上"+am.name+",生命增加"+am.protect+",增加到"+blood);
    }


    //法术攻击
    public  void fashu(){
        System.out.println("发动法术攻击");
        fs.fashuattack();
        System.out.println("法术攻击结束");

    }

}
