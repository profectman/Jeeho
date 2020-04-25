package com.jeeho.common.base.collection.LinkedList;

import java.util.Stack;

public class Solution {

    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){
        ListNode head = new ListNode(5);
        for (int i=4;i>0;i++){
            head.next = new ListNode(i);
        }

        ListNode newList = null;
        Stack stack = new Stack();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()){
            if(newList == null)
                newList = new ListNode((int)(stack.pop()));
            else
                newList.next = new ListNode((int)(stack.pop()));
        }
        System.out.println(newList.val);
    }
}
