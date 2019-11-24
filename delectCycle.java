//判断是否为环
    //fast走两步走三步的区别？
    public boolean hasCycle(){
        Node fast=this.head;
        Node slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                break;
            }
        }
        if (fast!=null&&slow!=null&&fast==slow){
            return true;
        }
        return false;
    }
    //给定一个链表，返回第一个环，若没有环，则返回null
    public Node detectCycle(Node head){
        Node fast=this.head;
        Node slow=this.head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                break;
            }
        }
        if (fast==null || fast.next==null){
            return null;
        }
        slow=this.head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
            }
            return slow;
    }
