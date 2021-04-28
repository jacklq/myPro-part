package LQdemo;


import LQdemo.util.TreeNode;

import java.util.*;

/*步骤1：定义两个list，一个存放每层的树，一个存放遍历出的数值
        2：将第一个树放到list中
        3：每层的树不为空时，遍历每层的树
        4：     计算每层树的数量，不为0时
        5             从首位置取树并删除，将值添加到list中，size--,将左支和右支分别放到树list中
        6       将每层的数值，添加到list中
        7  返回*/
//2、给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
public class binaryTree {
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List ret = new ArrayList<>();
        LinkedList<TreeNode> treeList = new LinkedList<>();

        //队列不为空
        if (root != null) {
            treeList.offer(root);
        }

        while (!treeList.isEmpty()) {
            TreeNode cur = treeList.poll();
            System.out.print(cur.getVal() + " ");
            ret.add(cur.getVal());


            if (cur.getLeft() != null) {
                treeList.offer(cur.getLeft());
            }

            if (cur.getRight() != null) {
                treeList.offer(cur.getRight());
            }


        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(9, null, null);
        TreeNode node4 = new TreeNode(15, null, null);
        TreeNode node5 = new TreeNode(7, null, null);
        TreeNode node3 = new TreeNode(20, node4, node5);
        TreeNode node1 = new TreeNode(3, node2, node3);

        binaryTree bt = new binaryTree();
        bt.levelOrder2(node1);
    }

}
