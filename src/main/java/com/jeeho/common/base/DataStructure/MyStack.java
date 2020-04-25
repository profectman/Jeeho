package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionStackEmpty;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionStackFull;
import com.jeeho.common.base.DataStructure.interfaces.Stack;

public class MyStack implements Stack {

    public static final int CAPACITY = 1024;
    protected int capacity = 0;
    protected Object[] S;
    protected int top = -1;

    public MyStack() {
        this(CAPACITY);
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        S = new Object[capacity];
    }

    @Override
    public int getSize() {
        return (top+1);
    }

    @Override
    public boolean isEmpty() {
        return (top<0);
    }

    @Override
    public void push(Object ele) {
        if (getSize() == capacity)
            throw new ExceptionStackFull("当前栈满!");
        S[++top] = ele;
    }

    @Override
    public Object pop() throws ExceptionStackEmpty {
        Object ele;
        if (isEmpty())
            throw new ExceptionStackEmpty("当前栈空!");
        ele = S[top];
        S[top--] = null;
        return ele;
    }

    @Override
    public Object top() throws ExceptionStackEmpty {
        Object ele;
        if (isEmpty())
            throw new ExceptionStackEmpty("当前栈空!");
        ele = S[top];
        return ele;
    }

    public static void main(String args[]){
        System.out.println(evalRPN("21+3*")+"");
    }

    public static Integer[] reverse(Integer[] a) {
        MyStack S = new MyStack(a.length);
        Integer[] b = new Integer[a.length];
        for (int i=0; i<a.length; i++) S.push(a[i]); //所有元素顺序入栈
        for (int i=0; i<a.length; i++) b[i] = (Integer) (S.pop()); //逆序退栈
        return b;
    }

    public static boolean paternMatch(String str){
        MyStack stack = new MyStack();
        str = str.trim();
        char[] chars = str.toCharArray();
        for (int i=0;i<str.length();i++){
            if (chars[i] == '(' || chars[i] == '[')
                stack.push(chars[i]);
            else{
                if (stack.isEmpty())
                    return false;
                else {
                    if (match((char)stack.top(),chars[i]))
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }

    public static boolean match(char open,char close){
        String opens = "([{";
        String closers = ")]}";
        return opens.indexOf(open) == closers.indexOf(close);
    }

    public static int evalRPN(String str){
        MyStack S = new MyStack();
        char[] chars = str.trim().toCharArray();
        String oper = "+-*/";
        for (int i=0;i<chars.length;i++){
            if (oper.indexOf(chars[i])<0)
                S.push(Integer.parseInt(chars[i]+""));
            else{
                int a = (int)S.pop();
                int b = (int)S.pop();
                switch (chars[i]){
                    case '+': S.push(a + b);break;
                    case '-': S.push(a - b);break;
                    case '*': S.push(a * b);break;
                    case '/': S.push(a / b);break;
                    default:break;
                }
            }
        }
        return (int)S.pop();
    }
}
