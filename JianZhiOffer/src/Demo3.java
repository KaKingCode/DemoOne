import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList.
 * @since JDK 1.8
 */
public class Demo3 {
    /**
     * 方法1,进行栈存储
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> st = new Stack<Integer>();
        while(listNode!=null){
            st.add(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> array =  new ArrayList<Integer>();
        while(!st.empty()){
            array.add(st.peek());
            st.pop();
        }
        return array;
    }

    /**
     * 方法2,递归,从尾部
     * @param listNode
     * @return
     */
    ArrayList<Integer> array =  new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode){
        if(listNode!=null){
            printListFromTailToHead1(listNode.next);
            array.add(listNode.val);
        }
        return array;
    }
    public class ListNode {
             int val;
             ListNode next = null;

            ListNode(int val) {
                 this.val = val;
             }
         }

}

