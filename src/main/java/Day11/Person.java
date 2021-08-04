package Day11;

public class Person {
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    private boolean alive = true;

    class Heart {
        public void jump(){
            if( alive){
                System.out.println("心脏在跳动");
            }else {
                System.out.println("心脏不跳了");
            }
        }
    }

}
