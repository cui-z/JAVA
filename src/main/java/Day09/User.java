package Day09;

public class User {
    public void setUsername(String username) {
        this.username = username;
    }

    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }

    public String getUsername() {
        return username;
    }

    public double getLeftMoney() {
        return leftMoney;
    }

    private String username;
    private double leftMoney;
    public User(){}
    public User(String username,double leftMoney){
        this.username = username;
        this.leftMoney = leftMoney;
    }

    public void show(){
        System.out.println("用户名："+this.username+",余额为："+this.leftMoney);
    }
}
