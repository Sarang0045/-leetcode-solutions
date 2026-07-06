class Solution {

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    // Returns the tail of the flattened list starting from 'node'
    private Node dfs(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = dfs(childHead);

                // Connect current -> child
                curr.next = childHead;
                childHead.prev = curr;

                // Connect childTail -> original next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                curr.child = null;
                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}