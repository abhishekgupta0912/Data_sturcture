package stack;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackException extends Exception {
    public StackException(String s) {
        super(s);
    }
}

class Stack {
    Node top;
    int len;

    Stack() {
        this.len = 0;
        this.top = null;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public int length() {
        return len;
    }

    public void push(int data) {
        Node temp = new Node(data);
        temp.next = top;
        top = temp;
        len++;
    }

    public int pop() throws StackException {
        if (isEmpty())
            throw new StackException("Stack UnderFlow");
        int result = top.data;
        top = top.next;
        len--;
        return result;
    }

    public int peek() throws StackException {
        if (isEmpty())
            throw new StackException("Stack UnderFlow");

        return top.data;
    }

}

public class MainStack {
    public static void main(String[] args) throws StackException {
        Stack s = new Stack();
        s.push(56);
        s.push(23);
        s.push(564);
        s.push(213);
        s.push(5116);
        s.push(2354);
        //    System.out.println(s.length());
        while (s.length() > 0) {
            System.out.println(s.pop() + " " + s.length());
        }


    }
}
