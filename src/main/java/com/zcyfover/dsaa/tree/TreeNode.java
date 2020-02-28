package com.zcyfover.dsaa.tree;

/**
 * Created by zcy-fover on 2016/10/4.
 */
public class TreeNode<T> {
    private T element;              //节点类型
    private TreeNode firstChild;    //第一儿子的链
    private TreeNode nextSibling;   //下一兄弟的链

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }
}
