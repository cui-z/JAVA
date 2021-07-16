package Day03;

/*
 for 循环语句

 for(初始表达式；布尔表达式；步进表达式){
   循环体
 }

 执行顺序  先初始 布尔 循环体 步进 -> 布尔 循环 步进 -》 。。。。。
 */

public class For_ {
    public static void main(String[] args) {
        for (int i =0 ;i < 3 ;i++){
            System.out.println("hello world");
        }

        int sum_all  = 0;
        for (int s = 0 ;s <= 10 ;s++){
            if (s %2 ==0){
                sum_all += s;
            }
        }
        System.out.println(sum_all);
    }
}
