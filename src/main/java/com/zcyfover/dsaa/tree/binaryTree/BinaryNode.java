package com.zcyfover.dsaa.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zcy-fover on 2016/10/4.
 * 树的学习，重点以二叉树的学习为主，此类为二叉树的节点实现
 */
public class BinaryNode<T extends Comparable<? super T>>{

    private T element;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(){
    }

    public BinaryNode(T element) {
        this(element, null, null);
    }

    public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public BinaryNode<T> insert(T x, BinaryNode<T> t){
        //说明该节点为根
        if (t == null){
            return new BinaryNode<T>(x, null, null);
        }

        int compareResult = x.compareTo(t.getElement());
        if (compareResult < 0){
            t.setLeft(insert(x, t.getLeft()));    //递归查找合适的插入位置
        } else if (compareResult > 0){
            t.setRight(insert(x, t.getRight()));
        }
        return t;
    }

    /**
     * 输出一颗二叉树，以中序遍历的方式输出
     */
    public void printTree(){
        if (this == null){
            System.out.println("Empty Tree");
        } else{
            printTree(this);
        }
    }
    public void printTree(BinaryNode t){
        if (t != null){
            printTree(t.getLeft());
            System.out.print(t.getElement() + "-");
            printTree(t.getRight());
        }
    }

    /**
     * 获取二叉树的深度，递归解法
     * @param root
     * @return
     */
    public int getDepthRec(BinaryNode root){
        if (root == null){
            return -1;
        } else if (root.getLeft() == null && root.getRight() == null){
            return 0;
        } else {
            int leftD = getDepthRec(root.getLeft());
            int rightD = getDepthRec(root.getRight());
            return Math.max(leftD, rightD) + 1;
        }
    }
    /**
     * 非递归求深度
     * @param root
     * @return
     */
    public int getDepth(BinaryNode root){
        if (root == null){
            return 0;
        }
        int depth = -1;                  //深度
        int currentLevelNodes = 1;      //当前层的节点个数
        int nextLevelNodes = 0;         //下一层的节点个数

        LinkedList<BinaryNode> link = new LinkedList<>();
        link.add(root);
        while (!link.isEmpty()){
            BinaryNode temp = link.remove();
            currentLevelNodes--;
            if (temp.getLeft() != null){
                link.add(temp.getLeft());
                nextLevelNodes++;
            }
            if (temp.getRight() != null){
                link.add(temp.getRight());
                nextLevelNodes++;
            }
            if (currentLevelNodes == 0){
                depth++;
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return depth;
    }

    /**
     * 求二叉树的节点个数，递归
     * @param root
     * @return
     */
    public int getNodeNumRec(BinaryNode root){
        if (root == null){
            return 0;
        }
        return getNodeNumRec(root.getLeft()) + getNodeNumRec(root.getRight()) + 1;
    }

    /**
     * 非递归求节点个数
     * @param root
     * @return
     */
    public int getNodeNum(BinaryNode root){
        if (root == null){
            return 0;
        }
        int count = 1;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode temp = queue.remove();
            if (temp.getLeft() != null){
                queue.add(temp.getLeft());
                count++;
            }
            if (temp.getRight() != null){
                queue.add(temp.getRight());
                count++;
            }
        }
        return count;
    }

    public int getLeafNumRec(BinaryNode root){
        if (root == null){
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null){
            return 1;
        }
        return getLeafNumRec(root.getLeft()) + getLeafNumRec(root.getRight());
    }

}
