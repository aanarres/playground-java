package xyz.anarres.algos;

import java.util.Arrays;
import java.util.List;

/**
 * Hoare partition scheme
 * algorithm quicksort(A, lo, hi) is
    if lo < hi then
        p := partition(A, lo, hi)
        quicksort(A, lo, p)
        quicksort(A, p + 1, hi)

algorithm partition(A, lo, hi) is
    pivot := A[ floor((hi + lo) / 2) ]
    i := lo - 1
    j := hi + 1
    loop forever
        do
            i := i + 1
        while A[i] < pivot
        
        do
            j := j - 1
        while A[j] > pivot
        
        if i ≥ j then
            return j
            
        swap A[i] with A[j]
 * 
 * quicksort(A, 0, length(A) - 1)
 */
public class QuicksortHoare {

	public void quicksort(int[] a, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int p = partition (a, lowIndex, highIndex);
			quicksort(a, lowIndex, p);
			quicksort(a, p + 1, highIndex);
		}
	}
	
	private int partition (int[] a, int lowIndex, int highIndex) {
		int pivot = a[(highIndex + lowIndex) / 2];
		int i = lowIndex - 1;
		int j = highIndex + 1;
		
		do {
			do {
				i++;
			} while (a[i] < pivot);
			
			do {
				j--;
			} while (a[j] > pivot);
			
			if (i >= j) {
				return j;
			}
			swap (a, i, j);
		}
		while (lowIndex >= 0);
		
		throw new RuntimeException("oops!!!");
	}
	public static void main(String[] args) {
		// tests
		QuicksortHoare sort = new QuicksortHoare();
		int[] a = new int[] {2, 3, 4, 6, 1, 10, 12, 0};
		System.out.print("initial: " + Arrays.toString(a));
		sort.quicksort(a, 0, a.length - 1);
		System.out.println(" final: " + Arrays.toString(a));
	}
	
	private void swap (int[] a, int i, int j) {
		System.out.println("swapping (" + a[i] + ", " + a[j] + ")");
		int m = a[i];
		a[i] = a[j];
		a[j] = m;
	}

}
