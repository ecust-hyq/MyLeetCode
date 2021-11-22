/**
 * @author HYQ
 * @description 21.将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 1.两个链表的节点数目范围是 [0, 50]
 * 2.-100 <= Node.val <= 100
 * 3.l1 和 l2 均按 非递减顺序 排列
 * @creat 2021--11--20--22:27
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = mergeTwoLists2(l1, l2);
        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    /**
     * 解法1：利用递归（评论区解法，此题未独立做出）
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.5 MB, 在所有 Java 提交中击败了91.89%的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next =mergeTwoLists(res.next, l1.val >= l2.val? l1:l2);
        return res;
    }

    /**
     * 解法2：逐个比较两个链表的较小元素，将较小元素加入合并后的链表(经题解提示写出)
     * 要点:定义一个空的头节点
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了64.40%的用户
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode h = head;
        ListNode h1 = l1;
        ListNode h2 = l2;
        while (h1 != null && h2 != null){
            if(h1.val <= h2.val){
                h.next = h1;
                h1 = h1.next;
                h = h.next;
            }else {
                h.next = h2;
                h2 = h2.next;
                h = h.next;
            }
        }
        if(h1 == null){
            h.next = h2;
        }else {
            h.next = h1;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



