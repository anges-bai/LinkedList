 //删除链表中重复的结点
    //不重复的结点串成一个新的单链表返回 对比cur.data->cur.next.data
    public Node deleteDuplication(){
        Node newHead=new Node(-1);//虚拟结点
        Node tmpHead=newHead;
        Node cur=this.head;
        while (cur!=null){
        if (cur.data!=cur.next.data){
            newHead.next=cur;
            newHead=cur;
            cur=cur.next;
        }
        if (cur.next!=null&&cur.data==cur.next.data){
            while (cur.next!=null&&cur.data==cur.next.data){
                cur=cur.next;
            }
            cur=cur.next;
            newHead.next=cur;
        }
        }
        return tmpHead.next;
    }
