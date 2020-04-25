package com.jeeho.common.base.DataStructure.InterviewAlgorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0];

        Deque<Integer> deque = new ArrayDeque<>();
        ListNode curNode = head;
        while (curNode != null){
            deque.addLast(curNode.val);
            curNode = curNode.next;
        }

        int size = deque.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            result[i] = deque.removeLast();
        }
        return result;
    }

  public class ListNode{
        int val;
        ListNode next;

      public ListNode(int val) {
          this.val = val;
      }
  }
}
