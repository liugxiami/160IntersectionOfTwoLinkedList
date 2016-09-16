package com.ccsi;

public class Main {

    public static void main(String[] args) {
	    ListNode headA=buildListA();
        ListNode headB=buildListB();
        ListNode res=getIntersectionNode2(headA,headB);
        System.out.println(res.val);
    }
    //Write a program to find the node at which the intersection of two singly linked lists begins.
    //1.code too long.
    public static ListNode getIntersectionNode1(ListNode headA,ListNode headB){
        if(headA==null||headB==null)return null;
        ListNode pA=headA;
        int counterA=1;
        ListNode pB=headB;
        int counterB=1;
        while(pA!=null){
            pA=pA.next;
            counterA++;
        }while(pB!=null){
            pB=pB.next;
            counterB++;
        }

        pA=headA;
        pB=headB;
        if(counterA>counterB){
            int diff=counterA-counterB;
            for (int i = 0; i < diff; i++) {
               pA=pA.next;
            }
        }
        if(counterA<counterB){
            int diff=counterB-counterA;
            for (int i = 0; i < diff; i++) {
                pB=pB.next;
            }
        }

        int len=Math.min(counterA,counterB);
        for (int i = 0; i <len ; i++) {
            pA=pA.next;
            pB=pB.next;
            if(pA.val==pB.val)return pA;
        }
        return null;
    }
    //2.much better,but If the two linked lists have no intersection al all, endless loop.
    public static ListNode getIntersectionNode2(ListNode headA,ListNode headB){
        if(headA==null||headB==null)return null;
        ListNode pA=headA;
        ListNode pB=headB;

        while(pA!=null&&pB!=null){
            if(pA.val==pB.val)return pA;
            pA=pA.next;
            pB=pB.next;

            if(pA==null&&pB==null)return null;    //why error??本是为了跳出死循环
            if(pA==null)pA=headB;                 //交换A和B。A+B=B+A的长度
            if(pB==null)pB=headA;

        }
        return pA;
    }
    public static ListNode buildListA(){
        ListNode root=new ListNode(10);
        root.next=new ListNode(9);
        root.next.next=new ListNode(5);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(3);
        return root;
    }
    public static ListNode buildListB(){
        ListNode root=new ListNode(8);
        root.next=new ListNode(7);
        root.next.next=new ListNode(6);
        root.next.next.next=new ListNode(2);
        root.next.next.next.next=new ListNode(1);
        //root.next.next.next.next.next=new ListNode(3);
        return root;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next=null;
    }
}
