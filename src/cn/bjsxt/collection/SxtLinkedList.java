package cn.bjsxt.collection;

import java.util.LinkedList;


public class SxtLinkedList /*implements List*/ {
	private Node first;//第一个节点
    private Node last;//最后一个节点
    private int size;

    public SxtLinkedList() {
    }

    public void add(Object object){
        Node node = new Node();
        if (first == null){
            node.previous = null;
            node.object = object;
            node.next = null;
            first = node;
            last = node;
        } else {//first不为空直接往last上面加
            node.previous = last;
            node.object = object;
            node.next = null;
            last.next = node;
            last = node;
        }
        size++;
    }

    public int size(){
        return size;
    }
    public void rangeCheck(int index){
        if (index < 0 || index >= size){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public Object get(int index){
        rangeCheck(index);
        Node temp = node(index);
        if (temp != null){
            return temp.object;
        }
        return null;
    }

    public Node node(int index){
        Node temp = null;
        if (first != null){
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        return temp;
    }

    public void remove(int index){
        rangeCheck(index);
        Node temp = node(index);
        if (temp != null){
            Node preCur = temp.previous;
            Node nextCur = temp.next;
            preCur.next = nextCur;
            nextCur.previous = preCur;
            size--;
        }
    }

    public void add(int index, Object object){
        rangeCheck(index);
        Node node = new Node();
        node.object = object;
        Node temp = node(index);
        if (temp != null){
            Node preCur = temp.previous;
            preCur.next = node;
            node.previous = preCur;
            node.next = temp;
            temp.previous = node;
            size++;
        }
    }

    public static void main(String[] args) {
        SxtLinkedList sxtLinkedList = new SxtLinkedList();
        sxtLinkedList.add("111");
        sxtLinkedList.add("222");
        sxtLinkedList.add("333");
        sxtLinkedList.remove(1);
        System.out.println(sxtLinkedList.size());
        sxtLinkedList.add(1,"222");
        System.out.println(sxtLinkedList.size());
        System.out.println(sxtLinkedList.get(1));

    }
}
