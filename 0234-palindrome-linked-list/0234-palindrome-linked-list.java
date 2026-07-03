class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        // Step 1: Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode secondHalf = reverse(slow.next);

        // Step 3: Compare both halves
        ListNode firstHalf = head;
        ListNode temp = secondHalf;

        while (temp != null) {
            if (firstHalf.val != temp.val)
                return false;

            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}