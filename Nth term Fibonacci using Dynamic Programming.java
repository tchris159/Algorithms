import java.util.HashMap;

/**
 * Fibonacci number are the numbers in the following integer sequence, called
 * the Fibonacci sequence, and characterized by the fact that every number after
 * the first two is the sum of the two preceding ones
 * 
 * For example: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 * 
 * In any given sequence of Fn, it often represent as Fn = Fn-1 + Fn-2
 * 
 * The basic idea of Dynamic Programming is to save the result of the subproblem
 * so that if we see it again in the future. We can simply use it instead of
 * recomputing the value again. In the long run, it should save some or a lot of
 * time which reduces the running time complexity of the problem.
 * 
 * Below is the code for the naive solution, and then optimized solutions
 * following. The beginning naive recursive solution is highly inefficient at
 * runtime of: O(n^2)
 * 
 * Various optimization for time and space complexity follow.
 */

public class FibonacciNumber {

    /*
     * When visualized in a tree diagram, the example n = 7 would look consist of
     * the number 7 has being computed 1 time. Number 6 has being repeatly computed
     * 2 times. Number 5 has being repeatly computed 3 times. Number 4 has being
     * repeatly computed 5 times. Number 3 has being repeatly computed 8 times. The
     * times grow as the number n gets larger.
     * 
     * @param int n
     */

    public int getFibonacciNumberRecursively(int n) {

        // first two numbers of the series
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        // recursive approach
        return getFibonacciNumberRecursively(n - 1) + getFibonacciNumberRecursively(n - 2);
    }

    /**
     * Memoization is an optimization technique used primarily to speed up computer
     * programs by storing the results of expensive function calls and returning the
     * cached result when the same inputs occur again. We do that here with a
     * HashMap.
     * 
     * This resulted in improvements in runtime; however, space complexity increased
     * to O(N) because we are using a HashMap to store the results.
     */
    public HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    public int getFibonacciNumberTopDown(int n) {

        // checks if the n has already been solved
        if (hm.containsKey(n))
            return hm.get(n);

        // first two
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        // store the value recursively and then return
        int nthValue = getFibonacciNumberTopDown(n - 1) + getFibonacciNumberTopDown(n - 2);
        hm.put(n, nthValue);
        return nthValue;
    }

    /**
     * Utilizing an iterator, this is then evlauated in their correct order.
     * @param n
     * @return
     */    

    public int getFibonacciNumberBottomUpWithCache(int n) {

        // first two in the series
        hm.put(0, 0);
        hm.put(1, 1);

        // for numbers up to n, use recursion to store the values in a hashtable
        for (int i = 2; i <= n; i++) {
            hm.put(i, hm.get(i - 1) + hm.get(i - 2));
        }
        return hm.get(n);
    }


    /**
     * This next solution takes the formerly O(n^2) and prunes it into what would look like
     * a linkedlist or degnerate tree to improve space complexity. Each number in the sequence
     * only gets computed once. The running time as a result is improved to O(n). 
     * A further optimization is that we don't need to save all the results to cache and waste
     * O(n) space. We can use constant space and store partial results that are necessary.
     * 
     * @param int n
     */

    public int getFibonacciNumberBottomUpWithoutCache(int n) {
        // last two numbers used to compute sum
        int fnMin2 = 0;
        int fnMin1 = 1;
        int sum = 0;

        for(int i = 2; i <= n; i++) {
          

          // iteratively swap and update the numbers to achieve constant time
          // and eliminate the need for a HashMap O(n) vs. O(1).
          sum = fnMin1 + fnMin2; 
          fnMin2 = fnMin1;
          fnMin1 = sum;
        }
        return sum;
      }
}