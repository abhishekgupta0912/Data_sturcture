package stack;

public class Main {
    public static void main(String[] args) throws StackException {
        System.out.println("List Stack");
        Stack s = new Stack(); // Stack implementation using link list
        s.push(56);
        s.push(23);
        s.push(564);
        s.push(213);
        s.push(5116);
        s.push(2354);
        //    System.out.println(s.length());
        while (s.length() > 0) {
            System.out.println(s.pop());
        }

        System.out.println("Array stack");
        ArrayStack a = new ArrayStack();  // Stack implementation using array
        a.push(109);
        a.push(198);
        a.push(10);
        a.push(14);
        a.push(12);
        a.showStack();
        System.out.println("\n Stack size is " + a.size());

        System.out.println("\n pop element is " + a.pop());


    }
}
