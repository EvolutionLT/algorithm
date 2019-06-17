package com.lt.algorithm.linkedList;

/**
 * @author Evolution
 * @title: SingleLinkedList
 * @projectName algorithm
 * @description: TODO
 * @date 2019/6/1722:53
 */
public class SingleLinkedListDemo {
      public static void  main(String [] args){
            HeroNode node1=  new HeroNode(1,"宋江","及时雨");
            HeroNode node2= new HeroNode(2,"卢俊义","玉麒麟");
            HeroNode node3=  new HeroNode(3,"吴用","智多星");
        HeroNode node4= new HeroNode(4,"林冲","豹子头");
      SingleLinkedList singleLinkedList=   new SingleLinkedList();
      singleLinkedList.add(node1);
            singleLinkedList.add(node2);
            singleLinkedList.add(node3);
            singleLinkedList.add(node4);
            singleLinkedList.list();
      }


      static class  SingleLinkedList{
       //初始化一个头结点 头结点不要动
            private HeroNode head =new HeroNode(0,"","");

            //添加节点到单向链表
            //思路 当不考虑顺序时
            public void add(HeroNode heroNode){
                  HeroNode temp = head;
                 while (true){
                       if(temp.next==null){
                             System.out.println("链表为空1");
                             break;
                       }
                       temp=temp.next;
                       //当退出循环是 temp指向了链表最后的结点
                 }
                  temp.next=heroNode;
            }

            public  void list(){
                  if(head.next==null){
                        System.out.println("链表为空");
                        return;
                  }
                  HeroNode temp = head.next;
                  while(true){
                        if(temp==null){
                              break;
                        }
                        System.out.println(temp);
                        temp=temp.next;
                  }
            }


      }
}
