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

    public void printList(){
        Node node = head;
        while( node != null ){
            System.out.println(node.value);
            node = node.next;
        }
    }

    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node node = new Node(value);
        if( length == 0 ){
            head = node;
            tail = node;
            length = 1;
        }else{
            tail.next =node;
            tail = node;
            length++;
        }
    }

    public int removeLast(){
        int result = -1;
        if(length == 0){
            return result;
        }
        if( length == 1 ){
            result = tail.value;
            head = null;
            tail = null;
            length = 0;
            return result;
        }
        Node node = head;
        Node prevNode = null;
        while( node.next != null){
            prevNode = node;
            node = node.next;
        }
        result = node.value;
        prevNode.next = null;
        tail = prevNode;
        length--;
        return result;
    }

    public int removeFirst(){
        int result = -1;
        if( length == 0 ){
            return -1;
        }
        if( length == 1){
            result = tail.value;
            head = null;
            tail = null;
            length = 0;
            return result;
        }
        Node nextNode = head.next;
        result = head.value;
        head = nextNode;
        return result;
    }

    public void prepend(int value){
        Node node = new Node(value);
        if( length == 0 ){
            head = node;
            tail = node;
            length = 1;
            return;
        }
        node.next = head;
        head = node;
    }

    public int get(int index){
        int result = -1;
        if( index < 0 || index >= length ){
            return -1;
        }
        int counter = 0 ;
        Node node = head;
        for( counter = 1 ; counter <= index ; counter++ ){
            node = node.next;
        }
        return node.value;
    }

    public void set(int index, int value){
        if( index < 0 || index >= length ){
            System.out.println("Wrong index value, exiting method");
            return;
        }
        Node node = new Node(value);
        Node prevNode = head;
        for( int counter = 1; counter < index ; counter++ ){
            prevNode = prevNode.next;
        }
        node.next = prevNode.next;
        prevNode.next = node;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        //now temp is at start
        Node before = null;
        Node after = temp.next;

        //now reverse the pointer
        int counter = 0;
        while( counter <= length ){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
            counter++;
        }
        System.out.println("reverse complete");
    }
}
