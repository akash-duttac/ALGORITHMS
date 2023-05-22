/* RADIX SORT
 * Digit by digit sort starting from least significant to most significant digit.
 * Let, w: word size and n: number of elements
 *              Time Complexity: 
                    O(w*n) - worst case
                    θ(w*n) - average case
                    Ω(w*n) - best case
                    Space Complexity: O(w+n)
 */

import java.util.Scanner;
import java.util.Arrays;

public class RadixSort {
    static int[] arr;
    static int n;

    public static int getMax(){
        int max = arr[0];
        for (int i=0; i<n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
    public static void countSort(int exp){
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count,0);

        for (int i=0; i<n; i++){
            int index = (arr[i]/exp)%10;
            count[index]++;
        }
        for (int i=1; i<10; i++)
            count[i] += count[i-1];
        for (int i=n-1; i>=0; i--){
            int index = (arr[i]/exp)%10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }
        for (int i=0; i<n; i++)
            arr[i] = output[i];
    }
    public static void radixSort(){
        int m = getMax();
        for (int exp=1; m/exp>0; exp*=10)
            countSort(exp);
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        n = get.nextInt();
        arr = new int[n];
        System.out.print("Input the array elements: ");
        for (int i=0; i<n; i++)
            arr[i] = get.nextInt();
        System.out.println("Input Array: "+Arrays.toString(arr));
        radixSort();
        System.out.println("Sorted Array: "+Arrays.toString(arr));
        get.close();
    }
}
