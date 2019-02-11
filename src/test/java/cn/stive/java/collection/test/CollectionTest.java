package cn.stive.java.collection.test;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class CollectionTest {

    @Test
    public void testAdd(){
        Set<Integer> set = new HashSet<Integer>();
//        add方法插入成功时返回true
        System.out.println(set.add(1)); // true
        System.out.println(set.add(1)); // false
    }

    @Test
    public void testRemove(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);

//      remove如果集合中有多个元素，只删除一个
        System.out.println(list.size()); //2
        list.remove(1);
        System.out.println(list.size()); //1
    }

    @Test
    public void testContainAll(){
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(2);
        list1.add(1);

        System.out.println(list1.containsAll(list2)); //true
    }

    @Test
    public void testAddLinkedList(){
        LinkedBlockingQueue<Integer>  queue = new LinkedBlockingQueue<>(1);
        queue.add(1);
        queue.add(1); //throw exception
    }

    @Test
    public void testRemoveObject(){
        Object a = new Object();
        Object b = a;
        a = null;
        System.out.println(b);
        System.out.println(a);
    }
}
