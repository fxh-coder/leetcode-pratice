public class LC_palindromeLinkedList {
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
     * 力扣回文链表
     * @param head
     * @return
     */
    public boolean isPalidrome(ListNode head) {
        if(head == null)
            return true;

        // 找到前半部分的尾节点并反转后半部分节点
        // 找到前半部分的尾节点（也就是中间节点）
        ListNode firstHalfEnd = endOfFirstHalf(head);
        // 反转后半部分链表
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean flag = true;
        while(flag && p2 != null) {
            if(p1.val != p2.val)
                flag = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return flag;
    }

    // 反转链表（在这个方法里，prev最后是在最后一个节点上的，不过因为反转了，所以也就是第一个节点）
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // 使用快慢指针找到链表的中间节点
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
