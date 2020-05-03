package 覃超数据结构和算法;

public class ListNode {
    int val; //当前节点的数据
    ListNode next; // 下一个节点对象

    //构造方法
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + " ");
            head = head.next;
        }
        return sb.toString();
    }
}
