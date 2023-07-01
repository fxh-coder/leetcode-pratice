/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let dummyNode = new ListNode(0, head);
    let fastNode = new ListNode(0, head);
    let cur = dummyNode;
    for (let i = 0; i <= n; i++) {
        fastNode = fastNode.next; 
    }
    while(fastNode != null) {
        cur = cur.next;
        fastNode = fastNode.next;
    }
    
    cur.next = cur.next.next;
    
    return dummyNode.next;
};