package com.jeeho.common.base.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class main {

    public static void main(String[] args){
        printFlieds();
    }

    public static void printFlieds(){
        //1.获取类的三种方式
        Class mClass = SonClass.class;
        System.out.println("类信息：" + mClass.getName());

//        Field[] fields = mClass.getFields();

        Field[] fields = mClass.getDeclaredFields();

        for (Field field : fields){
            //输入变量的访问权限
            int modifiers = field.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //输出变量的类型名称及变量名
            System.out.println(field.getType().getName() + " : " + field.getName());
        }
    }

    public static void printMethods(){

    }

}
