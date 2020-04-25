package com.jeeho.common.base.DataStructure;

import java.util.ArrayList;
import java.util.List;

public class MyStack01 {

    private List<Integer> data;

    public MyStack01() {
        this.data = new ArrayList<>();
    }

    public int getSize(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void push(int x){
        data.add(x);
    }

    public boolean pop(){
        if (isEmpty())
            return false;
        data.remove(data.size() -1);
        return true;
    }

    public int top(){
        return data.get(data.size() -1);
    }

    public int getMin() {
        if(data.isEmpty())
            return -1;

        int result = this.top();
        for(int i=data.size()-1;i>=0;i--){
            if(data.get(i)<result)
                result = data.get(i);
        }
        return result;
    }
}

