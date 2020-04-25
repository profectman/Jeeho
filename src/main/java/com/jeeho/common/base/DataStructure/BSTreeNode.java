package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.BinTreePosition;
import com.jeeho.common.base.DataStructure.interfaces.Entry;

/**
 * 二分查找树--节点
 */
public class BSTreeNode extends BinTreeNode implements BinTreePosition,Entry {

    public BSTreeNode() {
        super();
    }

    public BSTreeNode(BinTreePosition p, BinTreePosition l, BinTreePosition r, boolean isLChild, Object elem) {
        super(p, l, r, isLChild, elem);
    }

    @Override
    public Object getKey() {
        return ((Entry)getElem()).getKey();
    }

    @Override
    public Object setKey(Object key) {
        return ((Entry)getElem()).setKey(key);
    }

    @Override
    public Object setValue(Object value) {
        return ((Entry)getElem()).setValue(value);
    }

    @Override
    public Object getValue() {
        return ((Entry)getElem()).getValue();
    }
}
