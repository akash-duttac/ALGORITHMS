/* BUBBLE SORT 
This sorting algorithm is comparison based  algorithm  in 
which  each  pair  of  adjacent  elements  is  compared  and  
elements  are  swapped  if  they  are  not  in  order. 
This  algorithm  is  not  suitable  for large data sets as its average  
and  worst  case  complexity  is  of  O(n^2) 
where n are no. of items. 

    Time Complexity: 
                    O(n^2) - worst case
                    θ(n^2) - average case
                    Ω(n) - best case
    Space Complexity: O(1)
*/

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort{
    static int[] arr;
    static int n;
    public static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
    public static void bubble_sort(){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length-i-1; j++){
                if (arr[j]>arr[j+1]){
                swap(j,j+1);
                }
            }
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
        bubble_sort();
        System.out.println("Sorted Array is: "+Arrays.toString(arr));
        get.close();
    }
}