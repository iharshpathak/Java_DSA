package jav.ds.LinkedList;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void display(){
        ListNode current =head;
        while(current!=null){
            System.out.print(current.data +" --> ");
            current=current.next;
        }
        System.out.println("null");
    }
    // Overloading display method 2.9.2021
    public void display(ListNode head){
        ListNode current =head;
        while(current!=null){
            System.out.print(current.data +" --> ");
            current=current.next;
        }
        System.out.println("null");
    }
    //length of a singly linked list - 29.8.2021
    public int length(){
        if(head==null){
            return 0;
        }
        int count=0;
        ListNode current = head;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }
    //Insert node at the begining of a singly linkedlist 29.8.2021
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next =head;
        head=newNode;
    }

    //Insert node at the end of a singly linkedlist 30.8.2021
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(head==null){
            head=newNode;
            return;
        }
        ListNode current =head;
        while(null!=current.next){
            current=current.next;
        }
        current.next=newNode;
    }

    //Insert a node at a given position in a singly linkedlist 30.8.2021
    public void insert(int position, int value){
        ListNode node = new ListNode(value);
        if(position==1){
            node.next=head;
            head=node;
        }
        else{
            ListNode previous = head;
            int count =1;
            while(count<position -1){
                previous = previous.next;
                count++;
            }
            ListNode current =previous.next;
            node.next=current;
            previous.next=node;

        }

    }

    // Delete first node of a singly linkedlist 31.8.2021
    public ListNode deleteFirst(){
        if(head==null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next=null;
        return temp;
    }

    // Delete last node of a singly linkedlist 1.9.2021
    public ListNode deleteLast(){
        if(head==null || head.next==null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current.next!=null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;

    }

    // Delete a node from a singly linkedlist at a given position
    public void delete(int position){
        if (position==1){
            head=head.next;
        }
        else {
            ListNode previous = head;
            int count =1;
            while (count < position -1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    //Search an element in a singly linkedlist 2.09.2021
    public boolean find(ListNode head, int searchKey){
        if(head==null){
            return false;
        }
        ListNode current = head;
        while(current != null){
            if(current.data == searchKey){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    //Reverse a singly linkedlist 02.9.2021
    public ListNode reverse() {
        if(head == null) {
            return null;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    //Find the middle node of a singly linkedlist 4.9.2021
    public ListNode getMiddleNode()
    {
        if(head==null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr= head;

        while(fastPtr !=null && fastPtr.next !=null){
            slowPtr = slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowPtr;
    }

    //Find the nth node from the end of a singly linkedlist 6.9.2021
    public ListNode getNthNodeFromEnd(int n){
        if(head == null){
            return  null;
        }
        if(n<=0){
            throw new IllegalArgumentException("Invalid value: n =" +n);
        }

        ListNode mainPtr = head;
        ListNode refPtr = head;

        int count =0;

        while(count < n){
            if(refPtr == null){
                throw new IllegalArgumentException(n + "is greater than the number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }

        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    //Remove duplicates from a sorted singly linkedlist
    public void removeDuplicates(){
        if (head == null){
            return;
        }
        ListNode current = head;
        while(current!= null && current.next !=null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            else {
                current=current.next;
            }
        }
    }

    //Insert a node in a sorted singly linkedlist 16.09.2021
    public ListNode insertInSortedList(int value){
        ListNode newNode = new ListNode(value);

        if(head == null){
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        while(current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;

        return head;

    }

    //Remove a key (value) from singly linkedlist
    public void deleteNode(int key){
        ListNode current = head;
        ListNode temp = null;
        if(current != null && current.data == key){
            head = current.next;
            return;
        }
        while(current != null && current.data != key){
            temp = current;
            current = current.next;
        }
        if(current == null){
            return;
        }
        temp.next = current.next;
    }

    // Detect a loop in a singly linked list
    public boolean containsLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr !=null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    public void createALoopInLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head=first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;
    }

    //Find the start of loop in a singly linked list
    public ListNode startNodeInALoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr=fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr ==  fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr != temp){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public void removeLoopFromLinkedList(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr !=null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr){
                removeLoop(slowPtr);
                return;
            }
        }
    }

    private void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr.next!= temp.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll= new SinglyLinkedList();
        //  sll.head=new ListNode(10);
        //  ListNode second=new ListNode(1);
        //  ListNode third= new ListNode(8);
        //  ListNode fourth=new ListNode(11);

        //  sll.head.next=second;
        //  second.next=third;
        // third.next=fourth;

     //   sll.insertFirst(16);
     //   sll.insertFirst(10);
     //   sll.insertFirst(8);
     //   sll.insertFirst(5);
     //   sll.insertFirst(1);

    //      sll.insertLast(11);
    //      sll.insertLast(8);
    //      sll.insertLast(1);
    //      sll.insertLast(10);

    //      sll.insert(1,3);
    //      sll.insert(2,5);
    //      sll.insert(1,2);
    //      sll.insert(2,4);
    //      sll.insert(5,7);

     //  sll.display();
        //System.out.println("The Length is -> "+sll.length());
       // System.out.println(sll.deleteFirst().data);
       // System.out.println(sll.deleteFirst().data);

       // System.out.println(sll.deleteLast().data);
       // System.out.println(sll.deleteLast().data);


    //   sll.delete(1);
    //   sll.delete(3);
    //   sll.delete(3);
    //   sll.display();

    /*    if(sll.find(sll.head, 1)){
            System.out.println("Search Key Found !");
        }
        else{
            System.out.println("Search Key Not Found !");
        }
    */

    /*    sll.display(sll.head);
        ListNode reverseListHead = sll.reverse();
        //Another way, comment the above line and uncomment this part -- >  sll.display(sll.reverse());
        sll.display(reverseListHead);
     */

     /*   ListNode middelNode = sll.getMiddleNode();
        System.out.println("Middle node is -> "+middelNode.data);
      */

       /* Another way, comment the above line and uncomment this part -- >
         System.out.println("Middle node is -> "+ sll.getMiddleNode().data);
        */

      /*  ListNode nthNodeFromEnd = sll.getNthNodeFromEnd(2);
        System.out.println("Nth node from end is -> "+ nthNodeFromEnd.data);
       */
      /*  sll.removeDuplicates();
        sll.display();
       */
       /* sll.insertInSortedList(11);
        sll.display();
        */
      /*  sll.deleteNode(10);
        sll.display();
       */

        sll.createALoopInLinkedList();
        System.out.println(sll.containsLoop());
        System.out.println(sll.startNodeInALoop().data);
        sll.removeLoopFromLinkedList();
        sll.display();
    }
}
