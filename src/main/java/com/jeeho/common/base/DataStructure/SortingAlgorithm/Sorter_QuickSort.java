package com.jeeho.common.base.DataStructure.SortingAlgorithm;

import com.jeeho.common.base.DataStructure.ComparatorDefault;
import com.jeeho.common.base.DataStructure.interfaces.Comparator;
import com.jeeho.common.base.DataStructure.interfaces.Sequence;

public class Sorter_QuickSort {

    Comparator C;

    public Sorter_QuickSort() {
        this(new ComparatorDefault());
    }

    public Sorter_QuickSort(Comparator c) {
        C = c;
    }

    public void  qsort(Sequence s , int lo , int hi){
        if ( lo > hi) return;

        int mi = createPivot(s,lo,hi);  //创造并获取中轴点

        qsort(s,lo,mi - 1);
        qsort(s,mi + 1,hi);
    }

    private int createPivot(Sequence s, int lo, int hi) {

        while (lo < hi && (C.compareTo(s.getAtRank(lo),s.getAtRank(hi)) <= 0)) hi--;
        swap (s,lo,hi);
        while (lo < hi && (C.compareTo(s.getAtRank(lo),s.getAtRank(hi)) <= 0)) lo++;
        swap(s,lo,hi);
        return lo;
    }

    private void swap(Sequence s, int lo, int hi) {
        Object elem = s.getAtRank(lo);
        s.insertAtRank(lo,s.getAtRank(hi));
        s.insertAtRank(hi,elem);
    }
}
