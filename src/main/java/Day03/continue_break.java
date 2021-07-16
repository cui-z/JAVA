package Day03;

/*
break  直接跳出终止循环
continue  跳出当前本次循环 继续下一次循环

 */
public class continue_break {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i ==3){
                break;
            }
            System.out.println("hello "+i);
        }

        for (int i = 0; i < 5; i++) {
            if (i ==3){
                continue;
            }
            System.out.println("hello "+i);
        }


    }
}
