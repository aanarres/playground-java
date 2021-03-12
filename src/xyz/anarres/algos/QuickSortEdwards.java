package xyz.anarres.algos;

import java.util.Arrays;

/**
 * Lomuto algo = pivot at the end
 * https://www.youtube.com/watch?v=4IE3wIXFVPc
 * i = from..to
 * counter = the first element larger than the pivot
 * pivot = the end of the current array
 */
public class QuickSortEdwards<E> {
	E[] array;
	static int swaps = 0;

	public static void main(String[] args) {
		// tests
		QuickSortEdwards<Integer> sort = new QuickSortEdwards<Integer>();
		
		/*
		sort.array = new Integer[] {2, 2, 2, 2};
		System.out.println("initial: " + Arrays.toString(sort.array));
		sort.sort(sort.array);
		System.out.println(" final: " + Arrays.toString(sort.array));
		System.out.println(swaps + " swaps");
		*/
		
		swaps = 0;		
		sort.array = new Integer[] {2, 3, 4, 6, 1, 10, 12, 0, 13};
		System.out.println("initial: " + Arrays.toString(sort.array));
		sort.sort(sort.array);
		System.out.println(" final: " + Arrays.toString(sort.array));
		System.out.println(swaps + " swaps");
		
	}
	
	public E[] sort(E[] array) {
		this.array = array;
		quicksort (0, array.length - 1);
		return array;
	}

	private void quicksort(int from, int to) {
		if (from >= to) {
			// single element or empty
			return;
		}
		System.out.println("from " + from + " to " + to + " with pivot=" + array[to]);
		
		E value = array[to]; // our "to" is pivot, remember its value
		int counter = from; // the first thing that's larger than the pivot point
		for (int i = from; i < to; i++) {
			// if (array[i] < value)
			// we know the higher, it's at counter; we're looking for the smaller (than pivot)
			System.out.println("i=" + i + ", looking for smaller at a[i]=" + array[i] + " when the first higher number than " + value + " is..."
					+ " maybe " + array[counter] + " ?");
			if (((Comparable<E>) array[i]).compareTo(value) <= 0) {
				if (i != counter)
					swap (i, counter);
				counter++;
			}
		}
		swap (counter, to); // swap the pivot point
		System.out.println("calling with from=" + from + ", to=" + to + " and counter=" + counter);
		quicksort(from, counter - 1);
		quicksort(counter + 1, to);
		
	}
	private void swap (int i, int j) {
		System.out.println("swapping (" + array[i] + ", " + array[j] + ")");
		E m = array[i];
		array[i] = array[j];
		array[j] = m;
		swaps++;
		System.out.println(swaps + ": " + Arrays.toString(array));
	}
}
