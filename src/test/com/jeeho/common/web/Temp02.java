package com.jeeho.common.web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Temp02 extends TempTest {

    static {
        System.out.println("Temp 02 static ");
    }

    public Temp02() {
//        super();
        System.out.println("Temp02 ");
    }

    public static void main(String args[]){
        Temp02 tt = new Temp02();
        tt.print();
        Map map = new HashMap();
        map.put(null,"1");
        Set set = new HashSet();
        System.out.println(map.get(null));
    }

    @Override
    public void print() {
        System.out.println("Temp02 print");
    }
}
