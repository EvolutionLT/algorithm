package com.lt.algorithm.stack;

import javax.sound.midi.Soundbank;

/**
 * @author evolution
 * @title: ArrayStack
 * @projectName algorithm
 * @description: TODO
 * @date 2019-06-20 19:40
 * @ltd：思为
 */
public class ArrayStack {
    //栈的大小
    private  int maxSize;
    private int [] stack;
    //栈顶 初始化为-1
    private  int top=-1;
    public ArrayStack(int size){
        maxSize=size;
        stack=new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    public void  push(int value){
        if(isFull()){
            System.out.println("栈已满！");
            return;

        }
        top+=1;
        stack[top]=value;

    }

    public int pop(){
        if(isEmpty())
            System.out.println("栈是空的");

            int value = stack[top];
            top -=1;
            return value;

    }

    public void list(){
        if(isEmpty()){
            System.out.println("栈是空的");
             return;
        }

        for(int i =top;i>=0;i--){
            System.out.println(stack[i]);
        }
    }


}
