package pack_1;

class Link {
    int x;
    Link next;

    Link(int x) {
        this.x = x;
        this.next = null;
    }
}

public class Main2 {
    Link head, tail;

    public static void main(String[] args) {
        Main2 m = new Main2();
        m.create(23);
        m.create(31);
        m.create(2);
        m.create(23);
        m.create(3);
        m.create(31);
        m.show();
        m.head = m.remdul(m.head);
        m.show();
    }

    public void create(int x) {
        Link n = new Link(x);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void show() {
        Link current = head;
        System.out.println("-------------  List is -------------");
        while (current != null) {
            System.out.print(current.x + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Link remdul(Link head) {
        Link curr = head;

        while (curr != null) {
            Link currNext = curr.next;
            Link pre = curr;
            while (currNext != null) {
                if (curr.x == currNext.x) {
                    pre.next = currNext.next;
                } else {
                    pre = currNext;
                }
                currNext = currNext.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
