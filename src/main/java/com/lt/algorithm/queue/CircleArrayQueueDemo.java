package com.lt.algorithm.queue;

import java.util.Scanner;

/**
 * @author Evolution
 * @title: CircleArrayQueueDemo
 * @projectName algorithm
 * @description: TODO
 * @date 2019/6/1616:18
 */
public class CircleArrayQueueDemo {
      public  static void main(String [] args){
            System.out.println("测试数据模拟环形案例");
            CirecleArray queue =new CirecleArray(3);
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



    static  class CirecleArray {
            //表示数组的最大容量
            private int maxSize;

            private int front;

            private int rear;

            private int[] arr;

            public CirecleArray(int arrMaxSize) {
                  maxSize = arrMaxSize;
                  arr = new int[maxSize];
            }

            //判断队列是否满
            public boolean isFull() {
                  return (rear + 1) % maxSize == front;
            }

            //判断队列是否为空
            public boolean isEmpty() {
                  return rear == front;
            }

            public void addQueue(int n) {
                  //判断队列是否满
                  if (isFull()) {
                        System.out.println("队列满 不能加入数据");
                        return;
                  }
                  //直接将数据加入
                  arr[rear] = n;
                  //将rear 后移 这里必须考虑取模
                  rear = (rear + 1) % maxSize;


            }

            //获取队列的数据,出队列
            public int getQueue() {
                  //判断队列是否空
                  if (isEmpty()) {
                        //抛出异常
                        throw new RuntimeException("队列空 不能取数据");
                  }

                  //这里需要分析出front是指向队列的第一个元素
                  //1.先把front 对象的值保留到一个临时变量
                  //2.将front 后移 考虑取模
                  //3.将临时保存的变量返回
                  int value = arr[front];
                  front = (front + 1) % maxSize;
                  return value;

            }

            //显示队列的所有数据
            public void showQueue(){
                  //遍历
                  if(isEmpty()){
                        System.out.println("队列空的 没有数据");
                        return ;
                  }
                  for(int i=front;i<front + size();i++){
                        System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i]);
                  }
            }

         //求出当前队列有效数据
            public int size(){
                  return (rear + maxSize -front) % maxSize;
            }

            //显示队列的头数据 不是取出全部数据
            public int headQueue(){
                  //判断
                  if(isEmpty()){
                        //抛出异常
                        throw new RuntimeException("队列为空无法取出数据！");
                  }
                  return  arr[front];
            }


      }

}


