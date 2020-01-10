package pack_1;

class Link {
    public int idata;
    public double ddata;
    public Link next;

    public Link(int a, double d) {
        this.ddata = d;
        this.idata = a;
    }

    public void display() {
        System.out.println("[ " + idata + "  " + ddata + " ]");
    }
}

class LinkList {
    private Link first;

    LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(int a, double dd) {
        Link newLink = new Link(a, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link delete() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void display() {
        Link current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println(" ");
    }
}

public class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insert(12, 33.00);
        theList.insert(13, 37.00);
        theList.insert(14, 36.00);
        theList.insert(15, 35.00);
        theList.insert(16, 34.00);
        theList.display();
        System.out.println("delete " + theList.delete());

    }
}
