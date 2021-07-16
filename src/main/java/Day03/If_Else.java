package Day03;

public class If_Else {

    public static void main(String[] args) {
         int a  = 5;
         if (a %2 == 1){
             System.out.println("奇数");
         }else {
             System.out.println("偶数");
         }

        System.out.println("-------------------------------------");


         int b = 3;
         int y;
         if (b >= 3){
             y = b*2 +1;
         } else if (b >= -1 ){
             y = b+3;
         } else {
             y = b;
         }
        System.out.println(y);

        System.out.println("===================================");

        //  if else  可以和三元运算符进行相互转换
        int aa = 5;
        int bb = 8;
        int resu;
        if (aa > bb){
            resu = aa;
        }else{
            resu = bb;
        }

        System.out.println(resu);

        int result = aa > bb ? aa:bb;
        System.out.println(result);
    }
}
