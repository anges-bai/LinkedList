* @Description:带头结点的单链表
 */
public class SingleLinkedList {
    public class Node{
        private Object data;
        private Node next;
        public Node(){

        }
        Node(Object data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    //内部类Node，Node实例代表链表节点
    private Node header;
    private Node tail;
    private int size;

    public SingleLinkedList(){
        this.header=null;
        this.tail=null;
        this.size=0;
    }
    public SingleLinkedList(Object Telement){
        this.header=new Node(Telement,null);
        this.tail=this.header;
        this.size++;
    }
    public int length(){

        return this.size;
    }
      //获取指定元素
    public Object get(int index) {
        Node node = this.getNodeByIndex(index);
        return node == null ? null : node.data;
    }
    private Node getNodeByIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node curr = this.header;
        for (int i = 0; i < this.size && curr != null; i++, curr = curr.next) {
            if (i == index) {
                return curr;
            }
        }
        return null;
    }
    //查找指定元素
    public int locate(Object element) {
        Node curr = this.header;
        for (int i = 0; i < this.size && curr != null; i++, curr = curr.next) {
            if (curr.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }
    //向指定位置插入元素
    public void insert(Object element, int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
         //空链表
        if (this.header == null) {
            this.add(element);
        } else {
            //插⼊链表头
            if (index == 0) {
                addAtHeader(element);
            } else {
                Node preNode = this.getNodeByIndex(index - 1);
                if (preNode == null) {
                    throw new IllegalArgumentException("index=" +
                            (index - 1) + " not found node.");
                }
                preNode.next =
                        new Node(element, preNode.next);
                this.size++;
            }
        }
    }

     //采⽤尾插⼊法为链表添加新节点

    public void add(Object element) {
        if (this.header == null) {
            this.header = new Node(element, null);
            this.tail = this.header;
        } else {
            //创建新节点
            Node newNode = new Node(element, null);
           //新节点作为尾节点
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    //采⽤头插⼊法为链表添加新节点

    public void addAtHeader(Object element) {
        this.header = new Node(element, header);
        if (this.tail == null) {
            this.tail = this.header;
        }
        this.size++;
    }

     //删除链表中指定索引处的元素

    public Object delete(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node delNode;
        if (index == 0) {
            delNode = this.header;
            this.header = this.header.next;
        } else {
            Node preNode = this.getNodeByIndex(index - 1);
            if (preNode == null) {
                throw new IllegalArgumentException("index=" + (index - 1) + " ");
            }
             //获取删除的节点
            delNode = preNode.next;
            //让删除节点的上⼀个节点的next指向删除节点的next
            preNode.next = delNode.next;
            delNode.next = null;
        }
        this.size--;
        return delNode.data;
    }

    //删除链表中最后⼀个元素

    public Object remove() {

        return this.delete(this.size - 1);
    }

     // 判断链表是否为空

    public boolean empty() {

        return this.size == 0;
    }

     //清空链表
    public void clear() {
        this.header = null;
        this.tail = null;
        this.size = 0;
    }
    @Override
    public String toString() {
        if (this.empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (Node curr = this.header; curr != null; curr = curr.next) {
            sb.append(curr.data.toString()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
    public Node reverse(Node head){
        Node reverseHead=null;
        Node pre=null;
        Node cur=header;
        while (cur!=null){
            Node curNext=cur.next;
            if (curNext==null){
                reverseHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return reverseHead;
    }


    public static void main(String[] args) {
        SingleLinkedList  list = new
                SingleLinkedList();
        list.add("Java");
        list.add("C++");
        list.add("Python");
        list.add("PHP");
        list.add("Go");
        System.out.println("List内容");
        System.out.println(list);
        //在索引1处插⼊⼀个新元素
        System.out.println("index=1处插⼊新元素");
        list.insert("New Element", 1);
        System.out.println(list);
        //删除索引为2处的元素
        System.out.println("index=2处删除元素");
        list.delete(2);
        System.out.println(list);
        //元素Java的位置
        System.out.println("Java在List中的位置：");
        System.out.println(list.locate("Java"));
        list.reverse(list.header);
        System.out.println(list);

    }
