public class LC_swapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 力扣两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = dummyHead;
        while(temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
