import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Quick sort is a comparision based Divide and Conquer sorting algorithm.
 * 
 * In QuickSort we first partition the array in place such that all elements to
 * the left of the pivot element are smaller, while all elements to the right of
 * the pivot are greater that the pivot. Then we recursively call the same
 * procedure for left and right subarrays.
 * 
 * Runtimes:
 * 
 * n comparisons and log(n) partitions Best Case: O(n * log(n)) Average Case:
 * O(n * log(n)) Worst Case: O(n^2)
 * 
 * Quick sort's runtime performance depends on the strategy for choosing pivots.
 * If the pivot is chosen as the left or rightmost element, then the partitions
 * will degenerate into gauss's formula and O(n) partitions. This occurs when:
 * 
 * The array is already sorted in the same order The array is already sorted in
 * reverse order All of the elements are the same
 * 
 * Ideally, we want the quicksort algorithm to bisect the array. If the array is
 * presorted, and it always chooses the end pivot, then the partition procedure
 * splits an n-length array into arrays of size 1 and n-1, and this unlucky
 * selection of pivots requires O(n) recursive calls --> O(n^2) runtime.
 * 
 * The algorithm below implements a randomized choice of pivot to help mitigate
 * this.
 * 
 * Limitations: With this modifications, the worst case of Quick sort has less
 * chances to occur, but worst case can still occur if the input array is such
 * that the maximum (or minimum) element is always chosen as pivot.
 * 
 */

public class QuickSort {
    public static void main(String[] args) {

        Random random = new Random(); // random number generator

        ArrayList<Integer> arr = new ArrayList<>(); // Array list of Integer Objects
        // autoboxing feature in java

        for (int i = 0; i < 100; i++) { // add 100 random numbers to the arraylist
            arr.add(random.nextInt(1000));
        }
        System.out.println("Generate unsorted random ArrayList: ");
        System.out.println(arr);
        System.out.println();

        // Edge case: If the input array to be sorted is size one
        if (arr.size() == 1) {
            return;
        }

        // Edge case: If the input array is already in increasing or decreasing sorted
        // order
        if (preSortChecker(arr)) {
            System.out.println(
                 "Array is already sorted! Quicksort will not be effective...");
        }

        int n = arr.size();

        // make a call to the private quicksort method

        quickSort(arr, 0, n - 1);

        // display the new sorted array
        System.out.println(arr);
    }

    // Private Methods ///////////////////////////////////////
    //////////////////////////////////////////////////////////

    /**
     * This is the main quicksort method utilizing recrusive calls on both sides of the pivot. 
     * 
     * @param arr        array to sort
     * @param startIndex lower bound
     * @param endIndex   upper bound
     */

    private static void quickSort(ArrayList<Integer> arr, int startIndex, int endIndex) {

        ///////////////////// start of the recursion //////////////////////

        if (startIndex < endIndex) {
            int pivot = randomizedPartition(arr, startIndex, endIndex);
            
            quickSort(arr, startIndex, pivot - 1); // recursively call on the subarray containing elements lower than
                                                   // the pivot
            quickSort(arr, pivot + 1, endIndex); // recursively call on subarray containing elements greater than the
                                                 // pivot
        }
    }

    /**
     * Instead of naively choosing one of the ends to be the pivot, a random element
     * from the subarray will be chosen. This is done by exchanging the end element
     * with an element chosen at random from index start to end of the array. By
     * randomly sampling a pivot from range end - start + 1, we expect the split of
     * the array to be reasonably well balanced.
     * 
     * @param arr        sub array to partition
     * @param startIndex lower bound
     * @param endIndex   upper bound
     */
    private static int randomizedPartition(ArrayList<Integer> arr, int startIndex, int endIndex) {

        Random random = new Random();
        int pivotIndex = startIndex + random.nextInt(endIndex - startIndex + 1); // random pivot selection.

        Collections.swap(arr, endIndex, pivotIndex); // swap the end with the randomly selected element.

        return partition(arr, startIndex, endIndex); // makes a call to partition
    }

    /**
     * The key process in quicksort is partition(), given an array and element x as
     * a pivot, place x at its correct position with all smaller elements placed to the left
     * and all elements larger to the right of the pivot, performed in O(n) linear time.
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */

    public static int partition(ArrayList<Integer> arr, int startIndex,int endIndex) {

        int pivotValue = arr.get(endIndex); // get the elemeent
        int pivotIndex = startIndex; 
        // point the index to 0, and increment to compare to all elements and find the correct index location for the pivot

        for (int j = startIndex; j < endIndex; j++) { // iterate through the subarray

            if (arr.get(j) <= pivotValue) { // if the current element is less than or equal to the pivot value

                Collections.swap(arr, pivotIndex, j); // swap if the element is less than the pivot's value. 
                // this swap pushes the pivot along the array until it is in the correct location

                pivotIndex = pivotIndex + 1; // record the location for where the pivot should go 
            }
        }

        Collections.swap(arr, pivotIndex, endIndex); // finally, we place the pivot at the correct position
        // by swapping the pivot with the last element. 
        return pivotIndex;
    }


    // Visual for partition()
    // i = 3 
    // arr[] = {10, 30, 40, 50, 80, 90, 70} // 90 and 50 Swapped 
    
    // We come out of loop because j is now equal to high-1.
    // Finally we place pivot at correct position by swapping
    // arr[i+1] and arr[high] (or pivot) 
    // arr[] = {10, 30, 40, 50, 70, 90, 80} // 80 and 70 Swapped 
    
    // Now 70 is at its correct place. All elements smaller than
    // 70 are before it and all elements greater than 70 are after
    // it.

    

    /**
     * Private method to check if ArrayList is sorted or not sorted already.
     * @params arr array to check if it is sorted
     * @return boolean whether or not array is sorted or not 
     */

    private static boolean preSortChecker(ArrayList<Integer> list) {

        // if the size
        if (list.size() <= 2) {
            return true;
        }
        boolean sorted = true;

        for (int i = 1; i < list.size(); i++) {

            // descending
            if (list.get(i-1) >= (list.get(i)) ) {
                sorted = true;
            }

            // ascending
            if (list.get(i-1) <= (list.get(i)) ) {
                sorted = true;
            } else {
                sorted = false;
            }
        } 
        return sorted;
    }
}