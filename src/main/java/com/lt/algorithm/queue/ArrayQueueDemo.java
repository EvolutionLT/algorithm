package com.lt.algorithm.queue;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;

/**
 * @author Evolution
 * @title: ArrayQueueDemo
 * @projectName algorithm
 * @description: TODO
 * @date 2019/6/1511:27
 */
public class ArrayQueueDemo {
      public static void main(String args[]){
             ArrayQueue queue =new ArrayQueue(3);
             char key= ' ';
            Scanner scanner = new Scanner(System.in);
            boolean loop = true;
            while (loop){
                  System.out.println("s(show): 显示队列");
                  System.out.println("e(exit): 退出系统");
                  System.out.println("a(add): 添加队列数据");
                  System.out.println("g(get): 获取队列数据");
                  System.out.println("h(head): 获取队列头部数据");
                  key = scanner.next().charAt(0);
                  switch (key){
                        case 's':
                              queue.showQueue();
                              break;
                        case  'a':
                              System.out.println("输出一个数");
                              int value =scanner.nextInt();
                              queue.addQueue(value);
                              break;
                        case 'g':
                              try {
                                    int res=queue.getQueue();
                                    System.out.printf("取出的数据是%d\n",res);
                              }catch (Exception e){
                                    System.out.println(e.getMessage());
                              }
                              break;

                        case 'h':
                              //查看队列头的数据
                              try{
                                    int res =queue.headQueue();
                                    System.out.printf("取出队列头的数据是%d\n",res);
                              }catch (Exception e){
                                    System.out.println(e.getMessage());
                              }
                              break;
                        case 'e':
                              scanner.close();
                              loop=false;
                              break;


                        default:
                              break;
                  }
            }



            System.out.println("程序退出");


      }


    static  class ArrayQueue{
            //表示数组最大的容量
            private  int maxSize;
            //队列头
            private int front;
            //对列尾
            private int rear;
            //该数据用于存放数据 分析出front是指向队列头的一个位置
            private  int[] arr;

            //创建队列的构造器
            public ArrayQueue(int arrMaxSize){
                  maxSize=arrMaxSize;
                  arr=new int[maxSize];
                  front = -1;
                  rear = -1;
            }

            //判断队列是否已满
            public boolean isFull(){
                  return rear == maxSize-1;
            }

            //判断队列是否为空
            public  boolean isEmpty(){
                  return rear==front;
            }

            //添加数据到队列
            public void addQueue(int n){
                  //判断队列是否已满
                  if(isFull()){
                        System.out.println("队列已满！！！");
                  }
                  rear++;
                  arr[rear] = n;

            }

            //获取队列的数据 出队列
            public int getQueue(){
                  //判断队列是否为空
                  if(isEmpty()){
                        //抛出异常
                        throw new RuntimeException("队列为空无法取出数据！");
                  }
                  front++;
                  return arr[front];

            }

            //显示队列的所有数据
            public void showQueue(){
                  //遍历
                  if(isEmpty()){
                        System.out.println("队列空的 没有数据");
                        return ;
                  }
                  for(int i=0;i<arr.length;i++){
                        System.out.printf("arr[%d]=%d\n",i,arr[i]);
                  }
            }

            //显示队列的头数据 不是取出全部数据
            public int headQueue(){
                  //判断
                  if(isEmpty()){
                        //抛出异常
                        throw new RuntimeException("队列为空无法取出数据！");
                  }
                  return  arr[front+1];
            }


      }
}
