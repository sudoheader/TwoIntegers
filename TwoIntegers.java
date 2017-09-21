import java.util.*;
public class TwoIntegers {

    public static void main(String[] args) {
        int[] s = { 1, 2, 3 };
        int[] t = { 4, 5, 6 };
        int y = 0;
        twoIntegers(s, t, y);
    }
    
    private static boolean twoIntegers(int[] a, int[] b, int x) {
        mergeSort(a);
        mergeSort(b);
        int i = 0;
        int j = b.length - 1;
        while(i < a.length && j >= 0) {
            if(a[i] + b[j] == x) return true;
            else if(a[i] + b[j] < x) i += 1;
            else j -= 1;
        }
        return false;
    }

    private static void mergeSort(int[] a) {
        if (a.length >= 2) {
            // split array in half
            int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);
            
            // sort the halves
            mergeSort(left);
            mergeSort(right);
            
            // merge them back together
            int firstHalf = 0;
            int secondHalf = 0;
            for (int i = 0; i < a.length; i++) {
                if (secondHalf >= right.length ||
                        (firstHalf < left.length && left[firstHalf] < right[secondHalf])) {
                    a[i] = left[firstHalf];
                    firstHalf++;
                } else {
                    a[i] = right[secondHalf];
                    secondHalf++;
                }
            }
        }
    }
} 