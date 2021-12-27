package Laicode.midExam;

/*
* Given an integer n, print/output all possible ways of writing n pairs of if blocks with correct indentation.

Say n=2 output should be

if {

}

if {

}


if {

if {// here should exist two spaces before each inner block

}

}
* */

public class PrintAllTheIf {

    private void helper(int leftRemain, int rightRemain, int index, char[] curr){
        //base case
        if (leftRemain == 0 && rightRemain == 0){
            printBlocks(curr);
            return;
        }

        if (leftRemain > 0){
            curr[index] = '{';
            helper(leftRemain - 1, rightRemain, index + 1, curr);
        }
        if (rightRemain > leftRemain){
            curr[index] = '}';
            helper(leftRemain, rightRemain - 1, index - 1, curr);
        }
    }

    public void printSpace(int n){
        while (n > 0){
            System.out.println(" ");
            n--;
        }
    }

    public void printBlocks(char[] curr){
        int space = 0;
        for (int i = 0; i < curr.length; ++i) {
            if (curr[i] == '{'){
                printSpace(space);
                System.out.println("if {");
                space += 2;
            }else{
                space -= 2;
                printSpace(space);
                System.out.println("}");
            }
        }
        System.out.println();
    }

    public void printBlocks(int n){
        if (n <= 0) return;
        char[] curr = new char[2 * n];
        helper(n, n, 0, curr);
    }

    public static void main(String[] args) {
        PrintAllTheIf p = new PrintAllTheIf();
        p.printBlocks(3);
    }
}

//Time Complexity:  O(2 ^ n)
//Space Complexity: o(2 x n)