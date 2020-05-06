package 覃超数据结构和算法;

import java.util.List;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class a1_SwapPairsInLinkedList {
    public static void main(String[] args) {
        ListNode L = new ListNode(1);
        L.next = new ListNode(2);
        L.next.next = new ListNode(3);
        L.next.next.next = new ListNode(4);
//        L.next.next.next.next = new ListNode(5);
//        System.out.println(L);
        System.out.println(swapPairs(L));
    }


    /**
     * 迭代的方式
     * 1. firstNode（即 A） 和 secondNode（即 B） 分别遍历偶数节点和奇数节点，即两步看作一步。
     * 2.交换两个节点：
     *   firstNode.next = secondNode.next
     *   secondNode.next = firstNode
     * 3.还需要更新 prevNode.next 指向交换后的头。
     *   prevNode.next = secondNode
     * 4.迭代完成后得到最终的交换结果。
     复杂度分析

     时间复杂度：O(N)，其中 NN 指的是链表的节点数量。
     空间复杂度：O(1)。
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
       //创建一个新节点，充当第一个节点的前一个节点，类似0号节点
        ListNode zeroNode= new ListNode(-1); //这里的-1没有任何意义，可以是任何值
        zeroNode.next = head;

       //每一次交换都涉及到三个变量， 前一个node，当前交换的第一个node，当前交换的第二个node
        ListNode prevNode = zeroNode; //第一次初始化 前一个node


        while ( (head != null) && (head.next != null)) { // 只要head 有至少2个节点，就可以开始交换
            //初始化 当前交换的第一个node，当前交换的第二个node
            ListNode firstNode = head;
            ListNode secNode = head.next;

            //开始交换
            prevNode.next = secNode;
            firstNode.next=secNode.next;
            secNode.next=firstNode;

            //重新跳到下面 三个节点（前一个node，当前交换的第一个node，当前交换的第二个node）
            prevNode = firstNode; // 重置 “前一个node”
            head = firstNode.next;// 重置 head 以后, 就能重置“当前交换的第一个node，当前交换的第二个node”， 从而while进入下一个循环
        }

        return zeroNode.next;
    }

}
