/* QUICK SORT
 * It is based on partitioning of array of data into smaller arrays.
 * A large array is partitioned into two arrays one of which holds
 * values smaller than specified value (say pivot) based on which the
 * partition is made and another array holds values greater than pivot
 * value. 
 * The quick sort partitions an array and then calls itself recursively
 * twice to sort the resulting two sub-array.
 * 
 *              Time Complexity: 
                    O(n^2) - worst case
                    θ(n log n) - average case
                    Ω(n log n) - best case
                Space Complexity: O(log n)
 */

import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {
    static int n;
    static int[] arr;
    
    public static void swap(int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static int partition(int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for (int j=low; j<=high-1; j++){
            if (arr[j] < pivot){
                i++;
                swap(i,j);
            }
        }
        swap(i+1,high);
        return i+1;
    }
    public static void quickSort(int low, int high){
        if (low < high){
            int partitionIndex = partition(low,high);
            quickSort(low, partitionIndex-1);
            quickSort(partitionIndex+1, high);
        }
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = get.nextInt();
        arr = new int[n];
        System.out.print("Input the array elements: ");
        for (int i=0; i<n; i++)
            arr[i] = get.nextInt();
        System.out.println("The inputted array is "+Arrays.toString(arr));
        quickSort(0, arr.length-1);
        System.out.println("The sorted array is "+Arrays.toString(arr));
        get.close();
    }
}
