package Day04;

/*
格式：
修饰符 返回值类型 方法名（参数）{
    方法体
    return  结果；
}

修饰符  public static 固定写法目前
return  将结果返回给调用者  遇到return  结束


要有两个明确  返回值的类型  和  参数的列表


 */
public class Methon_ {

    public static void main(String[] args) {
        System.out.println(getsum(3,6));
        System.out.println(solve());

    }

    //两数之和

    public static int getsum(int a, int b){
        return a+b;
    }

    // 1-100求和
     public static int solve(){
        int sum_all = 0;

        for (int i = 0 ; i <=100; i++){
            sum_all += i;
            i++;
         }
         return sum_all;
     }
}
