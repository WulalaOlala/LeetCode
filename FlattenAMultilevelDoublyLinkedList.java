//您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构
//，如下面的示例所示。 
//
// 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。 
//
// 
//
// 示例: 
//
// 输入:
// 1---2---3---4---5---6--NULL
//         |
//         7---8---9---10--NULL
//             |
//             11--12--NULL
//
//输出:
//1-2-3-7-8-11-12-9-10-4-5-6-NULL
// 
//
// 
//
// 以上示例的说明: 
//
// 给出以下多级双向链表: 
//
// 
//
// 
//
// 我们应该返回如下所示的扁平双向链表: 
//
// 
// Related Topics 深度优先搜索 链表

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenAMultilevelDoublyLinkedList{
    public static void main(String[] args){
        Solution solution = new FlattenAMultilevelDoublyLinkedList().new Solution();
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node p1 = head;
        Deque<Node> stack = new ArrayDeque<Node>();
        while (p1 != null) {
            if (p1.child != null) {
                if(p1.next != null) stack.push(p1.next);
                p1.child.prev = p1;
                p1.next = p1.child;
                p1.child = null;
            }
            if (p1.next == null && !stack.isEmpty()) {
                Node p2 = stack.pop();
                p1.next = p2;
                p2.prev = p1;
            }
            p1 = p1.next;
        }
        head.prev = null;
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}