//返回链表的中间结点
    public Node middleNode(Node head) {
     Node cur=this.head;
     int len=getLeagth()/2;
     for (int i=0;i<len;i++){
         cur=cur.next;
     }
     return cur;
    }
