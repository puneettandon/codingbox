package com.lld.cache.algorithms;

import com.lld.cache.algorithms.exceptions.InvalidElementException;
import com.lld.cache.algorithms.exceptions.InvalidNodeException;


public class DoublyLinkedList <E>{

    DoublyLinkedListNode<E> first;
    DoublyLinkedListNode<E> last;

    public DoublyLinkedList(){
        first = null;
        last = null;
    }


    public void detachNode(DoublyLinkedListNode<E> node){
        if(node == null){
            return;
        }
        if(node.equals(first)){
            first = first.next;
            if(first  != null ){
                first.prev = null;
            }
        }else if(node.equals(last)){
            last = last.prev;
            if(last.next != null){
                last.next = null;
            }
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node){
        if(node == null){
            throw new InvalidNodeException();
        }
        if(last == null){
            last = node;
            first = node;
        }else{
            last.next = node;
            node.prev = last;
            node.next = null;
            last = node;
        }
    }

    public  DoublyLinkedListNode<E> addElementAtLast(E element){
        if(element == null){
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public DoublyLinkedListNode<E> getFirst() {
        return first;
    }

    public DoublyLinkedListNode<E> getLast() {
        return last;
    }

}
