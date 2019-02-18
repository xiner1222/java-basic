package cn.stive.java.collection.test;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {

    @Test
    public void testAddFirst(){
        Queue<String> arrayQueue = new ArrayDeque<>();
        ((ArrayDeque<String>) arrayQueue).addFirst("1");
        ((ArrayDeque<String>) arrayQueue).addFirst("2");
        System.out.println(arrayQueue);
    }
}
