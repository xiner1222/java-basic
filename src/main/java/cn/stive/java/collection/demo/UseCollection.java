package cn.stive.java.collection.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UseCollection {
    public static void main(String[] args){
        testContainAll();
    }

    public static void testAdd(){
        Set<Integer> set = new HashSet<Integer>();
//        add方法插入成功时返回true
        System.out.println(set.add(1)); // true
        System.out.println(set.add(1)); // false
    }

    public static void testRemove(){
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(list.add(1));
        System.out.println(list.add(1));
//        remove如果集合中有多个元素，只删除一个

        System.out.println(list.size()); //2
        list.remove(1);
        System.out.println(list.size()); //1
    }

    static void testContainAll(){
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(2);
        list1.add(1);

        System.out.println(list1.containsAll(list2));
    }
}
