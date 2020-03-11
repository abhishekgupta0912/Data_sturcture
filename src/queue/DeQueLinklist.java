package queue;

class Node1 {
    int data;
    Node1 next, prev;

    Node1(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

public class DeQueLinklist {
    Node1 head, tail;

    DeQueLinklist() {
        head = tail = null;
    }

    public static void main(String[] args) {
        DeQueLinklist deque = new DeQueLinklist();
        //deque.getLast();
        deque.insertFirst(2);
        deque.insertFirst(1);
        deque.insertLast(3);
        deque.insertLast(4);
        deque.displayForward();
        Node1 node = deque.removeFirst();
        System.out.println("Node with value " + node.data + " deleted");
        deque.displayForward();
        System.out.println("First element in the deque " + deque.getFirst());
        System.out.println("Last element in the deque " + deque.getLast());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertFirst(int data) {

        Node1 newNode = new Node1(data);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {
        Node1 newNode = new Node1(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public Node1 removeFirst() {
        if (head == null) {
            System.out.println("Deque is empty");
        }
        Node1 first = head;
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        return first;
    }

    public Node1 removeLast() {
        if (tail == null) {
            System.out.println("Deque is empty");
        }
        Node1 last = tail;
        if (head.next == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        return last;
    }

    public int getFirst() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
        }
        return head.data;
    }

    public int getLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
        }
        return tail.data;
    }

    public void displayForward() {
        Node1 current = head;
        while (current != null) {
            System.out.print(current.data + "  ");
            current = current.next;
        }
        System.out.println("");
    }

}
