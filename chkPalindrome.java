//判断回文结构
    public boolean chkPalindrome(){
        if (this.head==null){
            return false;
        }else if (this.head.next==null){
            return true;
        }
        Node fast=this.head;
        Node slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next.next;
        }
        Node p=slow.next;
        Node p1=p.next;
        while (p!=null) {
            p.next = slow;
            slow = p;
            p = p1;
            if (p1 != null) {
                p1 = p1.next;
            }
        }
            while (slow!=this.head){
                if (slow.data!=this.head.data){
                    return false;
                }
                //偶数结点
                if (this.head.next==slow){
                    return true;
                }
                this.head=this.head.next;
                slow=slow.next;
            }

        return true;
    }
