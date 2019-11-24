//输入两个单链表，找出他们的第一个公共结点(地址相交)
    //同时出发 一人一步走
    public Node getIntersectionNode(Node headA,Node headB){
        if (headA==null || headB==null){
            return null;
        }
        int headALength=0;
        int headBLength=0;
        //pl永远指向最长的单链表
        Node pl=headA;
        //ps永远指向最短的单链表
        Node ps=headB;
       /* while (pl!=null){
            headALength++;
            pl=pl.getNext();
        }
        while (ps!=null){
            headBLength++;
            ps=ps.getNext();
        }*/
        //1.确定哪个单链表是长的单链表
        int myLen=headALength-headBLength;
        if (myLen<0){
            pl=headB;
            ps=headA;
            myLen=headBLength-headALength;
        }
        //2.让长的单链表走长度的差值
        for (int i=0;i<myLen;i++){
            //pl=pl.getNext();
        }
        //3.一人走一步
        while (pl!=null&&ps!=null&&pl!=ps){
            //pl=pl.getNext();
            //ps=ps.getNext();
        }
        if (pl!=null&&ps!=null&&pl==ps){
            return pl;
        }
        return null;
    }
