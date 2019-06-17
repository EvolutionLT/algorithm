package com.lt.algorithm.linkedList;

/**
 * @author Evolution
 * @title: HeroNode
 * @projectName algorithm
 * @description: TODO
 * @date 2019/6/1722:50
 */
public class HeroNode {
      int no;
      String name;
      String nickName;
      HeroNode next;
      //构造器
      public HeroNode(int hno,String name, String nickName){
            this.no=hno;
            this.name=name;
            this.nickName=nickName;
      }

      @Override
      public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", next=" + next +
                    '}';
      }
}
