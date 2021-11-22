/**
 * @author HYQ
 * @description
 * @creat 2021--11--21--23:25
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        String haystack = "", needle = "";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 暴力解法，正解需要用到KMP算法，须进一步学习
     * 执行用时：2123 ms, 在所有 Java 提交中击败了5.02%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了43.85%的用户
     */
    public static int strStr(String haystack, String needle) {
        boolean isHas = false;
        int index = -1;
        if(needle.equals("")){
            return 0;
        }else if(haystack.contains(needle)){
            for (int i = 0; i < haystack.length(); i++) {
                if(haystack.charAt(i) == needle.charAt(0)){
                    isHas = true;
                    for (int j = 0; j < needle.length(); j++) {
                        if(haystack.charAt(i+j) != needle.charAt(j)){
                            isHas = false;
                            break;
                        }
                    }
                    if(isHas){
                        index = i;
                        break;
                    }
                }
            }
            return index;
        }
        else return index;

    }
}
