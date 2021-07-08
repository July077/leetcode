package common;

/**
 * @author sunjianrong
 * @date 2021-07-08 12:13
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int v) {
        this.val = v;
    }

    public Node(int v, Node left, Node right, Node next) {
        val = v;
        this.left = left;
        this.right = right;
        this.next = next;
    }

}
