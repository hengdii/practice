package com.jiaty.demo.leecode.once.intermediate;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: practice
 * @description: LRU缓存机制
 * @author: Jiaty
 * @create: 2021-04-15 15:23
 **/

public class LRUCache {


    class DequeLinkedNode {

        int key;
        int value;
        DequeLinkedNode prev;
        DequeLinkedNode next;

        public DequeLinkedNode() {
        }

        public DequeLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DequeLinkedNode> cache = new HashMap<>();
    private int size;
    private int capactity;
    private DequeLinkedNode head, tail;

    public LRUCache(int _capactity){
        this.size = 0;
        this.capactity = _capactity;
        //使用伪头部和伪尾部节点
        head = new DequeLinkedNode();
        tail = new DequeLinkedNode();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key){
        DequeLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DequeLinkedNode node = cache.get(key);
        if (node == null){
            //如果key不存在，那么就创建一个新节点
            DequeLinkedNode newNode = new DequeLinkedNode(key,value);
            //添加进哈希表
            cache.put(key,newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capactity){
                //如果超出容量，删除双向链表的尾部节点
                DequeLinkedNode tail = removeTail();
                //删除哈希表中的对应的项
                cache.remove(tail.key);
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }


    public void moveToHead(DequeLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(DequeLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DequeLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DequeLinkedNode removeTail(){
        DequeLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}