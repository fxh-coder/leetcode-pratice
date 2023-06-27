public class LC_mergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 力扣合并k个有序链表
     * @param lists k个有序链表
     * @return合并后的有序链表的头指针
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = null;
        for (int i = 0; i < lists.length; i++) {
            dummyNode = mergeTwoLists(dummyNode, lists[i]);
        }

        return dummyNode;
    }

    /**
     * 力扣合并两个有序链表
     * @param a 有序链表
     * @param b 有序链表
     * @return 合并后的有序链表的头指针
     */
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a == null || b == null)
            return a != null ? a : b;

        ListNode head = new ListNode(0);
        ListNode cur = head, aPtr = a, bPtr = b;
        while(aPtr != null && bPtr != null) {
            if(aPtr.val < bPtr.val) {
                cur.next = aPtr;
                aPtr = aPtr.next;
            } else {
                cur.next = bPtr;
                bPtr = bPtr.next;
            }
            cur = cur.next;
        }
        cur.next = aPtr != null ? aPtr : bPtr;

        return head.next;
    }
}
