import java.util.Arrays;

/**
 * 
 * You are given an integer array nums of size n where n is a multiple of 3 and
 * a positive integer k.
 * 
 * Divide the array nums into n / 3 arrays of size 3 satisfying the following
 * condition:
 * 
 * The difference between any two elements in one array is less than or equal to
 * k.
 * Return a 2D array containing the arrays. If it is impossible to satisfy the
 * conditions, return an empty array. And if there are multiple answers, return
 * any of them.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * 
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * 
 * Explanation:
 * 
 * The difference between any two elements in each array is less than or equal
 * to 2.
 * 
 * Example 2:
 * 
 * Input: nums = [2,4,2,2,5,2], k = 2
 * 
 * Output: []
 * 
 * Explanation:
 * 
 * Different ways to divide nums into 2 arrays of size 3 are:
 * 
 * [[2,2,2],[2,4,5]] (and its permutations)
 * [[2,2,4],[2,2,5]] (and its permutations)
 * Because there are four 2s there will be an array with the elements 2 and 5 no
 * matter how we divide it. since 5 - 2 = 3 > k, the condition is not satisfied
 * and so there is no valid division.
 * 
 * Example 3:
 * 
 * Input: nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14
 * 
 * Output: [[2,2,2],[4,5,5],[5,5,7],[7,8,8],[9,9,10],[11,12,12]]
 * 
 * Explanation:
 * 
 * The difference between any two elements in each array is less than or equal
 * to 14.
 * 
 */

public class ArraysWithMaxDifference {

  public static int[][] divideArray(int[] nums, int k) {
    Arrays.sort(nums);
    int sz = nums.length;
    // 2,2,2,2,4,5
    int i = 0;
    boolean isValid = true;
    int[][] ans = new int[sz / 3][3];
    int j = 0;
    while (i < sz && i + 2 < sz) {
      isValid = (nums[i + 2] - nums[i] <= k) ? true : false;
      if (isValid) {
        ans[j] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
        j++;
      }

      if (!isValid)
        break;
      i += 3;
    }

    if (!isValid)
      return new int[0][];
    else
      return ans;
  }

  public static void main(String[] args) {
    int nums[] = { 4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11 };
    int k = 14;

    System.out.println("Resultant Array when dividing the arrays with max difference k: ");
    System.out.println(divideArray(nums, k));
  }
}
