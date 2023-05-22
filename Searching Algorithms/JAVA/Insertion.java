/* INSERTION SORT */
/*
 * Insertion sort is in-place comparison based sorting algorithm.
 * A sub-list is maintained which is always sorted.
 * For e.g., the lower part of an array is maintained to be sorted.
 * A element which is to be inserted in the sorted sub-list,
 * has to find its appropriate place and insert it here.
 * 
 * The array is searched sequentially and unsorted items are moved
 * and inserted into sorted sub-list (in the same array).
 * Not suitable for large data sets as its average and worst case
 * complexity are of O(n^2) where n are no. of items.
 * 
 * Time Complexity: 
 *                  O(n^2) - worst case
 *                  θ(n^2) - average case
 *                  Ω(n) - best case
 * Space Complexity: O(1)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Insertion {
    static int[] arr;
    static int n;
    public static void insertion_sort(){
        for (int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while (j>=0 && key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        System.out.print("Enter array size: ");
        n = get.nextInt();
        arr = new int[n];
        System.out.print("Input array elements: ");
        for (int i=0; i<n; i++)
            arr[i] = get.nextInt();
        insertion_sort();
        System.out.println("Sorted Array is: "+Arrays.toString(arr));
        get.close();
    }
}
