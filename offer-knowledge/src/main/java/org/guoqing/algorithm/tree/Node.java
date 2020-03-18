package org.guoqing.algorithm.tree;

/**
 * 二叉排序树的数据结构
 *
 * @author dengguoqing
 * @date 2020/3/16
 * @copyright spiral
 * @since 1.0 Version
 */
public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
