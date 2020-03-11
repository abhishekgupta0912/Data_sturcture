package queue;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class CircularQueue {
    Node front, rear;

    CircularQueue() {
        front = rear = null;
    }

    public static void main(String args[]) {
        // Create a queue and initialize front and rear
        CircularQueue q = new CircularQueue();

        // Inserting elements in Circular Queue
        q.enqueue(14);
        q.enqueue(22);
        q.enqueue(6);

        // Display elements present in Circular Queue
        q.display();

        // Deleting elements from Circular Queue
        System.out.printf("\nDeleted value = %d", q.dequeue());
        System.out.printf("\nDeleted value = %d", q.dequeue());

        // Remaining elements in Circular Queue
        q.display();

        q.enqueue(9);
        q.enqueue(20);
        q.display();

    }

    public void enqueue(int data) {
        Node n = new Node(data);
        if (front == null) {
            front = n;
        } else
            rear.next = n;
        rear = n;
        rear.next = front;
    }

    public int dequeue() {
        if (front == null)
            System.out.println("EMpty Queue");
        int a;
        if (front == rear) {
            a = front.data;
            front = rear = null;
        } else {
            Node temp = front;
            a = temp.data;
            front = front.next;
            rear.next = front;
        }
        return a;
    }

    public void display() {
        Node temp = front;
        System.out.print("\nElements in Circular Queue are: ");
        while (temp.next != front) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.print(temp.data + "  ");
        System.out.println();
    }
}
