package queue;

class QNode {
    int key;
    QNode next;

    public QNode(int key) {
        this.key = key;
        this.next = null;
    }
}

public class LinkListImplementation {
    QNode front, rear;

    public LinkListImplementation() {
        this.front = this.rear = null;
    }

    public static void main(String[] args) {
        LinkListImplementation q = new LinkListImplementation();
        q.enqueue(10);
        q.enqueue(20);
        q.display();
        q.dequeue();
        q.dequeue();
        q.display();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        q.dequeue();
        q.display();
        System.out.println("Queue Front : " + q.front.key);
        System.out.println("Queue Rear : " + q.rear.key);
    }

    void enqueue(int key) {

        // Create a new LinkList node
        QNode temp = new QNode(key);

        // If queue is empty, then new node is front and rear both
        if (rear == null) {
            front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        rear.next = temp;
        rear = temp;
    }

    // Method to remove an key from queue.
    void dequeue() {
        // If queue is empty, return NULL.
        if (front == null)
            return;

        // Store previous front and move front one node ahead
        QNode temp = front;
        front = front.next;

        // If front becomes NULL, then change rear also as NULL
        if (front == null)
            rear = null;
    }

    void display() {
        QNode current = front;
        System.out.println("-------------  Queue -------------");
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }
}
