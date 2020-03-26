//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

package leetcode.editor.cn;
public class ReverseLinkedList{
    public static void main(String[] args){
        Solution solution = new ReverseLinkedList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        //1.迭代
//        ListNode dummyHead = new ListNode(0),p =head, q = head;
//        dummyHead.next = p;
//        q = q.next;
//        while(q != null){
//            p.next = q.next;
//            ListNode cur = q;
//            q = q.next;
//            cur.next = dummyHead.next;
//            dummyHead.next = cur;
//        }
//        return dummyHead.next;
        //2.递归
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next =null;
        return p;
        
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
