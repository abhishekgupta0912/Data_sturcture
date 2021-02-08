package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        right = left = null;
    }
}

public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.insert(10);
        b.insert(6);
        b.insert(12);
        b.insert(7);
        b.insert(3);
        b.insert(4);
        b.insert(2);
        b.insert(11);
        b.insert(15);
        b.insert(13);
        b.insert(16);
        b.traversepre(b.root);
      /*  b.traversepreIterative(b.root)
        b.Inorder(b.root);
        b.inorderloop(b.root);
        b.PostOrder(b.root);
        b.levelorder(b.root);*/
        //b.height(b.root);
        // b.PostOrder(b.root);
/*        System.out.println(b.maxelement(b.root));
        System.out.println(" lopp " + b.maxele(b.root));
        System.out.println(b.find(b.root, 23));
        System.out.println(b.find(b.root, 77));*/
        // System.out.println(b.countnode(b.root));
        System.out.println(b.minept(b.root));
    }

    public void insert(int data) {
        Node n = new Node(data);
        if (root == null)
            root = n;
        else {
            Node temp = root;
            Node parent = null;
            while (temp != null) {
                parent = temp;
                if (n.data <= temp.data)
                    temp = temp.left;
                else
                    temp = temp.right;
            }
            if (n.data <= parent.data)
                parent.left = n;
            else
                parent.right = n;
        }
    }

    public void traversepre(Node n) {

        if (n != null) {
            System.out.println(n.data + " ");
            traversepre(n.left);
            traversepre(n.right);
        }
    }

    public void traversepreIterative(Node n) {
        System.out.println("Preorder traversal with loop ");
        if (n == null)
            System.out.println("Empty Tree");
        else {
            Stack<Node> stack = new Stack<>();
            stack.push(n);
            while (!stack.empty()) {
                Node current = stack.pop();
                System.out.print(current.data + "  ");
                if (current.right != null)
                    stack.push(current.right);
                if (current.left != null)
                    stack.push(current.left);
            }

        }
        System.out.println();
    }

    public void Inorder(Node n) {

        if (n != null) {
            Inorder(n.left);
            System.out.println(n.data);
            Inorder(n.right);
        }
    }

    public void inorderloop(Node n) {
        if (n == null)
            System.out.println("Empty Tree");
        else {
            Stack<Node> s = new Stack<>();
            Node current = n;
            boolean done = false;
            while (!done) {
                if (current != null) {
                    s.push(current);
                    current = current.left;
                } else {
                    if (s.empty())
                        done = true;
                    else {
                        current = s.pop();
                        System.out.println(current.data);
                        current = current.right;
                    }
                }
            }
        }
    }

    public void PostOrder(Node n) {
        if (n != null) {
            PostOrder(n.left);
            PostOrder(n.right);
            System.out.println(n.data);
        }
    }

    public void levelorder(Node n) {
        if (n == null)
            System.out.println("Empty Tree");
        else {
            Queue<Node> q = new LinkedList<>();
            q.add(n);
            while (!q.isEmpty()) {
                Node current = q.remove();
                System.out.print(current.data + "  ");
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
            }
        }
    }

    public void height(Node n) {
        if (n == null)
            System.out.println(" Empty Tree ");
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        int height = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            height++;
            while (size > 0) {
                Node current = q.remove();
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                size--;
            }
        }
        System.out.println("Height of tree is --> " + height);
    }

    public int maxelement(Node node) {
        int max = Integer.MIN_VALUE;
        if (node != null) {
            int Lmax = maxelement(node.left);
            int Rmax = maxelement(node.right);
            if (Lmax > Rmax && node.data < Lmax)
                max = Lmax;
            else if (Rmax > Lmax && node.data < Rmax)
                max = Rmax;
            else max = node.data;

        }
        return max;
    }

    public int maxele(Node node) {

        int max = Integer.MIN_VALUE;
        if (node != null) {
            Stack<Node> s = new Stack<>();
            s.push(node);
            while (!s.empty()) {
                Node temp = s.pop();
                if (temp.data > max)
                    max = temp.data;
                if (temp.left != null)
                    s.push(temp.left);
                if (temp.right != null)
                    s.push(temp.right);
            }
        }
        return max;
    }

    public boolean find(Node node, int data) {
        boolean val = false;
        if (node == null)
            return false;
        if (node.data == data)
            return true;
        return find(node.left, data) || find(node.right, data);
    }

    public int countnode(Node node) {
        if (node != null) {
            int lcount = countnode(node.left);
            int rcount = countnode(node.right);
            return 1 + rcount + lcount;
        } else
            return 0;
    }

    public int minept(Node node) {
        if (node != null) {
            Queue<Node> s = new LinkedList<>();
            s.add(node);
            while (!s.isEmpty()) {
                Node temp = s.remove();
                if (temp.left == null && temp.right == null) {
                    return temp.data;
                }
                if (temp.left != null)
                    s.add(temp.left);
                if (temp.right != null)
                    s.add(temp.right);
            }
        }
        if (node.left == null && node.right == null)
            return node.data;
        return 0;
    }
}
