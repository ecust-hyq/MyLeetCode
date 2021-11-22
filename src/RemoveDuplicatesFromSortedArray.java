/**
 * @author HYQ
 * @description
 * 26. 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @creat 2021--11--21--20:30
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + "  ");
        }
    }

    /**
     * 简单题，快速完成
     * 执行用时: 1 ms， 在所有 Java 提交中击败了95%的用户
     *内存消耗: 39.3 MB， 在所有 Java 提交中击败了96%的用户
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[index]){
                index++;
                nums[index] = nums[i];
            }
        }
        return index == 0? 0:index+1;
    }
}
