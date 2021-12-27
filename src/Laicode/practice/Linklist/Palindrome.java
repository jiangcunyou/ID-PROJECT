package Laicode.practice.Linklist;

public class Palindrome {

    public Boolean Ispalindrome(ListNode head){

        if (head == null || head.next == null){

            return true;
        }

        Findmiddle fm = new Findmiddle();
        Reverse re = new Reverse();

        ListNode middle = fm.findmid(head);
        ListNode right = re.reverse(middle);

        while (right != null){

            if (head.value != right.value){
                return false;
            }

            head = head.next;
            right = right.next;
        }

        return true;
    }


}
