package Laicode.Algorithm.DFSII;

/*
* Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output integer array satisfy this condition:

Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two 2's there are two numbers).

If there does not exist such sequence, return null.

Assumptions:

k is guaranteed to be > 0
Examples:

k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
* */

public class KeepDistanceForIdenticalElements {
    public int[] keepDistance(int k) {
        // Write your solution here.
        int[] array = new int[2 * k];
        for (int i = 0; i < k; i++) {
            array[i * 2] = i + 1;
            array[i * 2 + 1] = i + 1;
        }
        boolean[] used = new boolean[k + 1];

        return helper(array, 0, used) ? array : null;
    }

    private boolean helper(int[] array, int index, boolean[] used){
        if (index == array.length){
            return true;
        }
        for (int i = index; i < array.length; i++) {
            int cur = array[i];
            if (!used[cur] ||(index > cur && array[index - cur - 1] == cur)){
                swap(array, index, i);
                used[cur] = !used[cur];
                if (helper(array, index + 1, used)){
                    return true;
                }
                swap(array, index, i);
                used[cur] = !used[cur];
            }
        }
        return false;
    }

    private void swap(int[] array, int index, int i){
        int tmp = array[index];
        array[index] = array[i];
        array[i] = tmp;
    }

    public static void main(String[] args) {
        KeepDistanceForIdenticalElements kfe = new KeepDistanceForIdenticalElements();
        kfe.keepDistance(3);
    }
}
