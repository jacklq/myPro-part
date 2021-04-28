package LQdemo;

import LQdemo.util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树数据结构
 * <p>
 * 广度优先遍历使用队列实现,
 * 从左到右
 * Queue<TreeNode> myQueue = new LinkedList<>();     myQueue.poll()        myQueue.offer()
 * <p>
 * 深度优先遍历使用栈实现
 * 先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了
 * Stack<TreeNode> myStack = new Stack<>();     myStack.pop();     myStack.push()
 */

public class BfsAndDfs {


    //广度优先遍历是使用队列实现的,跟层次遍历是一样的
    public void BroadFirstSearch(TreeNode nodeHead) {
        if (nodeHead == null) {
            return;
        }

//            而LinkedList采用双向链表，本身就有addFirst addLast getFirst getLast等功能的需求，
//            而队列是只是特定功能的LinkedList，二者实现的方法都是一样的，所以队列只是实现了接口。
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(nodeHead);
        while (!myQueue.isEmpty()) {
            TreeNode node = myQueue.poll();
            System.out.print(node.getVal() + " ");
            if (null != node.getLeft()) {
                myQueue.offer(node.getLeft());    //广度优先遍历，我们在这里采用每一行从左到右遍历
            }
            if (null != node.getRight()) {
                myQueue.offer(node.getRight());
            }

        }
    }

    //深度优先遍历，使用栈实现
    public void depthFirstSearch(TreeNode nodeHead) {
        if (nodeHead == null) {
            return;
        }
        Stack<TreeNode> myStack = new Stack<>();
        myStack.push(nodeHead);
        while (!myStack.isEmpty()) {
            TreeNode node = myStack.pop();    //弹出栈顶元素
            System.out.print(node.getVal() + " ");
            if (node.getRight() != null) {
                myStack.push(node.getRight());    //深度优先遍历，先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了
            }
            if (node.getLeft() != null) {
                myStack.push(node.getLeft());
            }
        }

    }


    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.print("广度优先遍历结果：");
        new BfsAndDfs().BroadFirstSearch(node1);
        System.out.println();
        System.out.print("深度优先遍历结果：");
        new BfsAndDfs().depthFirstSearch(node1);

    }
}




