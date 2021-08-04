package Day11;

/*
interface作为成员变量
 */
public class Interface_ {

    public static void main(String[] args) {
        Role r = new Role();
        r.setFs(new FashuSkil(){
            public void fashuattack(){
                System.out.println("纵横天下");
            }
        });

        r.fashu();

        r.setFs(new FashuSkil() {
            @Override
            public void fashuattack() {
                System.out.println("扭转乾坤");
            }
        });
        r.fashu();


        //我们使用接口 作为成员变量 可以随时更换技能，这样设计灵活
          //增加了程序的扩展性
        // 接口作为成员变量时，对他进行赋值操作，实际是赋给他该接口的一个子类对象。
    }
}
