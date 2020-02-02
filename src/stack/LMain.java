package stack;

public class LMain {
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
            System.out.println(s.pop());
        }


    }
}
