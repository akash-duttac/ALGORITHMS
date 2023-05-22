/* SELECTION SORT
 * Selection sort is a in-place comparison based algorithm in which
 * the list is divided into two parts.
 * Sorted part at left end and unsorted part at right end.
 * Initially sorted part is empty and unsorted part is entire list.
 * 
 * Smallest element is selected from the unsorted array and 
 * swapped with the leftmost element and that element becomes
 * part of sorted array.
 * This process continues moving unsorted array boundary by one
 * element to the right.
 * This algorithm is not suitable for large data sets as its average
 * and worst case complexity are of O(n^2) where n are no. of items
 * 
 *          Time Complexity: 
                    O(n^2) - worst case
                    θ(n^2) - average case
                    Ω(n) - best case
            Space Complexity: O(1)
 */

import java.util.Scanner; 
import java.util.Arrays;

public class SelectionSort {
    static int[] arr;
    static int n;

    public static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selection_sort(){
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++)
                if (arr[j] < arr[i])
                swap(i,j);
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
        selection_sort();
        System.out.println("Sorted Array is: "+Arrays.toString(arr));
        get.close();
    }
}
