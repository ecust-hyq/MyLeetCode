import java.util.HashMap;

/**
 * @author HYQ
 * @description  14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * @creat 2021--11--18--22:22
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
        System.out.println('m' > 's');
    }
    public static int romanToInt(String s) {
        int len = s.length();
        int[] num = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)){
                case 'I':
                    num[i] = 1;
                    break;
                case 'V':
                    num[i] = 5;
                    break;
                case 'X':
                    num[i] = 10;
                    break;
                case 'L':
                    num[i] = 50;
                    break;
                case'C':
                    num[i] = 100;
                    break;
                case 'D':
                    num[i] = 500;
                    break;
                case'M':
                    num[i] = 1000;
                    break;
            }
        }
        for (int i = 0; i < len-1; i++) {
            if(num[i] < num[i+1]){
                sum -= num[i];
            }else {
                sum += num[i];
            }
        }
        return sum + num[len-1];
    }
    public static int romanToInt2(String s){
        int sum = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            if(hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i+1))){
                sum -= s.charAt(i);
            }else {
                sum += s.charAt(i);
            }
        }
        return sum+s.charAt(s.length()-1);
    }
}
