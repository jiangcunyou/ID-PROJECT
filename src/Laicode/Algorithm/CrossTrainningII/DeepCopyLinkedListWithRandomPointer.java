package Laicode.Algorithm.CrossTrainningII;

/*
* Each of the nodes in the linked list has another pointer pointing to a random node
* in the list or null. Make a deep copy of the original list.
* */

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedListWithRandomPointer {
    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        if(head == null){
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null){
            if (!map.containsKey(head)){
                map.put(head, new RandomListNode(head.value));
            }
            cur.next = map.get(head);
            if (head.random != null){
                if (!map.containsKey(head.random)){
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
