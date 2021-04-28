package LQdemo;

import LQdemo.util.ListNode;

public class reverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null, nextNode = null;

        while (head != null) {
            // 保存下个节点,防止丢失
            nextNode = head.getNext();
            // 将他的下个节点指向前个节点
            head.setNext(preNode);
            // head指向pre后，就继续依次反转下个节点
            // 让pre，head依次向后移动一个节点，继续下一次的反转
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }


    public static void main(String[] args) {
        ListNode node3 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(3, node2);
        ListNode head = new ListNode(4, node1);
        System.out.println("打印链表反转前：");
        ListNode cur = head;
        while (cur.getNext() != null) {
            System.out.print(cur.getVal() + "->");
            cur = cur.getNext();
        }
        System.out.println(cur.getVal());
        reverseList temp = new reverseList();
        ListNode array = temp.reverseList(head);
        System.out.println("打印链表反后：");
        ListNode curAfter = array;
        while (curAfter.getNext() != null) {
            System.out.print(curAfter.getVal() + "->");
            curAfter = curAfter.getNext();
        }
        System.out.println(curAfter.getVal());

    }
}
