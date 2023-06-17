/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

/**
 *
 * @author aviat
 */
import java.util.LinkedList;
public class Queue <E>{
    LinkedList <E> list = new LinkedList();
    public void enqueue(E e) {
        list.addLast(e);
    }
    public void in(E e) {
        list.addLast(e);
    }
    public void add(E e) {
        list.addLast(e);
    }
    public E dequeue() {
        return list.removeFirst();
    }
    public E out() {
        return list.removeFirst();
    }
    public int size() {
        return list.size();
    }
    public boolean QisEmpty() {
        return list.isEmpty();
    }
    public static void main(String[] args) {
        Queue r = new Queue();
        r.add("Costantinople");
        r.add("Boston");
    }
}
