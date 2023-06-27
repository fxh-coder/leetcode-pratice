package stage6_10;

public class LC_removeDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 力扣删除排序链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode fastNode = new ListNode(0, head);
        if(fastNode.next != null) {
            fastNode = fastNode.next.next;
        } else {
            return dummyNode.next;
        }
        ListNode cur = dummyNode.next;

        while(fastNode != null) {

            if(cur.val == fastNode.val) {
                fastNode = fastNode.next;
            } else {
                cur.next = fastNode;
                cur = fastNode;
                fastNode = fastNode.next;
            }
        }
        cur.next = fastNode;
        return dummyNode.next;
    }
}
