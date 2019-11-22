//返回倒数第k个结点
    public Node findKthToTail(int k){
        Node fast=this.head;
        Node slow=this.head;

        if (fast==null || k<0 || k>getLeagth()){
            return null;
        }
        //fast先走k-1步
        while (k-1>0){
            fast=fast.next;
            k--;
        }
        //fast slow 一起走，当fast.next=null时，返回slow
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
