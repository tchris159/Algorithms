/* Bubble sort, is a simple sorting algorithm that works by repeatedly stepping through the list to be sorted, 
 * comparing each pair of adjacent items and swapping them if they are in the wrong order. The pass through the 
 * list is repeated until no swaps are needed, which indicates that the list is sorted. The algorithm gets its 
 * name from the way smaller elements "bubble" to the top of the list.
 */

public static int[] bubbleSortArray(int[] arr) {
    if (arr.length < 1) {
        return arr;
    }

    for (int i = 0; i < arr.length-1; i++) { //less than one for 0 based indexing
        for (int j = 0; j < arr.length-i-1; j++) { // inner loop decrements by pass number
            if (arr[j] > arr[j+1]) {
                // if the current element is larger than its following perform swap.
                // intialize temp variable
                int temp = arr[j]; //assign temp to the current element before swapping it with the larger
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    } 
    return arr;
}
