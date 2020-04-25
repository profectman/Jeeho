package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.Entry;

public class EntryDefault implements Entry {

    private Object key;
    private Object value;

    public EntryDefault(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Object getKey() {
        return key;
    }

    @Override
    public Object setKey(Object key) {
        Object objKey = key;
        this.key = key;
        return objKey;
    }

    @Override
    public Object setValue(Object value) {
        Object oldValue = value;
        this.value = value;
        return oldValue;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
