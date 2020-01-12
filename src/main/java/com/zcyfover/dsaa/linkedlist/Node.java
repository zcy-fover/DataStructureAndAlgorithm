package com.zcyfover.dsaa.linkedlist;

/**
 * @author zcy-fover
 * @description 链表节点
 * @date 2019-10-15 21:17
 */
public class Node<T> {

    /**
     * 数据节点 value
     */
    private T value;

    /**
     * 前继节点
     */
    private Node<T> prevNode;

    /**
     * 后继节点
     */
    private Node<T> nextNode;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node prevNode, Node nextNode) {
        this.value = value;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
