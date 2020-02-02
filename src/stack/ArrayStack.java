package stack;

public class ArrayStack {
    int capacity = 10;               // let the size of the stack be 10
    int[] stack = new int[capacity];
    int top = 0;

    public void push(int data) {
        if (top == capacity) {
            System.out.println("Stack Is Full");
            return;
        }
        stack[top] = data;
        top++;
    }

    public int pop() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("Stack Is Empty");
        } else {
            top--;
            data = stack[top];
            stack[top] = 0;
        }
        return data;
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top <= 0;
    }

    public void showStack() {
        for (int i : stack) {
            System.out.print(i + "    ");
        }
        System.out.println();
    }
}
