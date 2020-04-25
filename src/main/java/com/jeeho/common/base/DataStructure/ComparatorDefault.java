package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.Comparator;

/**
 * 比较结构的默认实现
 */
public class ComparatorDefault implements Comparator {

    public ComparatorDefault() {
    }

    @Override
    public int compareTo(Object a, Object b) {
        return ((Comparable)a).compareTo(b);
    }
}
