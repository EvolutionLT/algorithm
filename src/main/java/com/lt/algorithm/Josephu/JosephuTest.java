package com.lt.algorithm.Josephu;

/**
 * @author evolution
 * @title: JosephuTest
 * @projectName algorithm
 * @description: TODO
 * @date 2019-06-19 16:50
 * @ltd：思为
 */
public class JosephuTest {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);// ¼ÓÈë5¸öÐ¡º¢½Úµã
        circleSingleLinkedList.showBoy();

        //²âÊÔÒ»°ÑÐ¡º¢³öÈ¦ÊÇ·ñÕýÈ·
        circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3
    }
}


//环形单向链表
class CircleSingleLinkedList{
    private Boy first = null;
    //添加boy节点
    public void addBoy(int nums) {
        if(nums <1){
            System.out.println("节点值错误");
            return;
        }
        Boy curBoy= null;
        for(int i=1;i<=nums;i++){
            Boy boy = new Boy(i);
            if(i==1){
                first = boy;
                first.setNext(first);
                curBoy=first;
            }else{
                curBoy.setNext(boy);//
                boy.setNext(first);//
                curBoy = boy;
            }
        }

    }
    public void showBoy() {

        if (first == null) {
            System.out.println("头节点空置");
            return;
        }
        // ÒòÎªfirst²»ÄÜ¶¯£¬Òò´ËÎÒÃÇÈÔÈ»Ê¹ÓÃÒ»¸ö¸¨ÖúÖ¸ÕëÍê³É±éÀú
        Boy curBoy = first;
        while (true) {
            System.out.printf("Ð¡º¢µÄ±àºÅ %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {// ËµÃ÷ÒÑ¾­±éÀúÍê±Ï
                break;
            }
            curBoy = curBoy.getNext(); // curBoyºóÒÆ
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        // ÏÈ¶ÔÊý¾Ý½øÐÐÐ£Ñé
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("²ÎÊýÊäÈëÓÐÎó£¬ ÇëÖØÐÂÊäÈë");
            return;
        }
        // ´´½¨Òª¸ø¸¨ÖúÖ¸Õë,°ïÖúÍê³ÉÐ¡º¢³öÈ¦
        Boy helper = first;
        // ÐèÇó´´½¨Ò»¸ö¸¨ÖúÖ¸Õë(±äÁ¿) helper , ÊÂÏÈÓ¦¸ÃÖ¸Ïò»·ÐÎÁ´±íµÄ×îºóÕâ¸ö½Úµã
        while (true) {
            if (helper.getNext() == first) { // ËµÃ÷helperÖ¸Ïò×îºóÐ¡º¢½Úµã
                break;
            }
            helper = helper.getNext();
        }
        //Ð¡º¢±¨ÊýÇ°£¬ÏÈÈÃ first ºÍ  helper ÒÆ¶¯ k - 1´Î
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //µ±Ð¡º¢±¨ÊýÊ±£¬ÈÃfirst ºÍ helper Ö¸ÕëÍ¬Ê± µÄÒÆ¶¯  m  - 1 ´Î, È»ºó³öÈ¦
        //ÕâÀïÊÇÒ»¸öÑ­»·²Ù×÷£¬ÖªµÀÈ¦ÖÐÖ»ÓÐÒ»¸ö½Úµã
        while(true) {
            if(helper == first) { //ËµÃ÷È¦ÖÐÖ»ÓÐÒ»¸ö½Úµã
                break;
            }
            //ÈÃ first ºÍ helper Ö¸ÕëÍ¬Ê± µÄÒÆ¶¯ countNum - 1
            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //ÕâÊ±firstÖ¸ÏòµÄ½Úµã£¬¾ÍÊÇÒª³öÈ¦µÄÐ¡º¢½Úµã
            System.out.printf("有数据\n", first.getNo());
            //ÕâÊ±½«firstÖ¸ÏòµÄÐ¡º¢½Úµã³öÈ¦
            first = first.getNext();
            helper.setNext(first); //

        }
        System.out.printf("看不到数据 \n", first.getNo());

    }


    }

class Boy{
 private  int no;
 //下一个节点
 private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int bNo){
      this.no = bNo;
  }
}

