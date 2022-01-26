package Laicode.codework;

import javafx.beans.property.ReadOnlyObjectProperty;

import java.time.temporal.ChronoField;
import java.util.*;

public class coding {
//
//    public List<List<Integer>> nqueens(int n) {
//
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        int[] cur = new int[n];
//
//        boolean[] usedColumns = new boolean[n];
//        boolean[] usedDiagonals = new boolean[2 * n - 1];
//        boolean[] usedRevDiagonals = new boolean[2 * n - 1];
//        helper(n, 0, cur, res, usedColumns, usedDiagonals, usedRevDiagonals);
//        return res;
//    }
//
//    public void helper(int n, int row, int[] cur, List<List<Integer>> res, boolean[] usedColumns,
//                       boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
//        if (row == n) {
//            res.add(toList(cur));
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if (valid(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
//                mark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
//                cur[row] = i;
//                helper(n, row + 1, cur, res, usedColumns, usedDiagonals, usedRevDiagonals);
//                unmark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
//            }
//        }
//    }
//
//    public boolean valid(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals,
//                         boolean[] usedRevDiagonals) {
//        return !usedColumns[column] && !usedDiagonals[row + column] && !usedRevDiagonals[column - row + n - 1];
//    }
//
//    public void mark(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals,
//                     boolean[] usedRevDiagonals) {
//        usedColumns[column] = true;
//        usedDiagonals[column + row] = true;
//        usedRevDiagonals[column - row + n - 1] = true;
//    }
//
//    public void unmark(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals,
//                       boolean[] usedRevDiagonals) {
//        usedColumns[column] = false;
//        usedDiagonals[column + row] = false;
//        usedRevDiagonals[column - row + n - 1] = false;
//    }
//
//    public List<Integer> toList(int[] array) {
//        List<Integer> list = new ArrayList<>();
//
//        for (int num :
//                array) {
//            list.add(num);
//        }
//        return list;
//    }

    //TwoFarLeafNode
//    public class TreeNode{
//        public int key;
//        public TreeNode left;
//        public TreeNode right;
//        public TreeNode(int key){
//            this.key = key;
//        }
//    }
//
//    public int postOrder(TreeNode root, int[] res){
//        if (root == null){
//            return 0;
//        }
//        int leftSum = postOrder(root.left, res);
//        int rightSum = postOrder(root.right, res);
//        if (root.left != null && root.right != null){
//            res[0] = Math.max(root.key + leftSum + rightSum, res[0]);
//            return Math.max(root.key + leftSum, root.key + rightSum);
//        }
//
//        if (root.left == null){
//            return root.key + rightSum;
//        }
//        return root.key + leftSum;
//    }
//
//    public int maxPathsum(TreeNode root){
//        if (root == null || root.left == null || root.right == null){
//            return Integer.MIN_VALUE;
//        }
//        int[] res = {Integer.MIN_VALUE};
//        postOrder(root, res);
//
//        return res[0];
//    }

    //MinimalCutsToFormPalindrome
//    public  int mincut(String input){
//        if (input == null || input.length() <= 1){
//            return 0;
//        }
//        char[] array = input.toCharArray();
//        int n = array.length;
//        int[] M = new int[n + 1];
//        M[0] = 0;
//        M[1] = 0;
//
//        for (int i = 2; i < M.length; i++) {
//            int mincutforI = Integer.MAX_VALUE;
//            for (int j = 0; j < i; j++) {
//                if (isPalinedrome(array, j, i - 1)){
//                    if (j == 0){
//                        mincutforI = 0;
//                        break;
//                    }else {
//                        mincutforI = Math.min(mincutforI, M[j] + 1);
//                    }
//                }
//                M[i] = mincutforI;
//            }
//        }
//        return M[n];
//    }
//
//    public boolean isPalinedrome(char[] array, int i, int j){
//        while (i < j){
//            if (array[i] != array[j]){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }

    //PrintAlLif

//    public void helper(int leftRemain, int rightRemain, int index, char[] curr){
//        if (leftRemain == 0 && rightRemain == 0){
//            printBlocks(curr);
//            return;
//        }
//
//        if (leftRemain > 0){
//            curr[index] = '{';
//            helper(leftRemain - 1, rightRemain, index + 1, curr);
//        }
//
//        if (rightRemain > leftRemain){
//            curr[index] = '}';
//            helper(leftRemain, rightRemain - 1, index + 1, curr);
//        }
//    }
//
//    public void printSpace(int space){
//        while (space > 0){
//            System.out.println(" ");
//            space--;
//        }
//    }
//
//    public void printBlocks(char[] curr){
//        int space = 0;
//        for (int i = 0; i < curr.length; ++i) {
//            if (curr[i] == '{'){
//                printSpace(space);
//                System.out.println("if {");
//                space += 2;
//            }else {
//                space -= 2;
//                printSpace(space);
//                System.out.println("}");
//            }
//        }
//        System.out.println();
//    }
//
//    public void printBlocks(int n){
//        if (n < 0){
//            return;
//        }
//        char[] curr = new char[2 * n];
//        helper(n, n, 0, curr);
//    }

//    public String compress(String input){
//        if (input == null || input.length() <= 1){
//            return input;
//        }
//        char[] array = input.toCharArray();
//        return encode(array);
//    }
//
//    private String encode(char[] input){
//        int slow = 0;
//        int fast = 0;
//        int newLength = 0;
//        while(fast >= 0){
//            int begin = fast;
//            while (fast < input.length && input[fast] == input[begin]){
//                fast++;
//            }
//            input[slow++] = input[begin];
//            if (fast - begin == 1){
//                newLength += 2;
//            }else {
//                int len = copyDigits(input, slow, fast - begin);
//                slow += len;
//                newLength += len + 1;
//            }
//        }
//        char[] result = new char[newLength];
//        fast = slow - 1;
//        slow = newLength - 1;
//        while (fast >= 0){
//            if (Character.isDigit(input[fast])){
//                while (fast >= 0 && Character.isDigit(input[fast])){
//                    result[slow--] = input[fast--];
//                }
//            }else {
//                result[slow--] = '1';
//            }
//            result[slow--] = result[fast--];
//        }
//        return new String(result);
//    }
//
//    private int copyDigits(char[] input,  int index, int count){
//        int len = 0;
//        for (int i = count; i > 0 ; i/=10) {
//            len++;
//            index++;
//        }
//        for (int i = count; i > 0; i/=10) {
//            int digit = i % 10;
//            input[--index] = (char)('0' + digit);
//        }
//        return len;
//    }
//    public List<Integer> allAnagrams(String sh, String lo){
//        List<Integer> res = new ArrayList<>();
//        if (lo.length() == 0){
//            return res;
//        }
//        if (sh.length() > lo.length()){
//            return res;
//        }
//        Map<Character, Integer> map = countMap(sh);
//        int match = 0;
//        for (int i = 0; i < lo.length(); i++) {
//            char tmp = lo.charAt(i);
//            Integer count = map.get(tmp);
//            if (count != null){
//                map.put(tmp, count - 1);
//                if (count == 1){
//                    match++;
//                }
//            }
//            if (i >= sh.length()){
//                tmp = lo.charAt(i - sh.length());
//                count = map.get(tmp);
//                if (count != null){
//                    map.put(tmp, count + 1);
//                    if (count == 0){
//                        match--;
//                    }
//                }
//            }
//            if (match == map.size()){
//                res.add(i - sh.length() + 1);
//            }
//        }
//        return res;
//    }
//
//    private Map<Character, Integer> countMap(String s){
//        Map<Character, Integer> map = new HashMap<>();
//        for (char ch: s.toCharArray()){
//            Integer count = map.get(ch);
//            if (count == null){
//                map.put(ch, 1);
//            }else {
//                map.put(ch, count + 1);
//            }
//        }
//        return map;
//    }
    public boolean twosum(int[] array, int target){
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            int sum = array[left] + array[right];
            if (sum == target){
                return true;
            }else if (sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    public List<List<Integer>> twosumpairI(int[] array, int target){
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            if (indices != null){
                for (int j : indices) {
                    res.add(Arrays.asList(j, i));
                }
            }
            if (!map.containsKey(array[i])){
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }

    public List<List<Integer>> twosumpairII(int[] array, int target){
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            if (left > 0 && array[left] == array[left - 1]){
                left++;
                continue;
            }
            int cur = array[left] + array[right];
            if (cur == target){
                res.add(Arrays.asList(array[left], array[right]));
            }else if (cur < target){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

    public List<List<Integer>> Threesum(int[] array, int target){
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]){
                continue;
            }
            int left = 0;
            int right = array.length - 1;
            while (left < right){
                int cur = array[left] + array[right];
                if (cur + array[i] == target){
                    res.add(Arrays.asList(array[i],array[left],array[right]));
                    while (left < right && array[left] == array[left - 1]){
                        left++;
                    }
                }else if (cur + array[i] < target){
                    left++;
                }else {
                    right--;
                }

            }
        }
        return res;
    }

    public boolean FourSum(int[] array, int target){
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            for (int j = i + 1; j < array.length - 2; j++) {
                int left = j + 1;
                int right = array.length - 1;
                int cur = target - array[i] - array[j];
                while (left < right){
                    int sum = array[left] + array[right];
                    if (cur == sum){
                        return true;
                    }else if (cur < sum){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return false;
    }

    class Pair{
        int left;
        int right;
        Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    public boolean foursumII(int[] array, int target){
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int pairSum = array[i] + array[j];
                if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j){
                    return true;
                }
                if (!map.containsKey(pairSum)){
                    map.put(pairSum, new Pair(j, i));
                }
            }
        }
        return false;
    }
}
