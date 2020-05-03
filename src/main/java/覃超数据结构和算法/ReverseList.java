package 覃超数据结构和算法;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode L = new ListNode(1);
        L.next = new ListNode(2);
        L.next.next = new ListNode(3);
        System.out.println(L);
        System.out.println(reverseList(L));
    }

    /**
     * 第一种：用迭代的方式
     * 思路：1.输入: 1->2->3->4->5->NULL
     *      2. 先把 null<-1
     *      3. 然后 1<-2
     *      4.以此类推：前一个节点->当前节点 改成 前一个节点<-当前节点
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        //如果当前节点的下一个节点有，一直进行反转指针的操作
        while(curr != null){
            ListNode temp = curr.next; //转化前面二个节点之前，先记录一下后面节点的信息，因为转化以后就会丢失
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    /**
     * 递归的方式：
     * 假设有5个元素。
     *reverseList: head=1
     *     reverseList: head=2
     * 	    reverseList: head=3
     * 		    reverseList:head=4
     * 			    reverseList:head=5
     * 					终止返回
     * 				cur = 5
     * 				4.next.next->4，即5->4
     * 			cur=5
     * 			3.next.next->3，即4->3
     * 		cur = 5
     * 		2.next.next->2，即3->2
     * 	cur = 5
     * 	1.next.next->1，即2->1
     * @param head
     * @return
     */
    public static ListNode recursiveReverseList(ListNode head){
        if(head ==null ||  head.next==null) return head;
        ListNode l = recursiveReverseList(head);
        l.next.next = l;
        l.next=null;
        return l;
    }
}



