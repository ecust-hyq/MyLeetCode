

/**
 * @author HYQ
 * @description 27.移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @creat 2021--11--21--21:04
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int len = removeElement(nums, val);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + "  ");
        }
    }

    /**
     *不难，但是个人解法在内存占用上有所不足
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.1 MB, 在所有 Java 提交中击败了19.15%的用户
     *
     * 官方解法给出两种双指针法：
     * 第一种此方法类似，但是与此方法不同的是并非着眼于替换掉val值元素，而是寻找不同与val的元素陆续添加
     * 至当前数组，该方法更加简洁，但是存在非val元素重复赋值的问题，此方法虽也存在重复赋值，但是重复赋值的是“同val元素”
     *
     * 第二种方法是将第二个指针放至数组的尾部，避免了数组的重复赋值，值得后期尝试
     */
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[index] != val){
                index++;
            }else if(nums[i] != val){
                nums[index] = nums[i];
                nums[i] = val; //要点，解决替换val的元素重复问题
                index++;
            }
        }
        return index;
    }
}
