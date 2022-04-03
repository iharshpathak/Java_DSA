package jav.ds.Queue;

import java.util.NoSuchElementException;

//11-03-2022
public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front = null;
        this.rear = null;
        length = 0;
    }

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }
    //Insert an element in a queue -> Enqueue operation
    public void enqueue(int data){
        ListNode temp = new ListNode(data);
        if(isEmpty()){
            front=temp;
        }else {
            rear.next=temp;
        }
        rear = temp;
        length++;
    }
    //print the elements of the queue
    public void print(){
        if(isEmpty()){
            return;
        }
        ListNode current = front;
        while (current != null){
            System.out.print(current.data+" --> ");
            current=current.next;
        }
        System.out.println("null");
    }

    //Remove element from a queue -> Dequeue operation
    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        int result = front.data;
        front=front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return result;
    }

    //return the first element
    public int first(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        return front.data;
    }
    //return the last element
    public int last(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        return rear.data;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(25);

        queue.print();

        //System.out.println(queue.dequeue());
        /*
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        */
        System.out.println(queue.first());
        System.out.println(queue.last());
    }
}
