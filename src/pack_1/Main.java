package pack_1;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    Node head, tail;

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            int x = sc.nextInt();
            obj.create(x);
        }
        obj.head = obj.insertAtBeginning(obj.head, 10);
        obj.show();
        obj.head = obj.insertAtLast(obj.head, 90);
        obj.show();
        obj.head = obj.insertAt(obj.head, 30, 4);
        obj.show();
        obj.head = obj.delFirsr(obj.head);
        obj.show();
        obj.head = obj.delLast(obj.head);
        obj.show();
        obj.head = obj.delAt(obj.head, 4);
        obj.show();
        obj.head = obj.reverseLink(obj.head);
        obj.show();
        ;

    }

    public void create(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public Node insertAtBeginning(Node head, int x) {
        Node n = new Node(x);
        n.next = head;
        head = n;
        return head;
    }

    public Node insertAtLast(Node head, int x) {
        Node n = new Node(x);
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = n;
        return head;
    }

    public Node insertAt(Node head, int x, int posotion) {
        Node n = new Node(x);
        int c = 1;
        Node previous = head;
        while (c < posotion - 1) {
            previous = previous.next;
            c++;
        }
        Node temp = previous.next;
        previous.next = n;
        n.next = temp;
        return head;
    }

    public Node delFirsr(Node head) {
        Node temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    public Node delLast(Node head) {
        Node last = head;
        Node preLast = null;
        while (last.next != null) {
            preLast = last;
            last = last.next;
        }
        preLast.next = null;
        return head;
    }

    public Node delAt(Node head, int pos) {
        Node pre = head;
        int c = 1;
        while (c < pos - 1) {
            pre = pre.next;
            c++;
        }
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        return head;
    }

    public Node reverseLink(Node head) {
        Node curr = head;
        Node previous = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        return previous;
    }

    public void show() {
        Node current = head;
        System.out.println("-------------  List is -------------");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
