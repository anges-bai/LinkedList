//以给定值x为基准将链表分为两部分，小于x的在x左边，大于x的在x的右边
    public Node partition(int x){
        Node beforestart=null;
        Node beforeend=null;
        Node afterstart=null;
        Node afterend=null;
        Node PHead=this.head;
        while (PHead!=null) {
            Node PHeadNext=PHead.next;
            PHead.next=null;
            if (PHead.data < x) {
                //尾插
                if (beforestart == null) {
                    beforestart = PHead;
                    beforeend = beforestart;
                } else {
                    beforeend.next = PHead;
                    beforeend = beforeend.next;
                }
            }else{
                if (afterstart==null){
                    afterstart=PHead;
                    afterend=afterstart;
                }else {
                    afterend.next=PHead;
                    afterend=afterstart.next;
                }
            }
            //防止内存泄漏
            PHead=PHeadNext;
        }
        //第一段没有数据
        if (beforestart==null){
            return afterstart;
        }
        beforeend.next=afterstart;
        return beforestart;
    }
