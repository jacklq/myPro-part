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
public class binaryTreeTraversal {

    //前序遍历递归的方式
    public void preOrder(TreeNode root) {
        if (null != root) {
            System.out.print(root.getVal() + "\t");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    //前序遍历非递归的方式
    public void preOrderNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.print(root.getVal() + "\t");
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) break;
            root = stack.pop();
            root = root.getRight();
        }
    }

    //中序遍历采用递归的方式
    public void inOrder(TreeNode root) {
        if (null != root) {
            inOrder(root.getLeft());
            System.out.print(root.getVal() + "\t");
            inOrder(root.getRight());
        }
    }

    //中序遍历采用非递归的方式
    public void inOrderNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) break;
            root = stack.pop();
            System.out.print(root.getVal() + "\t");
            root = root.getRight();
        }
    }

    //后序遍历采用递归的方式
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getVal() + "\t");
        }
    }

    //后序遍历采用非递归的方式
    public void postOrderNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                if (stack.isEmpty()) return;

                if (null == stack.lastElement().getRight()) {
                    root = stack.pop();
                    System.out.print(root.getVal() + "\t");
                    while (root == stack.lastElement().getRight()) {
                        System.out.print(stack.lastElement().getVal() + "\t");
                        root = stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }

                if (!stack.isEmpty())
                    root = stack.lastElement().getRight();
                else
                    root = null;
            }
        }
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.getVal() + "\t");
            if (null != temp.getLeft())
                queue.offer(temp.getLeft());
            if (null != temp.getRight()) {
                queue.offer(temp.getRight());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(9, null, null);
        TreeNode node4 = new TreeNode(15, null, null);
        TreeNode node5 = new TreeNode(7, null, null);
        TreeNode node3 = new TreeNode(20, node4, node5);
        TreeNode node1 = new TreeNode(3, node2, node3);

        binaryTreeTraversal bt = new binaryTreeTraversal();
        bt.preOrder(node1);
    }

}
