/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author aviat
 */
public class Ranks extends Node{
    public Ranks() {}
    public Ranks(Node center) {
        this.center = center;
    }
    LinkedList <Node> list = new LinkedList();
    Node center;
    public void addFirst(Node e) {
        list.addFirst(e);
    }
    public void addLast(Node e) {
        list.addLast(e);
    }
    public Node removeFirst() {
        if(list.size()==0){
            return null;
        }
        return list.removeFirst();
    }
    public Node removeLast() {
        if(list.size()==0){
            return null;
        }
        return list.removeLast();
    }
    public void add(int index,Node e) {
        if(index==1){
            addFirst(e);
        }
        else if(index == list.size()+1){
            addLast(e);
        }
        else{
            list.add(index-1, e);
        }
    }
    public void rank(Node e) {
        Node cake = e;
        for(int i = 1;i<=list.size();i++){
            if(Vector(cake,center)<Vector(get(i),center)){
                list.add(i-1,e);
                return;
            }
        }
        list.addLast(e);
    }
    public Node get(int x) {
        return list.get(x-1);
    }
    public int size() {
        return list.size();
    }
    public boolean QisEmpty() {
        return list.isEmpty();
    }
    public void vent() {
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i).bit+" ");
        }
    }
    public void ventadd() {
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i).address+" ");
        }
    }


    public static void main(String[] args) {
        /*Scanner key = new Scanner(System.in);
        Scanner keysupprime = new Scanner(System.in);
        Scanner donkey = new Scanner(System.in);
        Ranks fan = new Ranks();
        System.out.print("(1) Add First ");
        System.out.print("(2) Add Last ");
        System.out.print("(3) Remove First ");
        System.out.print("(4) Romove Last ");
        System.out.print("(5) vend ");
        System.out.println("(6) Add x ");
        for(;;){
            int y = key.nextInt();

            if(y==1){
                System.out.print("Give an element: ");
                int moo = keysupprime.nextInt();
                Node put = new Node(moo);
                fan.addFirst(put);
            }
            else if(y==2){
                System.out.print("Give an element: ");
                int moo = keysupprime.nextInt();
                Node put = new Node(moo);
                fan.addLast(put);
            }
            else if(y==3)
                fan.removeFirst();
            else if (y==4)
                fan.removeLast();
            else if (y==5)
                fan.vent();
            else if(y==6){
                System.out.print("Give an element: ");
                System.out.println("");
                int moo = keysupprime.nextInt();
                System.out.print("Give loc: ");
                int rho = donkey.nextInt();
                Node put = new Node(moo);
                fan.add(rho, put);
            }
            else if(y==7){
                System.out.print("Give loc: ");
                int rho = donkey.nextInt();
                System.out.println(fan.get(rho).bit);
            }
            System.out.print("(1) Add First ");
            System.out.print("(2) Add Last ");
            System.out.print("(3) Remove First ");
            System.out.print("(4) Romove Last ");
            System.out.print("(5) vend ");
            System.out.println("(6) Add x ");
        }*/
        Node Q = new Node();
        Q.End = 1000;
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.add(4);
        Q.add(5);
        Q = head;
        Node Alvin = Q;
        Node Bobby = Q.next;
        Node Charlie = Q.next.next;
        Node Daniel = Q.next.next.next;
        Node Elsa = Q.next.next.next.next;
        Ranks Rail = new Ranks(Alvin);
        Rail.rank(Daniel);
        Rail.rank(Elsa);
        Rail.rank(Bobby);
        Rail.rank(Alvin);
        Rail.rank(Charlie);
        Rail.vent();
        Rail.removeLast();
        Rail.removeLast();
        Rail.removeLast();
        Rail.removeLast();
        Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();Rail.removeLast();
        Rail.removeLast();
        Rail.vent();
    }
}
