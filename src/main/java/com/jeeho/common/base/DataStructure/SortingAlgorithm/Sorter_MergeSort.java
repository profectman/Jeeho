package com.jeeho.common.base.DataStructure.SortingAlgorithm;

import com.jeeho.common.base.DataStructure.ComparatorDefault;
import com.jeeho.common.base.DataStructure.Sequence_DLNode;
import com.jeeho.common.base.DataStructure.interfaces.Comparator;
import com.jeeho.common.base.DataStructure.interfaces.Iterator;
import com.jeeho.common.base.DataStructure.interfaces.Position;
import com.jeeho.common.base.DataStructure.interfaces.Sequence;

public class Sorter_MergeSort {

    private Comparator C;

    public Sorter_MergeSort() {
        this(new ComparatorDefault());
    }

    public Sorter_MergeSort(Comparator c) {
        C = c;
    }

    public void sort(Sequence S){
        int n = S.getSize();

        if (n <= 1) return;

        Sequence s1 = new Sequence_DLNode();
        Sequence s2 = new Sequence_DLNode();

        while (!S.isEmpty())  {
            s1.insertLast(S.remove(S.first()));
            if (!S.isEmpty())
                s2.insertLast(S.remove(S.first()));
        }

        sort(s1);
        sort(s2);
        merge(S,s1,s2);
    }

    private void merge(Sequence s, Sequence s1, Sequence s2) {
        while (!s1.isEmpty() || !s2.isEmpty()){
            Object e;

            if (s1.isEmpty())
                e = s2.remove(s2.first());
            else if (s2.isEmpty())
                e = s1.remove(s1.first());
            else if (0 < C.compareTo(s1.first().getElem(),s2.first().getElem()))
                e = s2.remove(s2.first());
            else
                e = s1.remove(s1.first());

            s.insertLast(e);
        }
    }

    public static void main(String args[]){
        Sorter_MergeSort sorter_mergeSort = new Sorter_MergeSort();
        Sequence_DLNode sequence_dlNode = new Sequence_DLNode();
        for (int i = 9 ;i>=0;i--)
            sequence_dlNode.insertLast(new Integer(i));
        sorter_mergeSort.sort(sequence_dlNode);
        Iterator elements = sequence_dlNode.elements();
        while (elements.hasNext())
            System.out.println(((Position)elements.getNext()).getElem());
    }
}
