package com.lld.cache.algorithms;

public class DoublyLinkedListNode<E> {

    DoublyLinkedListNode<E> prev;
    DoublyLinkedListNode<E> next;
    E element;

    public DoublyLinkedListNode(E element){
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public DoublyLinkedListNode<E> getPrev() {
        return prev;
    }

    public DoublyLinkedListNode<E> getNext() {
        return next;
    }

    public E getElement() {
        return element;
    }

}
