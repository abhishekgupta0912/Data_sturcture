package queue;

public class CircularArrayImplementation {
    private static int front, rear, capacity;
    private static int Cqueue[];

    CircularArrayImplementation(int c) {
        front = rear = -1;
        capacity = c;
        Cqueue = new int[capacity];
    }

    public static void main(String[] args) {
        CircularArrayImplementation queue = new CircularArrayImplementation(5);
        queue.enqueue(45);
        queue.enqueue(455);
        queue.enqueue(50);
        queue.display();
        queue.dequqeu();
        queue.dequqeu();
        queue.display();
    }

    public void enqueue(int data) {
        if ((rear + 1) % capacity == front) {
            System.out.println("Queue Is Full");
        } else if (rear == -1 && front == -1) {
            rear = front = 0;
        } else if (rear == capacity - 1 && front != 0) {
            rear = 0;
        } else
            rear = (rear + 1) % capacity;
        Cqueue[rear] = data;
    }

    public void dequqeu() {
        int a = Cqueue[front];
        if (front == -1 && rear == -1)
            System.out.println("Empty Queue");
        else if (front == rear) {
            rear = front = -1;
        } else if (front == capacity - 1) {
            front = 0;
        } else
            front++;
        System.out.println("Deleted Element Is --> " + a);
    }

    public void display() {
        if (front == -1 && rear == -1)
            System.out.println("Empty Queue");
        if (front > rear) {
            for (int i = front; i < capacity; i++) {
                System.out.print(Cqueue[i] + "  ");
            }
            for (int i = 0; i < rear; i++) {
                System.out.print(Cqueue[i] + "  ");
            }
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(Cqueue[i] + "  ");
            }
        }
        System.out.println();
    }

}
