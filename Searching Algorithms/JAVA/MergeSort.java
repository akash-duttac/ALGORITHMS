/* MERGE SORT
 * Merge sort is a sorting technique based on divide and conquer.
 * With worst case time complexity being O(n log n).
 * Merge sort divides the array into equal halves and then combines
 * them in a sorted manner.
 * 
 *                  Time Complexity: 
                    O(n log n) - worst case
                    θ(n log n) - average case
                    Ω(n log n) - best case
                    Space Complexity: O(log n)
 */

import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {
    static int[] arr, mergeArr;
    static int n;

    public static void merging(int low, int mid, int high){
        int l1 = low;
        int l2 = mid+1;
        int i;
        for (i=low; l1<=mid && l2<=high; i++){
            if (arr[l1] <= arr[l2])
                mergeArr[i] = arr[l1++];
            else
                mergeArr[i] = arr[l2++];
        }
        while (l1<=mid)
            mergeArr[i++] = arr[l1++];
        while (l2<=high)
            mergeArr[i++] = arr[l2++];
        for (i=low; i<=high; i++)
            arr[i] = mergeArr[i];
    }
    public static void sort(int low, int high){
        if (low < high){
            int mid = (low+high)/2;
            sort(low,mid);
            sort(mid+1,high);
            merging(low,mid,high);
        }
        else
            return;
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        System.out.print("Enter array size: ");
        n = get.nextInt();
        arr = new int[n];
        mergeArr = new int[n];
        System.out.print("Input the array elements: ");
        for (int i=0; i<n; i++)
            arr[i] = get.nextInt();
        System.out.println("The entered array: "+Arrays.toString(arr));
        sort(0,arr.length-1);
        System.out.println("The sorted array: "+Arrays.toString(mergeArr));
        get.close();
    }
}
