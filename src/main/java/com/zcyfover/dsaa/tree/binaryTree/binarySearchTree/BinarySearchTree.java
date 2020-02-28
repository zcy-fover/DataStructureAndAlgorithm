package com.zcyfover.dsaa.tree.binaryTree.binarySearchTree;

import com.zcyfover.dsaa.tree.binaryTree.BinaryNode;

/**
 * Created by zcy-fover on 2016/10/6.
 * 查找二叉树：
 *      每个节点他的做孩子都比他小，右孩子都比他大，插入时以这种规律插入
 */
public class BinarySearchTree<DataType  extends Comparable<? super DataType>> extends BinaryNode<DataType> {

    public BinarySearchTree(DataType element) {
        super(element);
    }

    public BinarySearchTree(DataType element, BinaryNode<DataType> left, BinaryNode<DataType> right) {
        super(element, left, right);
    }

    /**
     * 插入节点,以二叉查找树的方式插入
     * @param x
     * @param t
     * @return
     */
    public BinaryNode<DataType> insert(DataType x, BinaryNode<DataType> t){
        if (t == null){ //说明该节点为根
            return new BinaryNode<DataType>(x, null, null);
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
     * 根据节点的内容，查找并删除该节点
     * 删除节点时有三种情况：以下将被删除节点称为A
     *      1、A是一个叶子节点，则直接删除
     *      2、A只有一个孩子节点，则将A的父节点指向A的链指向A的孩子节点
     *      3、A有两个孩子节点，用A的右子树的最小节点来代替A节点，然后在调整A的右子树使之满足查找二叉树的性质
     * @param x
     * @param t
     * @return
     */
    public BinaryNode<DataType> remove(DataType x, BinaryNode<DataType> t){
        if (t == null){
            return  t;
        }
        int compareResult = x.compareTo(t.getElement());
        if (compareResult < 0){
            t.setLeft(remove(x, t.getLeft()));
        } else if (compareResult > 0){
            t.setRight(remove(x, t.getRight()));
        } else if (t.getLeft() != null && t.getRight() != null){
            t.setElement(findMin(t.getRight()).getElement());
            t.setRight(remove(t.getElement(), t.getRight()));
        } else {
            t = (t.getLeft() != null) ? t.getLeft() : t.getRight();
        }
        return t;
    }

    /**
     * 找到以t为根的最小节点，即最左孩子节点
     * @param t
     * @return
     */
    public BinaryNode<DataType> findMin(BinaryNode t){
        if (t == null){
            return null;
        }else  if(t.getLeft() == null) {
            return t;
        }
        return findMin(t.getLeft());
    }

    /**
     * 找到以t为根的最大节点，即最右孩子节点
     * 非递归实现
     * @param t
     * @return
     */
    public BinaryNode<DataType> findMax(BinaryNode t){
        if (t != null){
            while (t.getRight() != null){
                t = t.getRight();
            }
        }
        return t;
    }

    /**
     * 树中是否包含内容为x节点
     * @return
     */
    public boolean contains(DataType x, BinaryNode<DataType> t){
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.getElement());
        if (compareResult < 0){
            return contains(x, t.getLeft());
        }else if (compareResult > 0){
            return contains(x, t.getRight());
        } else {
            return true;
        }
    }
}
