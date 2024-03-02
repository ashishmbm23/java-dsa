package dsa.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }
}
