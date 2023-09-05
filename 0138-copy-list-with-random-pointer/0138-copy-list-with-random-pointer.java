class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Map<Node, Node> map = new HashMap<>();
        while(temp!=null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        boolean isAns = false;
        Node node = null, ans = null;
        while(temp != null) {
            if(node == null)
                isAns = true;
            node = map.get(temp);
            node.next = map.get(temp.next);
            node.random = map.get(temp.random);
            if (isAns) {
                ans = node;
                isAns = false;
            }
            temp = temp.next;
            node = node.next;
        }
        return ans;
    }
}