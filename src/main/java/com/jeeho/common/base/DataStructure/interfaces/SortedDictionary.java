package com.jeeho.common.base.DataStructure.interfaces;

public interface SortedDictionary extends Dictionary {

    Entry first();

    Entry last();

    Iterator predecessors(Object key);

    Iterator successors(Object key);
}
