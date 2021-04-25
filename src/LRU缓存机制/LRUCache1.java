package LRU缓存机制;

import java.util.HashMap;

class Node {
    private int key;
    private int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getAfter() {
        return after;
    }

    public void setAfter(Node after) {
        this.after = after;
    }

    private Node pre;
    private Node after;
}

class DoubleList {
    private Node head;
    private Node tail;
    private int size;

    public Node getTail() {
        return tail;
    }

    public void remove(Node x) {

        if (head == x && tail == x) {
            head = null;
            tail = null;
        } else if (head == x) {
            x.getAfter().setPre(null);
            head = x.getAfter();
        } else if (tail == x) {
            x.getPre().setAfter(null);
            tail = x.getPre();
        } else {
            Node pre = x.getPre();
            Node after = x.getAfter();
            pre.setAfter(after);
            after.setPre(pre);
        }
        size--;
    }

    public void addFirst(Node x) {
        Node n = head;
        if (head==null){
            head=tail=x;
        }else{
            x.setPre(null);
            x.setAfter(n);
            n.setPre(x);
            head = x;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public Node removeLast() {
       Node node =tail;
       remove(tail);
       return node;

    }
}

public class LRUCache1 {

    private int capacity;
    HashMap<Integer, Node> map;
    DoubleList doubleList;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleList = new DoubleList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node x = map.get(key);
            doubleList.remove(x);
            doubleList.addFirst(x);
            return x.getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            Node node = map.get(key);
            map.replace(key, x);
            doubleList.remove(node);
        }else{
            if (capacity==doubleList.getSize()){
                Node tail = doubleList.getTail();
                map.remove(tail.getKey(),tail);
                Node last = doubleList.removeLast();
            }
        }
        doubleList.addFirst(x);
        map.put(key,x);
    }

    public static void main(String[] args) {
        LRUCache1 lruCache1 = new LRUCache1(2);
        lruCache1.put(1,1);
        lruCache1.put(2,2);
        lruCache1.get(1);
        lruCache1.put(3,3);
        lruCache1.get(2);
        lruCache1.put(4,4);
    }

}
