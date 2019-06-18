package com.lt.algorithm.linkedList;

/**
 * @author evolution
 * @title: DoubleLinkedListDemo
 * @projectName algorithm
 * @description: TODO
 * @date 2019-06-18 19:27
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 node1=  new HeroNode2(1,"宋江","及时雨");
        HeroNode2 node2= new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 node3=  new HeroNode2(3,"吴用","智多星");
        HeroNode2 node4= new HeroNode2(4,"林冲","豹子头");
        DoubleLinkedList singleLinkedList=   new DoubleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        singleLinkedList.list();

        HeroNode2 newHeroNode = new HeroNode2(4, "¹111", "22222");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.list();

        // É¾³ý
        singleLinkedList.del(3);
        System.out.println("删除");
        singleLinkedList.list();
    }


}

   class DoubleLinkedList{
    //创建一个空节点头
    private HeroNode2 head = new HeroNode2(0, "", "");

     // ·µ»ØÍ·½Úµã
     public HeroNode2 getHead() {
         return head;
     }

     public void list(){
         if (head.next == null) {
             System.out.println("空的");
             return;
         }
         HeroNode2 temp = head.next;
         while (true){
             if(temp==null){
                 break;
             }
             System.out.println(temp);
             temp=temp.next;
         }
     }
     public void add(HeroNode2 heroNode) {
         HeroNode2 temp = head;
         while (true){
             if(temp.next==null){
                 break;
             }
             temp = temp.next;
         }
         temp.next = heroNode;
         heroNode.pre=temp;

     }

     public void update(HeroNode2 newHeroNode) {
         if(head.next == null){
             System.out.println("空值");
             return ;
         }
         HeroNode2 temp =head.next;
         boolean flag =false;
         while(true){
             if(temp ==null){
                 break;
             }
             if(temp.no == newHeroNode.no){
                 flag=true;
                 break;
             }
             temp=temp.next;
         }
         if(flag){
             temp.name = newHeroNode.name;
             temp.name=newHeroNode.nickname;
         }else{
             System.out.printf("找不到该节点",newHeroNode.no);
         }

     }


     public void del(int no) {
         if(head.next ==null){
             System.out.println("");
             return;
         }
         HeroNode2 temp= head.next;
         boolean flag =false;
         while(true){
             if(temp == null){
                 break;
             }
             if(temp.no == no ){
                 flag = true;
                 break;
             }
             temp= temp.next;
         }

         if(flag){
             temp.pre.next= temp.next;
             if (temp.next != null) {
                 temp.next.pre = temp.pre;
             }
         }else {
             System.out.printf("未能找到对应编号\n", no);
         }

     }




     }


class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // Ö¸ÏòÏÂÒ»¸ö½Úµã, Ä¬ÈÏÎªnull
    public HeroNode2 pre; // Ö¸ÏòÇ°Ò»¸ö½Úµã, Ä¬ÈÏÎªnull
    // ¹¹ÔìÆ÷

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // ÎªÁËÏÔÊ¾·½·¨£¬ÎÒÃÇÖØÐÂtoString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}