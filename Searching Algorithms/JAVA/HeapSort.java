/* HEAP SORT
 * Comparison based sorting technique based on Binary Heap data structure.
 * Since a binary heap is a complete binary tree, it can be easily represented
 * as an array and array based representation is space efficient.
 * If the parent node is stored at index i, the left child can be calculated
 * by 2*i + 1, and right child by 2*i +2 (assuming index starts at 0)
 * 
 *                  Time Complexity: 
                    O(n log n) - worst case
                    θ(n log n) - average case
                    Ω(n log n) - best case
                    Space Complexity: O(1)
 */

import java.util.Scanner;
import java.util.Arrays;

public class HeapSort {
    static int[] arr;
    static int n;

    public static void swap(int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void sort(){
        int N = arr.length;
        for (int i=N/2-1; i>=0; i--)
            heapify(N,i); 
        for (int i=N-1; i>0; i--){
            swap(0,i);
            heapify(i,0);
        }
    }
    public static void heapify(int N, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if (left < N && arr[left] > arr[largest]) 
            largest = left;
        if (right < N && arr[right] > arr[largest])
            largest = right;
        if (largest != i){
            swap(i,largest);
            heapify(N, largest);
        }
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        n = get.nextInt();
        arr = new int[n];
        System.out.print("Input the array elements: ");
        for (int i=0; i<n; i++)
            arr[i] = get.nextInt();
        System.out.println("Input array: "+ Arrays.toString(arr));
        sort();
        System.out.println("Sorted array: "+ Arrays.toString(arr));
        get.close();
    }
}

