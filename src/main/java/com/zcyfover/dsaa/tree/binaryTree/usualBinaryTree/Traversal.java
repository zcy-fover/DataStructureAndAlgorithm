package com.zcyfover.dsaa.tree.binaryTree.usualBinaryTree;


import com.zcyfover.dsaa.tree.binaryTree.BinaryNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by zcy-fover on 2016/10/4.
 * 二叉树的遍历
 */
public class Traversal {

    /*************************
     * 二叉树的遍历，递归实现  **
     *************************/
    /**
     * 先序遍历
     */
    public void preorderTraversalRec(BinaryNode root) {
        if (root != null) {
            System.out.print(root.getElement() + "-");
            preorderTraversalRec(root.getLeft());
            preorderTraversalRec(root.getRight());
        }
    }

    /**
     * 中序遍历
     */
    public void inorderTraversalRec(BinaryNode root) {
        if (root != null) {
            inorderTraversalRec(root.getLeft());
            System.out.print(root.getElement() + "-");
            inorderTraversalRec(root.getRight());
        }
    }

    /**
     * 后序遍历
     */
    public void postorderTraversalRec(BinaryNode root) {
        if (root != null) {
            postorderTraversalRec(root.getLeft());
            postorderTraversalRec(root.getRight());
            System.out.print(root.getElement() + "-");
        }
    }

    /*************************
     * 二叉树的遍历，非递归实现  **
     *************************/
    //先序遍历
    public void preorderTraversal(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode current = root;
        while (current != null || !stack.empty()){
            if (current != null){
                System.out.print(current.getElement() + "-");
                stack.push(current);
                current = current.getLeft();
            } else {    //当访问到最左边的孩子后开始访问右孩子
                current = stack.pop();
                current = current.getRight();
            }
        }
    }

    //中序遍历
    public void inorderTraversal(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode current = root;
        while (current != null || !stack.empty()) {
            if (current != null) {        //从根节点开始，如果当前节点有左孩子，则入栈。包括最左孩子节点
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                System.out.print(current.getElement() + "-");
                current = current.getRight();
            }
        }
    }

    /**
     * 后序遍历
     * 通过观察逆后序遍历结果，可发现，逆后序遍历结果可以通过将前序遍历的遍历顺序的第二步和第三步互换一下即可。
     * 即：先遍历根节点，然后遍历右孩子，最后遍历左孩子。
     * @param root
     */
    public void postorderTraversal(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        Stack<BinaryNode> outStack = new Stack<>();
        BinaryNode current = root;
        while (current != null || !stack.empty()){
            if (current != null){
                outStack.push(current);
                stack.push(current);
                current = current.getRight();
            } else {
                current = stack.pop();
                current = current.getLeft();
            }
        }
        while (!outStack.empty()){
            System.out.print(outStack.pop().getElement() + "-");
        }
    }

    //层次遍历
    public void layerorder(BinaryNode root) {
        LinkedList<BinaryNode> queue = new LinkedList<>();
        queue.addLast(root);
        BinaryNode<Integer> current = null;
        while (!queue.isEmpty()) {
            current = queue.removeFirst();
            if (current.getLeft() != null)
                queue.addLast(current.getLeft());
            if (current.getRight() != null)
                queue.addLast(current.getRight());
            System.out.print(current.getElement() + "-");
        }
    }
}
