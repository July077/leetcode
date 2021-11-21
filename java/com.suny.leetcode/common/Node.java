package common;

import java.util.List;

/**
 * @author sunjianrong
 * @date 2021-07-08 12:13
 */
public class Node {
    public int val;
    public Node random;
    public Node left;
    public Node right;
    public Node next;



    public Node prev;
    public Node child;
    public List<Node> children;

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


    public Node(int v, List<Node> children) {
        val = v;
        children = children;
    }




}
