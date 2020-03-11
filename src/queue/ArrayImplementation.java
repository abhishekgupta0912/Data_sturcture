package queue;

public class ArrayImplementation {
    private static int rear, front, capacity;
    private static int queue[];

    ArrayImplementation(int c) {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }

    public static void main(String[] args) {
        ArrayImplementation arr = new ArrayImplementation(5); // size of array is 5
        arr.Equeue(23); //insertion in queue
        arr.Equeue(45);
        arr.Equeue(67);
        arr.Equeue(4);
        arr.display();   // display the queue
        System.out.println();
        arr.Dqueue();  // Dqueue operations
        arr.Dqueue();
        arr.display();  // displaying the queue after performing Dqueue operation
        System.out.println();
        arr.Queuefront(); // printing the Front element

    }

    public void Equeue(int data) {
        if (rear == capacity) {
            System.out.println("Queue Is Full");
        } else {
            queue[rear] = data;
            rear++;
        }
    }

    public void Dqueue() {
        if (front == rear)
            System.out.println("Queue Is Empty");
        else {
            System.out.println(queue[front]);
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            if (rear < capacity)
                queue[rear] = 0;
            rear--;
        }
    }

    public void display() {
        if (front == rear)
            System.out.println("Queue Is Empty");
        else {
            for (int i = front; i < rear; i++) {
                System.out.print(queue[i] + "   ");
            }
        }
    }

    public void Queuefront() {
        if (front == rear)
            System.out.println("Queue Is Empty");
        else
            System.out.println("Front Element Is --> " + queue[front]);
    }
}
