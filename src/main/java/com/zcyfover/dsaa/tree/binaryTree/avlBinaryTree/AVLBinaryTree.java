package com.zcyfover.dsaa.tree.binaryTree.avlBinaryTree;


import com.zcyfover.dsaa.tree.binaryTree.BinaryNode;

/**
 * Created by zcy-fover on 2016/10/6.
 * 平衡二叉树：
 * 每个节点的左子树和右子树的高度差最多差1
 * 一棵高度为h的AVL树，需要的最少节点数S(h) = S(h-1) + S(h-2) + 1
 */
public class AVLBinaryTree<DataType extends Comparable<? super DataType>> extends BinaryNode<DataType> {

    private static final int ALLOWEDBALANCE = 1;

    public AVLBinaryTree(){
    }

    public AVLBinaryTree(DataType element) {
        super(element);
    }

    public AVLBinaryTree(DataType element, BinaryNode<DataType> left, BinaryNode<DataType> right) {
        super(element, left, right);
    }

    /**
     * 计算AVL节点的高度
     *
     * @param t
     * @return
     */
    public int height(BinaryNode<DataType> t) {
        return t == null ? -1 : t.getDepthRec(t);
    }

    /**
     * 以查找二叉树的方式插入节点，插入后利用balance()方法，将二叉树平衡
     *
     * @param x
     * @param t
     * @return
     */
    @Override
    public BinaryNode<DataType> insert(DataType x, BinaryNode<DataType> t) {
        if (t == null) {
            return new BinaryNode<DataType>(x, null, null);
        }
        int compareResult = x.compareTo(t.getElement());
        if (compareResult < 0) {
            t.setLeft(insert(x, t.getLeft()));
        } else if (compareResult > 0) {
            t.setRight(insert(x, t.getRight()));
        }
        return balance(t);
    }

    public BinaryNode<DataType> balance(BinaryNode<DataType> t) {
        if (t == null) {
            return t;
        }
        if (height(t.getLeft()) - height(t.getRight()) > ALLOWEDBALANCE) {
            if (height(t.getLeft().getLeft()) >= height(t.getLeft().getRight())) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.getRight()) - height(t.getLeft()) > ALLOWEDBALANCE) {
            if (height(t.getRight().getRight()) >= height(t.getRight().getLeft())) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }
        return t;
    }

    public BinaryNode<DataType> rotateWithLeftChild(BinaryNode<DataType> t) {
        BinaryNode k = t.getLeft();
        t.setLeft(k.getRight());
        k.setRight(t);
        return k;
    }

    public BinaryNode<DataType> rotateWithRightChild(BinaryNode<DataType> t) {
        BinaryNode k = t.getRight();
        t.setRight(k.getLeft());
        k.setLeft(t);
        return k;
    }

    public BinaryNode<DataType> doubleWithLeftChild(BinaryNode<DataType> t) {
        t.setLeft(rotateWithRightChild(t.getLeft()));
        return rotateWithLeftChild(t);
    }

    public BinaryNode<DataType> doubleWithRightChild(BinaryNode<DataType> t) {
        t.setRight(rotateWithLeftChild(t.getRight()));
        return rotateWithRightChild(t);
    }

    /**
     * 删除某一个节点，删除后可能导致书不平衡，需要重新balance
     * @param x
     * @param t
     * @return
     */
    public BinaryNode<DataType> remove(DataType x, BinaryNode<DataType> t){
        if (t == null){
            return t;
        }
        int compareResult = x.compareTo(t.getElement());
        if (compareResult > 0){
            t.setRight(remove(x, t.getRight()));
        } else if (compareResult < 0){
            t.setLeft(remove(x, t.getLeft()));
        } else if (t.getLeft() != null && t.getRight() != null){
            //如果删除的是根节点，则找到根节点右子树的最左孩子，将其内容复制给根节点，然后再删除右子树的最左孩子
            t.setElement(findMin(t.getRight()).getElement());
            t.setRight(remove(t.getElement(), t.getRight()));
        } else {
            t = (t.getLeft() != null) ? t.getLeft() : t.getRight();
        }
        return balance(t);
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
}
