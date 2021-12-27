package Laicode.midExam;

/*
* Given a string, a partitioning of the string is a palindrome partitioning if every partition is a palindrome.
    For example, “aba |b | bbabb |a| b| aba” is a palindrome partitioning of “ababbbabbababa”.
    Determine the fewest cuts needed for palindrome partitioning of a given string.
    For example,
    minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a | babbbab | b | ababa”.
    If a string is palindrome, then minimum 0 cuts are needed.
    Return the minimum cuts.
* */

public class MinimalCutsToFormPalindrome {

    public static int minCut(String input){
        if (input == null || input.length() <= 1){
            return 0;
        }
        char[] array = input.toCharArray();
        int n = array.length;
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i < M.length; i++) {
            int mincutforI = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPanlinedrome(array, j, i - 1)){
                    if (j == 0){
                        mincutforI = 0;
                        break;
                    }else {
                        mincutforI = Math.min(mincutforI, M[j] + 1);
                    }
                }
            }
            M[i] = mincutforI;
        }
        return M[n];
    }

    private static boolean isPanlinedrome(char[] array, int i, int j){
        while (i < j){
            if (array[i] != array[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int res = minCut("abcdc");
        System.out.println(res);
    }
}

//Time Complexity:  O(n ^ 2)
//Space Complexity: o(n ^ 2)