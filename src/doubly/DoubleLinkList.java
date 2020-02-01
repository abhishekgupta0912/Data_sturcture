package doubly;

import java.util.Scanner;

class Node {
    Node previous, next;
    int data;

    Node(int x) {
        this.data = x;
        this.next = null;
        this.previous = null;
    }
}

public class DoubleLinkList {
    Node head, tail;

    public static void main(String[] args) {
        DoubleLinkList d = new DoubleLinkList();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            int x = sc.nextInt();
            d.create(x);
        }
        d.displayFor(d.head);
        d.displayback(d.tail);
        d.head = d.insertAtFirst(21, d.head);
        d.displayFor(d.head);
        d.displayback(d.tail);
        d.tail = d.insertAtLast(41, d.tail);
        d.displayFor(d.head);
        d.displayback(d.tail);
        d.head = d.insertAt(44, d.head, 4);
        d.displayFor(d.head);
        d.displayback(d.tail);
        d.head = d.delfirst(d.head);
        d.displayFor(d.head);
        d.displayback(d.tail);
        d.tail = d.delLast(d.tail);
        d.displayFor(d.head);
        d.displayback(d.tail);
        d.head = d.delAt(d.head, 3);
        d.displayFor(d.head);
        d.displayback(d.tail);
    }

    public void create(int x) {
        Node n = new Node(x);
        if (head == null) {
            tail = n;
            head = n;

        } else {
            n.previous = tail;
            tail.next = n;
            tail = n;

        }
    }

    public Node insertAtFirst(int x, Node head) {
        Node n = new Node(x);
        n.next = head;
        head.previous = n;
        head = n;
        return head;
    }

    public Node insertAtLast(int x, Node tail) {
        Node n = new Node(x);
        n.previous = tail;
        tail.next = n;
        tail = n;
        return tail;
    }

    public Node insertAt(int x, Node head, int pos) {
        Node cur = head, pre = null;
        Node n = new Node(x);
        int c = 1;
        while (c < pos - 1) {

            cur = cur.next;
            c++;
        }
        pre = cur.next;
        cur.next = n;
        n.previous = cur;
        pre.previous = n;
        n.next = pre;
        return head;
    }

    public Node delfirst(Node head) {
        head = head.next;
        head.previous = null;
        return head;
    }

    public Node delLast(Node tail) {
        tail = tail.previous;
        tail.next = null;
        return tail;
    }

    public Node delAt(Node head, int pos) {
        int c = 0;
        Node temp = head;
        while (c < pos - 1) {
            temp = temp.next;
            c++;
        }
        Node pre = temp.previous;
        Node tNext = temp.next;
        pre.next = tNext;
        tNext.previous = pre;
        return head;
    }

    public void displayFor(Node head) {
        if (head == null)
            System.out.println("list is empty");
        else {
            Node cur = head;
            System.out.println("---------------list-------------");
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public void displayback(Node tail) {
        if (tail.previous == null) {
            System.out.println(" This might be the first Node");
        } else {
            Node cur = tail;
            System.out.println("---------------list-------------");
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.previous;
            }
            System.out.println();
        }
    }

}
