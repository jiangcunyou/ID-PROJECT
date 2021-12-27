package Laicode.practice.Search;

public class BS_basic {

    public static void main(String[] args) {

//        int[] array = {1,2,3,5,6,7,9};
//        int target = 5;
//
//        int result = binarysearch(array, target);
//        System.out.println(result);

//        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
//
//        int target = 6;
//
//        boolean result = Binary2D(array, target);
//
//        System.out.println(result);

//        int[] array = {2,3,42,432,456,61};
//        int target = 77;
//
//        int close = closestelement(array, target);
//        System.out.println(close);


//        int[] array = {1,1,1,2,2,2,3,4,4,4,5};
//
//        int target = 2;
//
//        int result = bslastelement(array, target);
//
//        System.out.println(result);

//        int[] array = {1,2,3,4,6,7,9,10,12,13};
//        int target = 5;
//        int k = 3;
//
//        int[] result = kclosestelement(array, target, k);
//
//        for (int i = 0; i < result.length; i ++){
//            System.out.println(result[i]);
//        }

//        int[] array = {1,2,3,4,5};
//        int target = 3;
//
//        int result = bssmallestelement(array,target);
//
//        System.out.println(result);

        int k = 7;
        System.out.println(k / 2);

    }

    /*Basic Binarysearch*/
    public static int binarysearch(int[] array, int target){

        int left = 0;
        int right = array.length - 1;

        while (left <= right){

            int mid = left + (right - left) / 2;

            if (array[mid] == target){
                return mid;
            }else if (array[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    /*
    * Classical Binary search in 2D space
    *
    * 2D matrix, sorted on each row, first element of next row is larger(or equal) to the last element
    * of previous row, now giving a target number, returning the position that the target locates within
    * the matrix.
    * */

    public static boolean Binary2D(int[][] matrix, int target){

        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;


        while (left <= right){

            int mid = left + (right - left) / 2;

            if (matrix[mid / col][mid % col] == target)
                return true;
            else if (matrix[mid / col][mid % col] > target)
                right = mid - 1;
            else left =  mid + 1;
        }

        return false;
    }

    /*
    * Closest element to target.
    *
    * How to find an element in the array that is closest to the target number?
    * */

    public static int closestelement(int[] array, int target){

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1){
            int mid = left + (right - left) / 2;

            if (array[mid] == target)
                return mid;
            else if (array[mid] > target)
                    right = mid;
            else left = mid;

            if (Math.abs(array[left] - target) <= Math.abs(array[right] - target))
                return left;
            else return right;

        }
        return 0;
    }

    /*
    * First Target
    * How to return the index of the first occurrence of an element
    * */

    public static int bsfirstelement(int[] array, int target){

        int left = 0;
        int right = array.length - 1;

        while(left < right - 1){

            int mid = left + (right - left) / 2;

            if (target == array[mid])
                right = mid;
            else if (target > array[mid])
                left = mid;
            else right = mid;
        }
        if (array[left] == target)
            return left;
        if (array[right] == target)
            return right;

        return -1;
    }

    /*
    * Last occurrence
    * How to return the index of the last occurrence of an element
    * */

    public static int bslastelement(int[] array, int target){

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1){

            int mid = left + (right - left) / 2 ;

            if (array[mid] == target)
                return left = mid;
            else if (array[mid] > target)
                right = mid;
            else left = mid;
        }

        if (array[right] == target)
            return right;
        if (array[left] == target)
            return left;

        return -1;
    }

    /*
    * K closest elements in sorted array
    * */
    public static int[] kclosestelement(int[] array, int target, int k){

        if(array == null || array.length == 0)
            return new int[0];

        if (k == 0)
            return new int[0];

        if (k >= array.length)
            return array;

        int left = closestelement(array, target);
        int right = left + 1;

        int[] result = new int[k];

        for (int i = 0; i < k; i++)
        {
            if (right >= array.length || left >= 0 && (Math.abs((array[left] - target)) <= Math.abs(array[right] - target) ))
                result[i] = array[left --];
            else
                result[i] = array[right ++];

        }


        return result;
    }

    /*
    * Smallest that is larger than the target
    * */
    public static int bssmallestelement(int[] array, int target){

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1){

            int mid = left + (right - left) / 2;

            if (array[mid] == target)
                left = mid;
            else if (array[mid] > target)
                right = mid;
            else left = mid;
        }

        if (array[left] > target)
            return array[left];
        if (array[right] > target)
            return array[right];

        return -1;
    }

    /*
    * K-th smallest in two sorted arrays
    * */
    private int kth(int[] a, int aleft, int[] b, int bleft, int k){

        if (aleft >= a.length)
            return b[bleft + k -1];
        if (bleft >= b.length)
            return a[aleft + k - 1];

        if (k == 1)
            return Math.min(a[aleft], b[bleft]);

        int amid = aleft + k / 2 -1;
        int bmid = bleft + k / 2 -1;

        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

        if (aval <= bval)
            return kth(a, amid + 1, b, bleft, k - k / 2);
        else return kth(a, aleft, b, bmid + 1, k - k /2);

    }

}
