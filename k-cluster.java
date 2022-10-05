class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k<=1){
            return head;
        }
        int count = getLength(head)/k;
        ListNode prev=null;
        ListNode current=head;
        
        while (count>0){
            ListNode last = prev;
            ListNode newEnd = current;
            
            ListNode next =current.next;

            for (int i = 0; current!=null && i < k; i++) {
                current.next=prev;
                prev=current;
                current=next;
                if (next!=null){
                    next=next.next;
                }
            }
            if (last!=null){
                last.next=prev;
            } else {
                head=prev;
            }
            newEnd.next=current;
            prev=newEnd;
            count--;
        }
        return head;
    }
    
      public int getLength(ListNode node){
        int length=0;
        while (node!=null){
            length++;
            node=node.next;
        }
        return length;
    }

}
           
