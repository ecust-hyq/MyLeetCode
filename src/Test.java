/**
 * @author HYQ
 * @description
 * @creat 2021--11--17--22:13
 */
public class Test {
    public static void main(String[] args) {
        int a = 123;
        String s = String.valueOf(a);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        a = Integer.parseInt(s);
        System.out.println(a);
    }
}
