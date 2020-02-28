package com.zcyfover.dsaa.tree.binaryTree.usualBinaryTree;


import com.zcyfover.dsaa.tree.binaryTree.BinaryNode;

/**
 * Created by zcy-fover on 2016/10/4.
 */
public class Test {
    public static void main(String[] args) {
        int[] array = {1, 2, 6, 3, 8};
        BinaryNode<Integer> root = new BinaryNode<Integer>(4, null, null);
        for (int a: array){
            root.insert(a, root);
        }
        Traversal traversal = new Traversal();
        System.out.println("递归遍历输出：");
        System.out.print("    先序遍历：");
        traversal.preorderTraversalRec(root);
        System.out.println();
        System.out.print("    中序遍历：");
        traversal.inorderTraversalRec(root);
        System.out.println();
        System.out.print("    后序遍历：");
        traversal.postorderTraversalRec(root);
        System.out.println();

        System.out.println("非递归遍历输出：");
        System.out.print("    先序遍历：");
        traversal.preorderTraversal(root);
        System.out.println();
        System.out.print("    中序遍历：");
        traversal.inorderTraversal(root);
        System.out.println();
        System.out.print("    后序遍历：");
        traversal.postorderTraversal(root);

        System.out.println();
        System.out.println("层次遍历输出：");
        traversal.layerorder(root);

        System.out.println();
        System.out.println(root.getDepthRec(root));
        System.out.println(root.getDepth(root));
    }
}
