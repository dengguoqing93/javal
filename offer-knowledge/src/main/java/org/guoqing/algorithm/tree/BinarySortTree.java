package org.guoqing.algorithm.tree;

import java.util.Objects;

/**
 * 二叉排序树的实现
 *
 * @author dengguoqing
 * @date 2020/3/16
 * @copyright spiral
 * @since 1.0 Version
 */
public class BinarySortTree {

    private Node root;

    public BinarySortTree(Node root) {
        this.root = root;
    }

    /**
     * 向二叉树排序树插入节点，插入节点的值为key
     *
     * @param key 节点值
     * @return void
     * @author dengguoqing
     * @date 2020/3/16
     * @since 1.0
     */
    public void insertBST(int key) {
        Node p = root;
        Node pre = null;

        while (p != null) {
            pre = p;
            if (key < p.getValue()) {
                p = p.getLeft();
            } else if (key > p.getValue()) {
                p = p.getRight();
            } else {
                return;
            }

            /*
            pre是带插入节点的父节点，根据节点值得大小，被插入相应的位置
             */
            if (null == root) {
                root = new Node(key);
            } else if (key < pre.getValue()) {
                pre.setLeft(new Node(key));
            } else {
                pre.setRight(new Node(key));
            }

        }
    }

    /**
     * 删除二叉排序树中的节点
     * 分为三种情况:(删除节点为*P.其父节点为*f)
     * 1)要删除*p节点是叶子节点，只需要更改它的双亲节点的指针为空
     * 2）若*p只有左子树或只有右子树，则直接让左子树或右子树代替*p
     * 3）若*P既有左子树又有右子树，则用P左子树中最大的值代替P,删除S,重接其左子树
     *
     * @param key 删除的节点的值
     * @return void
     * @author dengguoqing
     * @date 2020/3/16
     * @since 1.0
     */
    public boolean deleteBST(int key) {
        return deleteBST(root, key);
    }

    private boolean deleteBST(Node node, int key) {
        if (Objects.isNull(node)) {
            return false;
        } else {
            if (key == node.getValue()) {
                return delete(node);
            } else if (key < node.getValue()) {
                return deleteBST(node.getLeft(), key);
            } else {
                return deleteBST(node.getRight(), key);
            }
        }
    }

    private boolean delete(Node node) {
        Node temp = null;
        /*
        右子树为空，只需要重接它的左子树，若果是叶子节点，则在这里也把叶子节点删除了
         */
        if (Objects.isNull(node.getRight())) {
            temp = node;
            node = node.getLeft();
        } else if (Objects.isNull(node.getLeft())) {
            /*
            左子树为空，重接它的右子树
             */
            temp = node;
            node = node.getRight();
        } else {
            //左右子树均不为空
            temp = node;
            Node s = node;
            s = s.getLeft();
            while (Objects.nonNull(s.getRight())) {
                temp = s;
                s = s.getRight();
            }
            node.setValue(s.getValue());
            if (temp != node) {
                temp.setRight(s.getLeft());
            } else {
                temp.setLeft(s.getLeft());
            }


        }
        return true;
    }

    /**
     * 在二叉排序树中查找是否有key值
     *
     * @param key 查找的值
     * @return boolean
     * @author dengguoqing
     * @date 2020/3/16
     * @since 1.0
     */
    public boolean searchBST(int key) {
        Node current = root;
        while (Objects.nonNull(current)) {
            if (key == current.getValue()) {
                return true;
            } else if (key < current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }
}
