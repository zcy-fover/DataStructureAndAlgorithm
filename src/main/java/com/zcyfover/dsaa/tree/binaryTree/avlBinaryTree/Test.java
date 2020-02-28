package com.zcyfover.dsaa.tree.binaryTree.avlBinaryTree;

import com.zcyfover.dsaa.tree.binaryTree.BinaryNode;
import com.zcyfover.dsaa.tree.binaryTree.usualBinaryTree.Traversal;

/**
 * Created by zcy-fover on 2016/10/7.
 */
public class Test {
    public static void main(String[] args) {
        int[] array = {2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};
        AVLBinaryTree test = new AVLBinaryTree();
        BinaryNode<Integer> root = new BinaryNode<Integer>(3, null, null);
        //此处在插入时，可能会调整树的根，所以每次需要将根返回，并赋值给root以进行下一次插入
        for (int a: array){
            root = test.insert(a, root);
        }

        Traversal traversal = new Traversal();
        traversal.preorderTraversal(root);
        System.out.println();
        traversal.inorderTraversal(root);

        System.out.println();
        System.out.println(root.getDepth(root));
    }
}
