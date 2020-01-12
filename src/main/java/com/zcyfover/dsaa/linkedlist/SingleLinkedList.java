package com.zcyfover.dsaa.linkedlist;

/**
 * @author zcy-fover
 * @description 单向链表
 * @date 2019-10-15 21:28
 */
public class SingleLinkedList<T> {

    /**
     * 哨兵节点
     */
    private Node<T> sentinel;

    /**
     * 头节点
     */
    private Node<T> head;

    /**
     * 尾节点
     */
    private Node<T> tail;

    /**
     * 链表的元素个数
     */
    private int size;

    public SingleLinkedList() {
        //初始化一个哨兵节点
        this.sentinel = new Node<>(null);
        this.head = this.sentinel;
        this.tail = this.sentinel;
    }

    public void add(T value) {
        //先创建一个节点
        Node<T> temp = new Node<>(value);
        //头节点不为空，当前节点
        this.tail.setNextNode(temp);
        this.tail = temp;
        this.size++;
    }

    /**
     * 删除值为 value 的节点
     * @param value 节点的值
     */
    public T delete(T value) {
        if (this.size <= 0) {
            //链表为空
            return null;
        }
        Node<T> preNode = this.head;
        for (int i = 0; i < size; i++) {
            if (this.sentinel.getValue().equals(value)) {
                preNode.setNextNode(this.sentinel.getNextNode());
                return this.sentinel.getValue();
            } else {
                preNode = this.sentinel;
                this.sentinel = this.sentinel.getNextNode();
            }
        }
        return null;
    }

    public void insert(T value) {

    }

}
