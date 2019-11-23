//反转链表
    public Node reverseList(Node head) {
        Node reverseHead=null;
        Node prev=null;
        Node cur=this.head;
        while (cur!=null){
            Node curNext=cur.next;
            if (curNext==null){
                reverseHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return reverseHead;
    }
