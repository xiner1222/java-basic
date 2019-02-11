package cn.stive.java.collection.demo;

import javax.xml.bind.Element;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>,Deque<E>,Serializable {

    private Node<E> head;

    private Node<E> last;

//    修改次数
    private volatile int modCount = 0;

    private int size;

    private class Node<E>{
        private E element;
        private Node<E> pre;
        private Node<E> next;

        public Node(E e, Node pre, Node next){
            this.element = e;
            this.pre = pre;
            this.next = next;
        }
    }

    public LinkedList(){
    }

    public LinkedList(Collection list){
        this();
        addAll(list);
    }


    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }


    @Override
    public void addFirst(E e) {
        Node first = head;

        Node<E> newNode = new Node<>(e, null, first);
        head = newNode;
        if(first == null){
            last = newNode;
        }else{
            head.pre = newNode;
        }
        size ++;
        modCount++;
    }

    @Override
    public void addLast(E e) {
        Node lastNode = last;
        Node<E> newNode = new Node<>(e, last, null);
        last = newNode;
        if (lastNode == null) {
            head = newNode;
        }else{
            last.next = newNode;
        }
        size ++;
        modCount ++;
    }
//offer和add的区别，add操作当队列中满时会抛出异常，链表不存在这个问题。
    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }
//remove和poll的区别，都是移除队首元素，remove移除队列为空会抛异常。
    @Override
    public E removeFirst() {
        if(head == null){
            throw new NoSuchElementException();
        }
        return unlinkFirst();
    }

    private E unlinkFirst(){
        final E e = head.element;
        final Node next = head.next;
        head.element = null;
        head.next = null;
        head = next;
        if(next == null){
            head = null;
        }else{
            head.pre = null;
        }
        modCount ++;
        size --;
        return e;
    }

    @Override
    public E removeLast() {
        if(last == null){
            throw new NoSuchElementException();
        }
        return unlinkeLast(last);
    }

    private E unlinkeLast(Node e){
        E item = last.element;
        Node pre = last.pre;
        last.element = null;
        last.pre = null;
        last = pre;
        if(pre == null){
            last = null;
        }else{
            pre.next = null;
        }
        modCount ++;
        size --;
        return item;
    }

    @Override
    public E pollFirst() {
        final Node node = head;
        return (node == null) ? null : unlinkeLast(node);
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }
//查询第一个元素，不存在报异常。
    @Override
    public E element() {
        return null;
    }
//查询第一个元素。
    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}
