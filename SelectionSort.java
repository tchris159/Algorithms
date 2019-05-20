public class SelectionSort {

    public void sort(int[] data) {

        for (int position = 0; position < data.length - 1;  position++) {
            int smallestSoFar = position; // record the index of the smallest element

            // the indexing for loop changes, because the smallest will have been found, 
            // and the algorithm will iteratively find the smallest until the end of the array.
            for (int i = position + 1; i < data.length; i++) {
                if (data[i] < data[smallestSoFar]) {
                    smallestSoFar = i; // compare every element to in the pass to find the smallest
                }
            // perform swap so the smallest is at the appropriate position 
            }
        }
    }
}

/** 
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element 
 * (considering ascending order) from unsorted part and putting it at the beginning. The 
 * algorithm maintains two subarrays in a given array.
 * 
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 * In every iteration of selection sort, the minimum element (considering ascending order) 
 * from the unsorted subarray is picked and moved to the sorted subarray.
 * 
 * It is both inplace and stable, and good for small amounts of data. 
 * 
 * Runtimes:
 * 
 * Best, Average, and Worst case are all O(n^2)
 * 
 * 
 * 
 */
