package 覃超数据结构和算法;

import java.util.ArrayList;

/**
 *
 给定一个链表，判断链表中是否有环。

 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 示例 1：

 输入：head = [3,2,0,-4], pos = 1
 输出：true
 解释：链表中有一个环，其尾部连接到第二个节点。
 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class a2_Judge_Link_circle {
    public static void main(String[] args) {
        ListNode L = new ListNode(1);
        L.next = new ListNode(2);
        L.next.next = new ListNode(3);
        L.next.next.next = L;
//        L.next.next.next.next = new ListNode(5);
//        System.out.println(L);
        System.out.println(judge_Link_circle1(L));
    }

    public static int judge_Link_circle1(ListNode head) {
        if(head==null){return -1;}
        //用一个array存list索引
        ArrayList<ListNode> store = new ArrayList<ListNode>();
        store.add(head);
        //每循环一次则拿着next对应的ListNode 去store查一下看有没有
        ListNode nextNode = head.next;
        boolean contains = store.contains(nextNode);
        while((!contains)&& (nextNode.next != null)){
            store.add(nextNode);
            nextNode = nextNode.next;
        }

        if(contains){
            return store.indexOf(nextNode);
        }else{
            return -1;
        }


    }


}
