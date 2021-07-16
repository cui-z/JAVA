package Day03;

/*

swatch case 语句   通过和case进行比较一旦有对应的值  就会执行该语句
    遇到break跳出   如果一直没有匹配，会执行default语句
 */
public class Switch_ {

    public static void main(String[] args) {

        int week  =4;
        switch (week){
            case 6:
                System.out.println("xing qi 6");
                break;
            case 5:
                System.out.println("xing qi 5");
                break;
            default:
                System.out.println("other ");
                break;
        }

        //  switch 中，如果case之后没有写break，就会出现穿透现象，不会
        //判断下一个case的值，一直匹配，知道break
        int week1  =6;
        switch (week1){
            case 6:
                System.out.println("xing qi 6");
            case 5:
                System.out.println("xing qi 5");
                break;
            default:
                System.out.println("other ");
                break;
        }



    }
}
