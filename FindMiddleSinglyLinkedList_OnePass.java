class ListNode {
    int data;
    ListNode next;
    ListNOde(int data) {
        this.data = data;
    }
}


public ListNode findMiddleNode(ListNode head) {
    if (head == null) { //stopping case if the head is null
        return null;
    }
    // Initialize two pointers with one moving faster than the other along the list
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null && (fast.next).next != null) {
        slow = slow.next;
        fast = (fast.next).next; // moves twice as fast, therefore finds the middle when traversing. 
    }
}



// Examples:
// 1 ==> 1
// 1->2 ==> 1
// 1->2->3->4 ==> 2
// 1->2->3->4->5 ==> 3