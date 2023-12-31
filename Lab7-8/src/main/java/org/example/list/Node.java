package org.example.list;

import org.example.armor.Armor;

public class Node {
    private Armor data;
    private Node prev;
    private Node next;

    public Node() {
    }

    public Node(Armor data) {
        this.data = data;
    }

    public void setData(Armor data) {
        this.data = data;
    }

    public Armor getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
