import java.util.Stack;

/**
 * @author HYQ
 * @description
 * 20.有效的括号
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @creat 2021--11--20--10:45
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{[]}";
        String s2 = "{[}]";
        System.out.println(isValid2(s2));
    }

    /**
     * 解法1：利用栈,如果检测到左括号则push进右括号，如果未检测到左括号则pop()，并与当前的字符进行比较
     * 使用栈的一个重要原因就是其先进后出的属性，刚好达到一个检测对称的作用
     * 执行用时 1 ms, 在所有 Java 提交中击败了98.90%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了67.24%的用户
     */
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
    /**
     * 解法2：利用字符替换的方法，无嵌套的直接替换，有嵌套的从里到外替换
     * 执行用时：45 ms, 在所有 Java 提交中击败了5.37%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了5.03%的用户
     */
    public static boolean isValid2(String s){
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if(s.contains("()")){
                s = s.replace("()", "");
            }else if(s.contains("[]")) {
                s = s.replace("[]", "");
            }else if(s.contains("{}")){
                s = s.replace("{}", "");
            }
        }
        if(s.isEmpty()){
            return true;
        }else return false;
    }

    /**
     * 该方法与上一个方法相同，但写法相当简洁
     *执行用时：32 ms, 在所有 Java 提交中击败了5.37%的用户
     内存消耗：38.8 MB, 在所有 Java 提交中击败了5.03%的用户
     */
    public boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }
}
