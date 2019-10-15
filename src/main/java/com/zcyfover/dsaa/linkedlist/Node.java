package com.zcyfover.dsaa.linkedlist;

/**
 * @author zcy-fover
 * @description 链表节点
 * @date 2019-10-15 21:17
 */
public class Node {

    /**
     * 数据节点 value
     */
    private String value;

    /**
     * 前继节点
     */
    private Node prevNode;

    /**
     * 后继节点
     */
    private Node nextNode;

    public Node(String value, Node prevNode, Node nextNode) {
        this.value = value;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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
