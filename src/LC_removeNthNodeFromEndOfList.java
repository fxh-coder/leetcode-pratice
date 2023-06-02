public class LC_removeNthNodeFromEndOfList {
    /**
     * 链表节点定义类
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 力扣删除链表的倒数第N个结点
     * @param head 头节点
     * @param n 给定的删除位置
     * @return 删除后的头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n)  {
        ListNode dummyNode = new ListNode(0, head);
        ListNode fastNode = new ListNode(0, head);
        ListNode cur = dummyNode;

        for (int i = 0; i <= n; i++) {
            fastNode = fastNode.next;
        }

        while(fastNode != null) {
            cur = cur.next;
            fastNode = fastNode.next;
        }

        cur.next = cur.next.next;
        return dummyNode;
    }
}
